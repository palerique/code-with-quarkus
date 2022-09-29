# Kubernetes Commands Used in Demonstration

All commands made from root of project.

```shell
cat kubernetes/kubeconfig.yml | base64

export NAMESPACE=code-with-quarkus

# Namespace
kubectl create namespace ${NAMESPACE}

# Role and RoleBinding for GitHub Actions to deploy to Amazon EKS
kubectl apply -f kubernetes/github_actions_role.yml -n ${NAMESPACE}

# Secret
kubectl apply -f kubernetes/secret.yml -n ${NAMESPACE}

# Command used by GitHub Action to deploy Quarkus application
kubectl apply -f build/kubernetes/kubernetes.yml -n ${NAMESPACE}

# HorizontalPodAutoscaler (HPA)
kubectl apply -f code-with-quarkus-hpa.yml -n ${NAMESPACE}
kubectl describe -n ${NAMESPACE} horizontalpodautoscaler.autoscaling/code-with-quarkus-srv
```
