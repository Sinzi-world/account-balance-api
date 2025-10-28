# Account Balance API

A simple **REST API** for managing account balances and transactions with multi-currency support. All balances are stored in USD, while transactions can be in USD, EUR, BYN, or RUB.

## Features

- Create accounts/balances with unique names (starting from 0 USD).
- Deposit or withdraw money in multiple currencies.
- Automatic currency conversion to USD.
- View balance information and transaction history.
- API documentation via **Swagger / OpenAPI**.
- PostgreSQL database with Flyway migrations.
- Fully containerized with Docker.

## Technology Stack

- Java 21
- Spring Boot 3.5
- Spring Data JPA
- PostgreSQL
- Flyway (database migrations)
- Lombok
- Springdoc OpenAPI (Swagger UI)
- Docker & Docker Compose
- Gradle

## Getting Started

### 1. Clone the repository

```bash
  git clone https://github.com/Sinzi-world/account-balance-api.git
  cd account-balance-api
```

### 2. Start the Docker container

#### To start the PostgreSQL database, run the provided run.sh script:
    ./run.sh

#### This script will execute:
```bash
  docker-compose build
  docker-compose up -d
```

#### This will build the Docker image (if needed) and run the container in detached mode.

### 3. Run the Application

#### After the database container is running, you can start the Spring Boot application:
    ./gradlew bootRun

#### Or build the JAR and run it:
```bash
  ./gradlew build 
  java -jar build/libs/account-balance-api-0.0.1-SNAPSHOT.jar
```

### 4. Access Swagger Documentation

#### Once the application is running, the API documentation is available at:
http://localhost:8080/swagger-ui/index.html#/

Use this interface to explore all endpoints and try API requests.

### 5. Stop the Application and Docker Container

#### After you are done working, stop the application and the database container by running the stop.sh script:
    ./stop.sh

#### This will execute:
```bash
docker-compose down
```

## Notes

- To work with the application and the preconfigured database, Docker Desktop must be installed.

- If Docker is not available, you can reconfigure the database connection in application.yaml to use a local or remote PostgreSQL instance.
