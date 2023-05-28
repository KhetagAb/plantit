# Kubernetes

### Requirements:

- Kubernetes cluster
  - Minikube or docker-desktop cluster.

### Kubernetes resources and configurations:
Apply all configs, deployments, statefullset and persistence volume:
```bash 
kubectl apply --filename=postgres-config.yaml,postgres-pv.yaml,postgres-statefullset.yaml
```

```bash 
kubectl apply --filename=handyman-deployment.yaml
```

```bash 
kubectl apply --filename=landscape-deployment.yaml
```

```bash 
kubectl apply --filename=rancher-deployment.yaml
```
