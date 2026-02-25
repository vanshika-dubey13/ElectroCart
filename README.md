# ElectroCart

This project is a backend application for an Electronic Store, built with Spring Boot. It provides secure and scalable RESTful APIs to manage products, users, authentication, and other core functionalities essential for an e-commerce platform. The application uses JWT-based authentication to ensure secure access and follows a layered architecture for better maintainability and separation of concerns.

# Project Structure
```
ElectronicStore/
├── config/          ⚙️  Application configuration classes
├── controllers/     🚪  REST API controllers handling client requests
├── dtos/            📦  Data Transfer Objects for request/response payloads
├── entities/        🏷️  JPA entities mapping to database tables
├── exceptions/      ⚠️  Custom exceptions and centralized error handling
├── repositories/    🗄️  Spring Data JPA repositories for data access
├── security/        🔐  Security configs and JWT authentication logic
├── services/        🛠️  Business logic and service implementations
└── ElectronicStoreApplication.java  🚀  Main Spring Boot application starter
```

