# Cisco exercise project

## Docs
You can access the API docs at the root path. `localhost:8080/`  
Just run the application using one of the methods below.

## Development
### Lint
```shell
./gradlew checkstyleMain checkstyleTest
```
### Test
```shell
./gradlew test
```
### Build
Docker:
```shell
docker build -t cisco-exercise .
```
Gradle:
```shell
./gradlew build
```
### Run
Docker compose:
```shell
docker compose up
```
Docker:
```shell
docker run cisco-exercise
```
Gradle:
```shell
./gradlew bootRun
```
