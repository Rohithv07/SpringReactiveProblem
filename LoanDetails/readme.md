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