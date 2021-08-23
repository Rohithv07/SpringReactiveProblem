package com.example.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import reactor.core.publisher.Mono;

@RestController
public class AccountController {
	
	@Autowired
	private LoginRegistrationService service;
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@PostMapping("/register")
	public Mono<ResponseEntity<ResponseMessage>> registerAccount(@RequestBody Accounts account)
			throws URISyntaxException {
		Mono<Accounts> acc = service.registerAccount(account);

		StringBuilder locationStr = new StringBuilder();
		acc.subscribe(a -> locationStr.append("http://localhost:8080/register/"));

		// Getting current resource path
		URI location = new URI(locationStr.toString());

		return Mono.just(ResponseEntity.created(location).body(this.getResponse("OK", 201,"Account Registered")));
	}
	
	@PostMapping("/login")
	public Mono<Boolean> login(@RequestBody Login loginCredentials) throws URISyntaxException{
		Mono<Boolean> loginSuccessful = service.checkPassword(loginCredentials);
		
		return (loginSuccessful == null) ? null : loginSuccessful;
	}
	
	private ResponseMessage getResponse(String status, Integer statusCode, String message) {
		ResponseMessage response = new ResponseMessage();
		response.setStatus(status);
		response.setStatusCode(statusCode);
		response.setMessage(message);
		return response;
	}
}
