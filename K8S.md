# Kubernetes - Native

Enabling docker over k8s.

![](doc/rancher-kubernetes.png)

now

```
make k8s-start
```

Then access 

http://localhost:3001

and 

http://localhost:3002

Scale

```
kubectl scale --replicas=2 deployment/account -n bank
```

Stop

```
make k8s-stop
```
