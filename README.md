# 4.2.-SpringFramework_N1
This project is a CRUD application using Spring Boot with Java. The goal is to manage a Fruit entity stored in an H2 in-memory database by following the MVC (Model-View-Controller) architecture pattern. The application also incorporates global exception handling using a GlobalExceptionHandler class.

## Project Setup
Generate the project using Spring Initializr with Maven and the following dependencies (Spring Boot DevTools, Spring Web, Spring Data JPA & H2 Database).

The application manages a single entity, **Fruit**, with these attributes:
- `int id`
- `String name`
- `int quantityKg`\
  
This entity is persisted in an H2 database using JPA.

## Project Structure
The code is organized into the following packages:
- cat.itacademy.s04.t02.n01.controllers – REST controllers (e.g., FruitController)
- cat.itacademy.s04.t02.n01.model – Entity classes (e.g., Fruit)
- cat.itacademy.s04.t02.n01.services – Business logic
- cat.itacademy.s04.t02.n01.repository – JPA repository
- cat.itacademy.s04.t02.n01.exception – Custom exceptions and global exception handling

## API Endpoints
The application exposes the following REST endpoints:
- POST	/fruita/add	Add a new fruit
- PUT	/fruita/update	Update existing fruit
- DELETE	/fruita/delete/{id}	Delete fruit by ID
- GET	/fruita/getOne/{id}	Get fruit by ID
- GET	/fruita/getAll	Get all fruits

## Exception Handling
A GlobalExceptionHandler is implemented to manage exceptions across the application consistently. It improves error handling by:
- Returning proper HTTP status codes
- Sending informative error messages
- Avoiding code duplication for exception handling

## Useful Links 
- https://www.baeldung.com/spring-boot-h2-database
- https://www.baeldung.com/exception-handling-for-rest-with-spring
- https://www.baeldung.com/spring-component-repository-service

  
