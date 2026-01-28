In-Memory Library API (Spring Boot) 

1. Project Overview
--------------------
In-Memory Library API is a simple Spring Boot REST application that allows users to add, view, search, and delete books using in-memory storage — no database is required.

Key Features:

Add new books
Retrieve books by ID
Search books by publication year
Delete books
Centralized exception handling

2. Setup Instructions
-----------------------
Prerequisites

-Java 17+
Maven
IDE (Eclipse / IntelliJ) – optional
Postman – for API testing

-Steps to Run the Project

Right-click LibraryApplication.java
Select Run As → Spring Boot App

Application will start at:
http://localhost:8080

3. Design & Implementation Logic
---------------------------------
Approach & Rationale

In-Memory Storage: Used HashMap<Integer, Book> instead of a database as per project requirements.

-Spring Boot Advantages:

Quick REST API exposure
Dependency injection
Embedded Tomcat server

-Layered Architecture:

Controller: Handles HTTP requests
Service: Business logic
Model: Book representation
Exception Handling: Centralized via @ControllerAdvice
Benefits: Clean, readable, testable, and scalable code.

-Hardest Bug & Resolution
-------------------------

Problem:
ClassNotFoundException: Could not find or load main class

Cause:
Project was accidentally run as a Java Application instead of a Spring Boot Application.

Solution:

Delete incorrect run configuration

Run the project as Spring Boot App → application context and dependencies loaded correctly

4. API Endpoints
-----------------
Action	HTTP Method	Endpoint	Request Body / Params
Add Book	POST	/books	{ "id": 1, "title": "Clean Code", "author": "Robert C. Martin", "year": 2024 }
Get Book by ID	GET	/books/{id}	Path variable: id
Search Books by Year	GET	/books/search	Query param: year=2024
Delete Book	DELETE	/books/{id}	Path variable: id

Examples:

GET /books/1
DELETE /books/1
GET /books/search?year=2024

5. Proof of Functionality

The following Postman screenshots demonstrate that all CRUD operations work perfectly:

1.Add Books
2.Get All Books
3.Search Books by Year
4.Delete Book


- Screenshots
---------------

- [Project running](./images/running-project.png)  
- [GET request](./images/postman_get.png)  
- [POST request](./images/postman_post.png)
  
Books are successfully stored and retrieved from in-memory storage, as required.

6. Exception Handling
----------------------
Custom Exception: BookNotFoundException when a book ID is not found

Global Handler: @ControllerAdvice for consistent HTTP responses

HTTP Status Codes:

404 Not Found

400 Bad Request

Improves API reliability and provides better user experience

7. Future Enhancements
-----------------------

If given additional time:

Add JUnit & Mockito tests for service & controller layers
Input validation using @Valid
Auto-generated API documentation using Swagger/OpenAPI
Pagination & sorting for book listings
Optionally integrate a database (H2/MySQL) while keeping in-memory mode configurable

Conclusion
-------------

This project successfully demonstrates:

RESTful API built with Spring Boot
Strict in-memory storage (no database)
Full CRUD operations implemented
Centralized exception handling
Verified via Postman API tests

A clean, modular, and easily extendable foundation for a library management system.
