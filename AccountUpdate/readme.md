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