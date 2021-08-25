package com.example.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Accounts;
import com.example.model.Login;
import com.example.model.ResponseMessage;
import com.example.service.LoginRegistrationService;
import com.example.util.JwtUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Mono;

@RestController
@Tag(name = "Register a new User and Login the registered user", description = "Apis for Login and Registering the User")
public class AccountController {

	
	@Autowired
	private LoginRegistrationService service;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/auth/login")
	@Operation(description = "Endpoint for validating the credentials and generating token for Login", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody())
	public ResponseEntity<String> login(@RequestBody Login login) {
		if (service.checkCredentials(login)) {
			String token = jwtUtil.generateToken(login.getUsername(), login.getPassword());
			return new ResponseEntity<String>(token, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Bad Credentials or User is not Registered", HttpStatus.NOT_ACCEPTABLE);

	}

	@PostMapping("/auth/register")
	@Operation(description = "Endpoint for Registering a new user", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody())
	public Mono<ResponseEntity<ResponseMessage>> registerAccount(@RequestBody Accounts account)
			throws URISyntaxException {
		Mono<Accounts> acc = service.registerAccount(account);

		StringBuilder locationStr = new StringBuilder();
		acc.subscribe(a -> locationStr.append("http://localhost:8080/register/"));

		// Getting current resource path
		URI location = new URI(locationStr.toString());

		return Mono.just(ResponseEntity.created(location).body(this.getResponse("OK", 201, "Account Registered")));
	}
	
	private ResponseMessage getResponse(String status, Integer statusCode, String message) {
		ResponseMessage response = new ResponseMessage();
		response.setStatus(status);
		response.setStatusCode(statusCode);
		response.setMessage(message);
		return response;
	}


}
