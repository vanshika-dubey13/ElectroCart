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

# Functionality

The **Electronic Store Backend** is a Spring Boot application providing a **secure, scalable, and modular backend** for an online electronics store. It exposes RESTful APIs for managing users, products, authentication, and orders. The system follows a **layered architecture** for maintainability, separation of concerns, and scalability.

### **1️⃣ User Management**

* **Registration & Login**:

  * Users can register with username, email, and password.
  * Passwords are **securely hashed using BCrypt**.
  * Login returns a **JWT token** for stateless authentication.

* **Role-Based Access Control**:

  * Supports roles such as `ADMIN` and `USER`.
  * Certain endpoints (like adding products) are restricted to admins.

### **2️⃣ Product Management**

* **CRUD Operations**:

  * Add, update, delete, and fetch products.
  * Products include attributes like name, category, price, description, and stock quantity.

* **Search**:

  * Search products by name or category.

* **Inventory Management**:

  * Stock quantity updates automatically on orders

---

### **3️⃣ Shopping Cart & Order Handling**

* **Cart Management**:

  * Users can add/remove products from their cart.

* **Order Processing**:

  * Create orders from the cart items.
  * Updates product inventory upon order confirmation.
  * Tracks order status (pending, shipped, delivered).

---

### **4️⃣ Security**

* **JWT-Based Authentication**:

  * Secure API access using **JSON Web Tokens**.
  * Tokens have expiration times and are validated with every request.

* **Spring Security Integration**:

  * Protects endpoints based on roles.
  * Provides authentication filters (`OncePerRequestFilter`) to validate JWT.

* **Exception Handling**:

  * Handles unauthorized access attempts gracefully.
  * Returns consistent, structured API error responses.

---

### **5️⃣ Data Persistence**

* **Database Integration**:

  * Uses **Spring Data JPA** for database operations.
  * Supports relational database **MySQL**

* **Entity Modeling**:

  * `User`, `Product`, `Order`, and related entities are mapped using JPA annotations.
  * Relationships (e.g., One-to-Many between Users and Orders) are correctly defined.

* **Repositories**:

  * Repository interfaces provide CRUD and query methods without boilerplate code.

---

### **6️⃣ Layered Architecture**

* **Controller Layer**: Handles HTTP requests and converts responses to JSON.
* **Service Layer**: Contains business logic like validating products, managing orders, and handling user authentication.
* **Repository Layer**: Handles database interactions using Spring Data JPA.
* **Security Layer**: Handles JWT generation, validation, and role-based access control.

---

### **7️⃣ Exception Handling & Validation**

* **Global Exception Handling**:

  * Handles BadApiRequestException , GlobalExceptionHandler , ResourceNotFoundException custom exceptions and sends meaningful responses.
  
---

### **8️⃣ Future Enhancements**

* Payment gateway integration for online transactions.
* Email notifications for registration and order updates.
* Product reviews and ratings.
* Analytics dashboard for admin users.

---
