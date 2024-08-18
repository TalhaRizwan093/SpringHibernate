# Spring Hibernate Started

In this repository you can learn all the stuff about Hibernate. Moreover you can use this project as a starter or your application template. Please support me by giving a star to the repository so that I can continue the hard work and provide you guys with the best practices and latest code Thanks 😄.

### Database Schema

- I used Product database to show all types of relations and features of Spring Hibernate.
- In this project we have the Product table which has 1 to Many and Many to Many relation with other tables.
- 1 Product can have many Attributes and Attributes are attached with the categories.
- Many Product can have multiple categories.
- 1 Category can have multiple attibutes.
- The detailed schema is shown below although some attributes are missing.

![Product-Category ERD](https://github.com/user-attachments/assets/38855980-cd27-4c24-9500-10b92bb945cd)

### Hibernate Information

Following hibernate features are used in this project.

* SpringData is used in this project.
* Hibernate is used as ORM.
* Hibernate Entities are used such as Product, Category etc.
* CRUD operations using JPA repository.
* Relations between different entities
* Hibernate Filtters
* Hibernate Validatior
* Pagination
* Transactions
* Custom Quries
* Interceptors
* Cascading
* Fetch Types (Lazy and Eager Loading)

### Spinning up the backend

Before building and running the backend we have to ensure that the application properties files has setup correctly and accordingly.

Following are the must have properties.

```bash
spring.application.name=Backend
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url = ${DATASOURCE_URL}
spring.datasource.username = ${DATASOURCE_USER}
spring.datasource.password = ${DATASOURCE_PASSWORD}

spring.jpa.hibernate.ddl-auto = update
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl

server.error.include-message = always
```

Please add these app properties in your application and donot forget to replace the configurations {your-configs}.

After adding the application properties. Use the following commands to spin up the spring security project.

```bash
  cd backend
  mvn spring-boot:run
```

- Backend is now ready to accept the requests.

Access the frontend to start using the proejct

### Other Startes

- SpringSecurityStarter (OAuth2, JWT, Username password) [SpringSecurityOAuthJWT](https://github.com/TalhaRizwan093/Springboot-Security-Starter-OAuth-JWT "repo").
- SpringSecurityMicroserviceStarter [SpringSecurityMicroserviceStarter](https://github.com/TalhaRizwan093/SpringSecurity-Microservices-Starter "link")

## Regards

For support, email talharizwan.me@gmail.com
If you like and using this project please donot Forget to Star it as it means alot to me. Thanks.

## Authors

- [@TalhaRizwan093](https://www.github.com/TalhaRizwan093)
