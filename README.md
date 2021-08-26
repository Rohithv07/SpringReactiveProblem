# Banking Application

## Customer Registration and Login Service :

* User register the details and gets saved into database.

* Only registered user must be able to access the other services.

* The credentials are checked inside the database.

* After login, a token is generated and this token must be provided as Authorization header to access other services

### Port :

* 8080

### Url :

* POST : `http://localhost:8080/auth/register`

* POST : `http://localhost:8080/auth/login`

* POST : `http://localhost:8765/auth/register` - using gateway

* POST : `http://localhost:8765/auth/login` - using gateway

* `http://localhost:8080/swagger-ui.html` - swagger

### Application.properties file

```properties
spring.application.name=auth
server.port=8080
#SQL
spring.r2dbc.url=r2dbc:mysql://localhost:3306/bankingdetails

spring.r2dbc.username=root

spring.r2dbc.password=password


spring.r2dbc.initialization-mode=always

logging.level.org.springframework.web=DEBUG

eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/

#secret key - should be encrypted
jwt.secret=secretkey
#3 minutes validity
jwt.token.validity=900000
#ignore null fields in json
spring.jackson.default-property-inclusion=NON_NULL

spring.config.import=optional:configserver:http://localhost:8888
```


### Sql : 

```sql
CREATE TABLE accounts (
  acc_id int NOT NULL AUTO_INCREMENT,
  acc_type varchar(45) NOT NULL,
  acc_name varchar(45) NOT NULL,
  username varchar(25) NOT NULL,
  password varchar(25) NOT NULL,
  address varchar(250) DEFAULT NULL,
  state varchar(25) NOT NULL,
  country varchar(25) NOT NULL,
  email varchar(45) NOT NULL,
  pan varchar(45) NOT NULL,
  contact_no varchar(45) NOT NULL,
  dob varchar(45) NOT NULL,
  PRIMARY KEY (acc_id)
);
```


## Apply Loan Details Service :

* The user can apply and view the details about the loan.

* Applied loan details are saved in a database.

* Token generated after login must be provided as Authorization header.


### Port :

* 8888

### Urls : 

* POST : `http://localhost:8888/loan/apply`

* GET : `http://localhost:8888/loan/{id}`

* GET : `http://localhost:8888/loan/getAll/{id}`

* POST : `http://localhost:8765/loan/apply` - gateway

* GET : `http://localhost:8765/loan/{id}` - gateway

* GET : `http://localhost:8765/loan/getAll/{id}` - gateway

* `http://localhost:8888/swagger-ui.html` - swagger

### Application.properties file

```properties
server.port=8888
spring.application.name=loan

#SQL
spring.r2dbc.url=r2dbc:mysql://localhost:3306/bankingdetails
spring.r2dbc.username=root
spring.r2dbc.password=password
spring.r2dbc.initialization-mode=always
logging.level.org.springframework.web=DEBUG
spring.config.import=optional:configserver:http://localhost:8888
```

### Sql

```sql
CREATE TABLE `loan` (
  `loan_id` int(11) NOT NULL AUTO_INCREMENT,
  `loan_type` varchar(45) NOT NULL,
  `amount` int(11) NOT NULL,
  `duration` int(11) NOT NULL,
  `rate_of_interest` int(11) NOT NULL,
  `loan_date` varchar(45) NOT NULL,
  `acc_id` int(11) NOT NULL,
  PRIMARY KEY (`loan_id`),
  KEY `acc_id` (`acc_id`),
  CONSTRAINT `accounts` FOREIGN KEY (`acc_id`) REFERENCES `accounts` (`acc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```


## Account Update Service :

* The user who logs in can update his account details.

* Token generated after login must be provided as Authorization header.

### Port : 

* 8082

### Url :

* PUT : `http://localhost:8082/account/{id}`

* PUT : `http://localhost:8765/update/{id}` - Using gateway

* `http://localhost:8082/swagger-ui.html` - swagger

### Application.properties file :

```properties
spring.application.name=update
server.port=8082

spring.r2dbc.url=r2dbc:mysql://localhost:3306/bankingdetails

spring.r2dbc.username=root

spring.r2dbc.password=

spring.r2dbc.initialization-mode=always

spring.config.import=optional:configserver:http://localhost:8888
```

## Eureka Discovery Service :

* Every Micro service will register into the Eureka server and Eureka server knows all the client applications running on each port and IP address. 

### Port :

* 8761

### Url :

* `http://localhost:8761`

### Application.properties file

```properties
spring.application.name=eureka
server.port=8761

eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```


## Spring Cloud Gateway :

* The Spring Cloud Gateway sits in front of your microservices and receives requests from clients and redirect those requests to appropriate microservices. 

* It is customary to add a security layer here for restricting to the unauthorized requests which are coming from clients.

### Port :

* 8765

### Url :

#### Loan Service :

* POST : `http://localhost:8765/loan/apply` - gateway 

* GET : `http://localhost:8765/loan/{id}` - gateway

* GET : `http://localhost:8765/loan/getAll/{id}` - gateway


#### Login and Registration Service : 

* POST : `http://localhost:8765/auth/register` - gateway

* POST : `http://localhost:8765/auth/login` - gateway

#### Account Update Service

* PUT : `http://localhost:8765/update/{id}` - gateway

### Application.properties file

```properties
eureka.client.service-url.default-zone=http://localhost:8761/eureka

server.port = 8765

spring.application.name=gateway

#secret key - should be encrypted
jwt.secret=secretkey
#ignore null fields in json
spring.jackson.default-property-inclusion=NON_NULL

spring.config.import=optional:configserver:http://localhost:8888

```

