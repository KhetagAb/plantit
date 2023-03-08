### Description

- В монорепозитории представлены три папки - три сервиса.

### Project building:

- Убедиться, что установлена системная переменная ```JAVA_HOME``` к OpenJDK 17+.
- Запустить Spring приложение из корневой папки соотвествующего сервиса [Gradle](../landscape-service/build.gradle.kts):
  - `./gradlew bootRun` on Linux or MacOS
  - `gradlew bootRun` on Windows

### Результат

- С помощью запроса получаем информацию из актуатора
```bash 
curl -X GET localhost:8080/system/info
```

- Все приложения развернуты на разных портах: 8070, 8080, 8090
- У каждого из них доступен endpoint метрик и системные
```bash 
curl -X GET localhost:8080/metrics
```
```bash 
curl -X GET localhost:8080/system/liveness
```
```bash 
curl -X GET localhost:8080/system/readiness
```