#!/bin/bash

SERVICE_NAME=$1
PORT=$2
NAME_SPACE=$3

echo "SERVICE_NAME:$SERVICE_NAME;PORT=$PORT"
POD_NAME=$(kubectl get pods --namespace "$NAME_SPACE" | cut -d" " -f1 | grep ^"$SERVICE_NAME")
echo "POD_NAME:$POD_NAME"
CONTAINER_PORT=$(kubectl get pod --namespace "$NAME_SPACE" "$POD_NAME" -o jsonpath="{.spec.containers[0].ports[0].containerPort}")
echo "CONTAINER_PORT:$CONTAINER_PORT"
echo "Visit http://127.0.0.1:$PORT to use your application"
kubectl --namespace "$NAME_SPACE" port-forward "$POD_NAME" "$PORT:$CONTAINER_PORT" &
