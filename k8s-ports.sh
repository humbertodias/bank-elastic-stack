#!/bin/bash

export POD_NAME=`kubectl get pods | cut -d" " -f1 | grep ^web`
export CONTAINER_PORT=`kubectl get pod --namespace default $POD_NAME -o jsonpath="{.spec.containers[0].ports[0].containerPort}"`
echo "Visit http://127.0.0.1:3001 to use your application"
kubectl --namespace default port-forward $POD_NAME 3001:$CONTAINER_PORT

