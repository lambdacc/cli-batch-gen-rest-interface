### Sample REST interface for [cardano-cli-batch-tx-gen](https://github.com/lambdacc/cardano-cli-batch-tx-gen)

#### Requirements:
- Java 17

#### How to run

To run the server, execute this command from the project root dir
```
./mvnw spring-boot:run
```

Data for testing will be available at this endpoint

```
http://127.0.0.1:8066/api/cli-batch-tx/get-data?pageNo=0&pageSize=100
```

