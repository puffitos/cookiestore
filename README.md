# Cookie Store

This is a simple cookie store that exposes a simple API to store and retrieve cookies. This project serves a simple
Springboot application that is ready to be deployed in a CaaS cluster without any further configuration.

This project is built using the following technologies:

- Java 21
- Springboot 3.0.2

## Building a docker image

To build the project, run the following command:

```bash
gradle bootBuildImage
```

## Deploying

Change the `host` of the Ingress resource in `k8s/ingress.yaml` to match your cluster's IP address or hostname.

Then, run the following command to deploy the application:

```bash
kubectl apply -f k8s
```

