# create a pod
envsubst < pod.yml | kubectl create -f -

# list pods
kubectl get pods

# list containers in a pod
kubectl get pod maven-test-runner -o jsonpath="{.spec['containers','initContainers'][*].name}"

# access logs of a container inside a pod
kubectl logs -f maven-test-runner -c maven-test

# delete a pod (to “restart” a pod, delete it and re-create)
kubectl delete pod maven-test-runner

# get container state
kubectl get pod maven-test-runner -o jsonpath='{.status.containerStatuses[?(@.name=="maven-test")]}'
