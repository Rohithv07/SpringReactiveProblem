## Eureka Discovery Service :

* Every Micro service will register into the Eureka server and Eureka server knows all the client applications running on each port and IP address. 

### Port :

8761

### Url :

* `http://localhost:8761`

### Application.properties file

```properties
spring.application.name=eureka
server.port=8761

eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```
