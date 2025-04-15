# Spring Boot CRUD Application

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## Project Description

This project showcases the development of a robust and efficient web application using Spring Boot, demonstrating fundamental CRUD (Create, Read, Update, Delete) operations. Built entirely with Java, this application focuses on the backend API development, designed for seamless interaction and effective testing using tools like Postman.

## Key Features

* **Comprehensive CRUD Operations:** Implements all essential data manipulation functionalities (Create, Read, Update, Delete).
* **Spring Boot Power:** Leverages the simplicity and rapid development capabilities of the Spring Boot framework.
* **Java-Based Architecture:** Built entirely using Java, ensuring type safety and performance.
* **RESTful API Design:** Exposes clear and concise API endpoints for interacting with the application's data.
* **Postman Friendly:** Designed for easy testing and validation of API endpoints using Postman or similar tools.

## Project Overview

This application provides a foundational structure for managing data through a well-defined API. Spring Boot handles the backend logic, data persistence (you'll likely integrate a database), and API endpoint management. The focus is purely on the backend API, allowing for interaction and data manipulation through HTTP requests. You can use Postman to send these requests to the defined API endpoints to create new resources, retrieve existing ones, modify data, and delete entries, effectively demonstrating the backend functionality. This type of architecture allows for flexibility in choosing a separate front-end technology (like React, Angular, Vue.js, or even a mobile application) to consume these API endpoints.

## Technologies Used

* **Java:** The primary programming language.
* **Spring Boot:** The rapid application development framework.

## API Endpoints (Examples)

* `POST http://localhost:8080/products`: Create a new item.
* `GET http://localhost:8080/products`: Retrieve all items.
* `GET http://localhost:8080/products/{id}`: Retrieve a specific item by its ID.
* `PUT http://localhost:8080/products/{id}`: Update an existing item.
* `DELETE http://localhost:8080/products/{id}`: Delete a specific item.

## Output

* HTTP post request to create entity
![image](https://github.com/user-attachments/assets/cd3cb532-7bd9-4d4c-97e8-8fac8dba8e8e)


* HTTP get request to get all entities or you may add specific id to retreve specifici entity
![image](https://github.com/user-attachments/assets/ae5d93d2-019a-4c9d-b990-f74bca1bb8cd)


* HTTP delete request to delete specific entity by providing ID
![image](https://github.com/user-attachments/assets/504b6be9-6de9-4a48-94cf-2fc7bbcc4d9b)



## License

This project is licensed under the [MIT License](LICENSE).
