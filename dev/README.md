# Step 3 - Docker image

### Description

Each of the projects can be packed with docker image, and then run as Docker container.
The shared library [common-grpc-connectivity](../common-grpc-connectivity) is used.


### Building docker images:

- For [Handyman-service](../handyman-service) build docker image:
```bash 
docker build \
  -f ../handyman-service/dockerfile \
  -t handyman-service \
  --build-arg APP_PORTS="8070 9070" \
  --build-arg APP_VERSION=0.0.2-SNAPSHOT ..
```

- For [Landscape-service](../landscape-service) build docker image:
```bash 
docker build \
  -f ../landscape-service/dockerfile \
  -t landscape-service \
  --build-arg APP_PORTS=8080 \
  --build-arg APP_VERSION=0.0.2-SNAPSHOT ..
```

- For [Rancher-service](../rancher-service) build docker image:
```bash 
docker build \
  -f ../rancher-service/dockerfile \
  -t rancher-service \
  --build-arg APP_PORTS="8090 9090" \
  --build-arg APP_VERSION=0.0.2-SNAPSHOT ..
```

### Run docker container:
After successful image build you can run containsers:
```bash 
docker run \
  -p 8070:8070 \
  -p 9070:9070 \
  --name handyman-service \
  handyman-service
```

```bash 
docker run \
  -p 8080:8080 \
  --name landscape-service \
  landscape-service
```

```bash 
docker run \
  -p 8090:8090 \
  -p 9090:9090 \
  --name rancher-service \
  rancher-service
```