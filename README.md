# Donation Management System | Java Spring Boot REST API

A Java and Spring Boot REST API for recording donations and managing donor and prospective-donor records. The project demonstrates a layered backend design with REST controllers, service classes, and Spring Data JPA repositories backed by an H2 database.

## Features

- Record donations and automatically create a donor record for a phone number not already registered.
- Remove a matching prospective-donor record after a donation is recorded.
- Retrieve donations ordered by date, newest first.
- Calculate a donor's total donation amount and retrieve donations associated with a donor.
- Register donors and prospective donors, and retrieve the first prospective donor's phone number.
- Calculate the aggregate of the `numPayment` field across donation records.

## Technology

- **Java 26**
- **Spring Boot 4.1.0**
- **Spring Web MVC** for REST endpoints
- **Spring Data JPA** for persistence
- **H2** as the database
- **Maven** for builds and dependency management
- **JUnit 5 / Spring Boot Test** for the application context test

## Project structure

```text
src/
├── main/java/com/example/project/
│   ├── Controllers/    REST endpoints
│   ├── Models/         Donation and donor entities
│   ├── Repositories/   Spring Data JPA repositories
│   ├── Services/       Application operations
│   └── ProjectApplication.java
├── main/resources/
│   └── application.properties
└── test/java/          Application context test
```

## REST API

The application exposes the following routes:

| Method | Route | Purpose |
|---|---|---|
| `POST` | `/insertDonation` | Record a donation from a JSON `Donation` object. A non-zero `sum` is required by the service. |
| `GET` | `/GetSumDonation` | Return the sum of the `numPayment` values across donation records. |
| `GET` | `/sortdate` | Return donations ordered by date, newest first. |
| `GET` | `/sumdonor` | Return the total donation amount for the phone number in the request body. |
| `POST` | `/addDonor` | Save a donor from a JSON `Donor` object. |
| `GET` | `/sumdonor1` | Return the total donation amount for the donor in the request body. |
| `GET` | `/AllDonation` | Return donations for the donor in the request body. |
| `GET` | `/getFirst` | Return the first prospective donor's phone number, or `"000"` when none are stored. |
| `POST` | `/add` | Save a prospective donor from a JSON `PotantialDonor` object. |

The entity fields in the request bodies are defined by the classes in `src/main/java/com/example/project/Models`. The `GET` routes that accept request bodies use the behavior implemented in the current controllers.

**Implementation note:** The donor lookup services compare phone strings by reference rather than by value. As a result, `/sumdonor`, `/sumdonor1`, and `/AllDonation` may not match the requested donor as intended.

## Run locally

**Prerequisite:** Install JDK 26.

From the project directory, start the application with the Maven Wrapper:

```powershell
.\mvnw.cmd spring-boot:run
```

Run the tests with:

```powershell
.\mvnw.cmd test
```

The current configuration uses a file-based H2 database in the user's home directory and enables the H2 console at `/h2console/`. The project currently contains an application context-load test.

## Current scope

This repository contains the backend API and persistence layer; no frontend, authentication, or authorization implementation is present. The API is a compact project implementation, and its behavior is described above according to the current source code.
