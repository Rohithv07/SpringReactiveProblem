package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * The user can update the account details and AccountUpdateApplication updates
 * and also deletes the details if needed.
 * 
 * @author group 5
 *
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "UpdateAccount", version = "1.0", description = "Documentation APIs v1.0"))
public class AccountUpdateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountUpdateApplication.class, args);
	}

}
