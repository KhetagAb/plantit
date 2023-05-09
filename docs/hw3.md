# Step 3 - Docker image

### Description

Each of the projects can be packed with docker image, and then run as Docker container.
The shared library [common-grpc-connectivity](../common-grpc-connectivity) is used.


### Building docker images:

- Use dev [README.md](../dev/README.md)


### Result

- Building docker image:
![](../docs/resources/hw3/1.png)

- Running container:
![](../docs/resources/hw3/2.png)

- Checking port-forwarding for all containers with Postman testing:
![](../docs/resources/hw3/3.png)
![](../docs/resources/hw3/4.png)

- Running all containers with docker-compose:
![](../docs/resources/hw3/5.png)
