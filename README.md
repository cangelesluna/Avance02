# Simple Ecommerce Application

This repository contains a minimal Java web application demonstrating an MVC architecture with MySQL for storing product data.

## Structure
- **Model**: Java classes under `src/main/java/com/example/ecommerce/model` handle data access.
- **Controller**: A Servlet under `src/main/java/com/example/ecommerce/controller` routes requests.
- **View**: JSP files under `src/main/webapp/WEB-INF/views` render HTML.

## Database
The application expects a MySQL database called `ecommerce` with a table `products`:

```sql
CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10,2)
);
```

Database connection settings are in `src/main/resources/db.properties`.

## Building
This project uses a standard Maven layout. To build and run, ensure Maven and a servlet container (like Tomcat) are installed. Run:

```bash
mvn package
```

Deploy the generated WAR file to your servlet container.

*Note:* Dependency downloads require internet access during the Maven build.
