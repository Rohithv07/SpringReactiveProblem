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