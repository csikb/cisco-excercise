# Cisco exercise project
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
Docker:
```shell
docker run cisco-exercise
```
Docker compose:
```shell
docker compose up
```
Gradle:
```shell
./gradlew bootRun
```
