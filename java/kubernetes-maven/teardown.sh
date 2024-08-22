kubectl delete service "${SERVICE_NAME}"
kubectl delete pod "${POD_NAME}"
kubectl delete datadogagent datadog
kubectl delete secret datadog-secret
helm delete my-datadog-operator
