# Employee Management API

A REST API for managing employees and departments, built with Spring Boot and Spring Data JPA.

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Lombok
- Maven

## Project Structure

```
src/main/java/com/JPA/JPA_P02/
├── controller/
│   ├── EmployeeController.java
│   └── DepartmentController.java
├── service/
│   ├── EmployeeService.java
│   └── DepartmentService.java
├── repository/
│   ├── EmployeeRepo.java
│   └── DepartmentRepo.java
└── entity/
    ├── Employee.java
    └── Department.java
```

## Features

- Full CRUD for Employee and Department
- Bidirectional One-To-Many relationship between Department and Employee
- Foreign key constraint: `department_id` in employees table references departments
- Circular reference handled using `@JsonIgnoreProperties`
- Auto table validation using `ddl-auto=validate`
- SQL query logging enabled for transparency

## Database Schema

```sql
CREATE TABLE departments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    location VARCHAR(30) NOT NULL
);

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL,
    salary DOUBLE NOT NULL,
    department_id INT,
    CONSTRAINT FOREIGN KEY (department_id) REFERENCES departments(id)
);
```

## API Endpoints

### Department

| Method | URL | Description |
|--------|-----|-------------|
| POST | `/departments` | Create a department |
| GET | `/departments` | Get all departments |
| GET | `/departments/{id}` | Get department by ID |
| DELETE | `/departments/{id}` | Delete department |

### Employee

| Method | URL | Description |
|--------|-----|-------------|
| POST | `/employees` | Create an employee |
| GET | `/employees` | Get all employees |
| GET | `/employees/{id}` | Get employee by ID |
| DELETE | `/employees/{id}` | Delete employee |

## Sample Requests

### Create Department
```json
POST /departments
{
    "name": "IT",
    "location": "Delhi"
}
```

### Create Employee
```json
POST /employees
{
    "name": "Mansi",
    "email": "mansi@gmail.com",
    "salary": 50000,
    "department": {
        "id": 1
    }
}
```

### Sample Response — GET /employees
```json
[
    {
        "id": 1,
        "name": "Mansi",
        "email": "mansi@gmail.com",
        "salary": 50000.0,
        "department": {
            "id": 1,
            "name": "IT",
            "location": "Delhi"
        }
    }
]
```

## How to Run

1. Clone the repository
```bash
git clone https://github.com/muktikashyap301-arch/employee-manager-jpa.git
```

2. Create the database in MySQL
```sql
CREATE DATABASE employee_management;
```

3. Create the tables using the schema above

4. Configure your credentials in `src/main/resources/application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_management
spring.datasource.username=your_username
spring.datasource.password=your_password
```

5. Run the application
```bash
mvn spring-boot:run
```

## Author

Mansi — Java Backend Developer · Spring Boot ·
