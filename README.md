# Biblioteka Microservices

Biblioteka Microservices is a comprehensive solution for library and book management, designed to provide efficient and scalable services for handling various aspects of library operations. The project is built on the principles of microservices architecture, allowing for independent development, deployment, and scalability of individual components.

## Overview

The project is divided into microservices, each responsible for a specific domain within the library ecosystem. These microservices communicate with each other through RESTful APIs. The project follows a modular approach, separating the functionality into three distinct modules:

1. **biblioteka-library**: This module handles all the library management operations, including creating, updating, and retrieving library information.

2. **biblioteka-book**: This module is responsible for managing book-related functionality, such as adding new books, updating book details, and querying book information.

3. **biblioteka-gateway**: This module acts as an API gateway, routing incoming requests to the appropriate microservices based on the request paths.

## Key technologies/Frameworks

- **Spring Framework**: The project is built on the Spring Framework, using Spring Boot for rapid application development and Spring MVC for building web applications and RESTful services.

- **Spring Data**: The Spring Data module is utilized for seamless interaction with databases, providing an abstraction layer and simplifying data access operations.

- **Spring Cloud Gateway**: Spring Cloud Gateway is used for implementing API gateway functionality to manage and route requests to the respective microservices, enhancing security and performance.

- **MapStruct**: MapStruct simplifies the mapping between DTOs (Data Transfer Objects) and entities, improving code readability and maintainability.

- **H2 Database**: H2 Database is used as an in-memory database for development and testing purposes, providing a lightweight and efficient solution.

## API Documentation

The microservices expose the following API endpoints:

### Library API

- `GET /api/libraries`: Retrieve a list of all libraries
- `GET /api/libraries/{libraryId}`: Retrieve details of a specific library
- `PUT /api/libraries/{libraryId}`: Update an existing library
- `PUT /api/libraries/{libraryId}`: Create a new library
- `DELETE /api/libraries/{libraryId}`: Delete a library

### Book API

- `GET /api/books`: Retrieve a list of all books
- `GET /api/books/{bookId}`: Retrieve details of a specific book
- `PUT /api/books`: Create a new book
- `PUT /api/books/{bookId}`: Update an existing book
- `DELETE /api/books/{bookId}`: Delete a book
- `GET /api/libraries/{libraryId}/books`: Retrieve a list of books associated with a specific library