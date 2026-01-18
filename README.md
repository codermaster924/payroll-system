Employee Payroll System
My First Spring Boot Project
This is my initial project exploring the Spring Boot ecosystem. Transitioning from Java OOP theory to a live backend, I built this to master REST APIs and automated business logic.

 Key Features
Automated Payroll: Automatically applies a 10% tax to new employees.

Leave & Penalty System: Tracks leaves and deducts salary automatically if a limit (e.g., 10 days) is exceeded.

Data Persistence: Uses H2 Database in file-persistent mode so your data isn't wiped on restart.

3-Tier Architecture: Built using the industry-standard Controller-Service-Repository pattern.

 Quick Setup
Run: ./mvnw spring-boot:run

Admin Console: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:file:./data/payroll_db

API Endpoint: http://localhost:8080/api/employees

 Built With
Language: Java 17

Framework: Spring Boot 3

Database: H2 (Persistent)

Testing: Postman
