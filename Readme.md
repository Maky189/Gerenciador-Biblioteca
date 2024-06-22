# Java Library Management Application

This document provides a comprehensive overview of the Java Library Management Application. The application allows for the management of a library system, including the addition, retrieval, updating, and deletion of books and users, as well as the management of book loans and returns. 

## Overview

The application is structured into several key components:
- **Models**: Represent the entities within the system (Book, User, Loan).
- **Repositories**: Handle the database operations for each model.
- **Database Utility**: Manages the database connection.
- **Main Application**: Entry point of the application, demonstrating CRUD operations.

## Project Structure

The project is organized into the following directories and files:


### Model Classes

#### Livro.java
This class represents a book in the library. It includes attributes such as `id`, `title`, `author`, and `availability`. It provides constructors for creating instances of books, as well as getter and setter methods for accessing and modifying the book's attributes.

#### Usuario.java
This class represents a user of the library. Attributes include `id`, `name`, and `email`. Like the `Book` class, it provides constructors and getter/setter methods to facilitate the creation and manipulation of user objects.

#### Emprestimo.java
This class represents a loan transaction, which involves lending a book to a user. It includes attributes such as `id`, `bookId`, `userId`, `loanDate`, and `returnDate`. Constructors and getter/setter methods are provided for handling loan data.

### Repositorio Classes

#### LivroRepository.java
This class is responsible for performing CRUD operations on the `Book` model. It includes methods for adding, retrieving, updating, and deleting books in the database. It utilizes the `DatabaseUtil` class to establish a connection to the database and execute SQL queries.

#### UsuarioRepository.java
Similar to `BookRepository`, this class handles the CRUD operations for the `User` model. It includes methods for managing user data in the database, ensuring users can be added, retrieved, updated, and deleted.

#### EmprestimoRepository.java
This class manages the `Loan` model, providing methods to handle loan transactions in the database. It supports operations such as adding new loans, retrieving loan information, updating loan details, and deleting loans.

### Utility Class

#### DatabaseUtil.java
This class provides a utility method for establishing a connection to the MySQL database. It includes the database URL, username, and password. The `getConnection` method is used throughout the repository classes to connect to the database and perform SQL operations.

### Main Application Class

#### Biblioteca.java
This is the main entry point of the application. It demonstrates the usage of the repository classes by performing various CRUD operations. The class includes a `main` method where it:
- Adds a new book to the library.
- Retrieves and prints book information.
- Updates the book's availability status.
- Deletes the book from the library.

### Database Configuration

1. **Create Database and Tables**:
   Ensure MySQL is installed and running. Create the database and tables using the following SQL commands:

```sql
CREATE DATABASE biblioteca;

USE biblioteca;

CREATE TABLE Livro (
    id VARCHAR(50) PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    disponivel BOOLEAN NOT NULL
);

CREATE TABLE User (
    id VARCHAR(50) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE Loan (
    id VARCHAR(50) PRIMARY KEY,
    LivroId VARCHAR(50),
    usuarioId VARCHAR(50),
    emprestimoDate TIMESTAMP NOT NULL,
    retornoDate TIMESTAMP,
    FOREIGN KEY (Livrod) REFERENCES Livro(id),
    FOREIGN KEY (LivroId) REFERENCES Usuario(id)
);

