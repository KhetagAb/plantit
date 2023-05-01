# Step 1 - Initializing project

### Description

- There are three directories in monorepository - three services.

### Project building:

- Be sure, that ```JAVA_HOME`` for  OpenJDK 19+ variable is set.
- Run SpringBoot application from root directory **for each** service [Gradle](../landscape-service/build.gradle.kts):
  - `./gradlew clean bootRun` on Linux or MacOS
  - `gradlew clean bootRun` on Windows


### Result

- Send check request for actuator
```bash 
curl -X GET localhost:8080/system/info
```

- Application's ports are: 8070, 8080, 8090
- Each of it has few endpoints for metrics, liveness and readiness
```bash 
curl -X GET localhost:8080/metrics
```
```bash 
curl -X GET localhost:8080/system/liveness
```
```bash 
curl -X GET localhost:8080/system/readiness
```