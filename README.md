# Supplier Management System

## Project Overview
This project is developed using Spring Boot, PostgreSQL, Apache Kafka, and Docker Compose.

It provides CRUD operations for supplier management and publishes Kafka events whenever supplier data is created.

---

## Technologies Used

- Java 17
- Spring Boot
- PostgreSQL
- Apache Kafka
- Docker
- Swagger UI

---

## Features

- Create Supplier
- Get Supplier
- Update Supplier
- Delete Supplier
- Kafka Producer
- Kafka Consumer
- Swagger API Documentation
- Docker Compose setup

---

## API Base URL

http://localhost:8081

---

## Swagger URL

http://localhost:8081/swagger-ui/index.html

---

## Run Application

### Start Docker Containers

```bash
docker compose up -d

## Run Spring Boot Application

```bash
.\mvnw.cmd spring-boot:run
```

---

## Build Project

```bash
.\mvnw.cmd clean package
```

---

## Kafka Event Flow

Whenever a supplier is created:

- Producer publishes event to Kafka topic
- Consumer receives and logs the event successfully

---

## Sample Kafka Topic

```text
supplier-topic
```

---

## Author

Jhansi Garikapati
