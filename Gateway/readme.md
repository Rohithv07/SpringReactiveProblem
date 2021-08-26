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

#secret key
jwt.secret=secretkey
#ignore null fields in json
spring.jackson.default-property-inclusion=NON_NULL

spring.config.import=optional:configserver:http://localhost:8888

```
