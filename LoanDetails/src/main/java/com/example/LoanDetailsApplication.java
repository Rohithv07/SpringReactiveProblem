package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "LoanDetails", version = "1.0", description = "Documentation APIs v1.0"))
public class LoanDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanDetailsApplication.class, args);
	}

}
