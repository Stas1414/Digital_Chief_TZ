# Test task for Digital Chief
It is a simple REST API that provides CRUD operations for managing users and posts.
The project demonstrates the basic capabilities of creating, reading, updating and deleting (CRUD) records in the database.
## Technologies
+ Java 17
+ Spring Boot 3.3.1
+ PostgreSQL
+ Hibernate
+ Lombok
+ Maven
## Dependencies
```xml
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>

		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
```
## Installation and Setup
1. Clone the repository:
    ```bash
    git clone https://github.com/Stas1414/Digital_Chief_TZ/tree/master
    cd Digital_Chief_TZ
    ```

2. Configure the PostgreSQL database:
    - Create the database:
      ```sql
      CREATE DATABASE postgres;
      ```
    - Set up the username and password in `application.properties`:
      ```properties
      spring.datasource.url=jdbc:postgresql://localhost:5432/myapplication
      spring.datasource.username=postgres
      spring.datasource.password=postgres
      spring.jpa.hibernate.ddl-auto=update
      ```

3. Install dependencies and build the project:
    ```bash
    mvn clean install
    ```

4. Run the application:
    ```bash
    mvn spring-boot:run
    ```
## EndPoints for user
+ Creating a user : POST /users
+ Getting all users : GET /users
+ Getting user posts : GET /users/{id}
+ Update the user : PUT /users/{id}
+ Delete the user : DELETE /users/{id}
## EndPoints for posts
+ Creating a post : POST /posts
+ Getting all posts : GET /posts
+ Getting post by id : GET /posts/{id}
+ Update the post : PUT /posts/{id}
+ Delete the post : DELETE /posts/{id}
