package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * A new user needs to register his account and need to sign in to use the
 * respective service.
 * 
 * @author group 5
 *
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Registration and Login", version = "1.0", description = "Documentation APIs v1.0"))
public class CustomerLoginRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerLoginRegistrationApplication.class, args);
	}

}
