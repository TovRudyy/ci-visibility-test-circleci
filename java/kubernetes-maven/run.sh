#!/bin/bash

POD_NAME="maven-test-runner"

SERVICE_NAME="debug-service"

CONTAINER_NAME="maven-test"

# Initial sleep duration (in seconds) before checking pod status
SLEEP_DURATION=1

# Maximum number of retries to check pod status
MAX_RETRIES=180

# Current number of attempts
attempt=0

get_pod_phase() {
    kubectl get pod "${POD_NAME}" -o jsonpath='{.status.phase}'
}

is_pod_initializing() {
    kubectl get pod "${POD_NAME}" -o jsonpath='{.status.conditions[?(@.type=="Initialized")].status}'
}

get_container_status() {
    kubectl get pod "${POD_NAME}" -n "${NAMESPACE}" -o jsonpath="{.status.containerStatuses[?(@.name=='${CONTAINER_NAME}')].state}"
}

get_agent_status() {
    kubectl get DatadogAgent datadog -o jsonpath="{.status.agent.state}"
}

get_cluster_agent_status() {
    kubectl get DatadogAgent datadog -o jsonpath="{.status.clusterAgent.state}"
}

./teardown.sh

helm install my-datadog-operator datadog/datadog-operator
kubectl create secret generic datadog-secret --from-literal api-key=$(cat $HOME/.dd.prod.api.key) --from-literal app-key=$(cat $HOME/.dd.prod.application.key)
kubectl apply -f datadog-agent.yml

while [ $attempt -lt $MAX_RETRIES ]; do
    agentStatus=$(get_agent_status)
    clusterAgentStatus=$(get_cluster_agent_status)

    if [ "$agentStatus" == "Running" ] && [ "$clusterAgentStatus" == "Running" ]; then
        echo "Agent and cluster agent started, proceeding"
        break
    else
        echo "Waiting for agent to start ($agentStatus) and cluster agent to start ($clusterAgentStatus)"
        sleep $SLEEP_DURATION
    fi
    ((attempt++))
done

if [ $attempt -eq $MAX_RETRIES ]; then
    echo "Maximum number of retries reached while waiting for pod ${POD_NAME} to initialize."
    exit 1
fi

envsubst < pod.yml | kubectl create -f -
kubectl create -f service.yml

attempt=0

while [ $attempt -lt $MAX_RETRIES ]; do
    phase=$(get_pod_phase)
    initialized=$(is_pod_initializing)

    if [ "$phase" != "Pending" ] || [ "$initialized" == "True" ]; then
        echo "Pod ${POD_NAME} has finished initializing."
        break
    else
        echo "Waiting for pod ${POD_NAME} to finish initializing..."
        sleep $SLEEP_DURATION
    fi
    ((attempt++))
done

if [ $attempt -eq $MAX_RETRIES ]; then
    echo "Maximum number of retries reached while waiting for pod ${POD_NAME} to initialize."
    exit 1
fi

kubectl logs -f "${POD_NAME}" -c scm

while true; do
    STATUS=$(get_container_status)

    if [[ "$STATUS" == *'running'* ]]; then
        echo "Container ${CONTAINER_NAME} has started."
        break
    elif [[ "$STATUS" == *'terminated'* ]]; then
        echo "Container ${CONTAINER_NAME} has terminated."
        break
    elif [[ "$STATUS" == "" ]]; then
        echo "Container ${CONTAINER_NAME} not found."
        exit 1
    else
        echo "Container ${CONTAINER_NAME} is not running yet."
    fi
    
    sleep $SLEEP_DURATION
done

kubectl logs -f "${POD_NAME}" -c "${CONTAINER_NAME}"
