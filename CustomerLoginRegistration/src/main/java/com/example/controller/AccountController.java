package com.example.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

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

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AccountController {
	
//	@Autowired
//	private LoginRegistrationService service;
//	
//	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
//	
//	@PostMapping("/auth/register")
//	public Mono<ResponseEntity<ResponseMessage>> registerAccount(@RequestBody Accounts account)
//			throws URISyntaxException {
//		Mono<Accounts> acc = service.registerAccount(account);
//
//		StringBuilder locationStr = new StringBuilder();
//		acc.subscribe(a -> locationStr.append("http://localhost:8080/register/"));
//
//		// Getting current resource path
//		URI location = new URI(locationStr.toString());
//
//		return Mono.just(ResponseEntity.created(location).body(this.getResponse("OK", 201,"Account Registered")));
//	}
//	
//	@PostMapping("/auth/login")
//	public Mono<Boolean> login(@RequestBody Login loginCredentials) throws URISyntaxException{
//		Mono<Boolean> loginSuccessful = service.checkPassword(loginCredentials);
//		
//		return (loginSuccessful == null) ? null : loginSuccessful;
//	}
//	
	private ResponseMessage getResponse(String status, Integer statusCode, String message) {
		ResponseMessage response = new ResponseMessage();
		response.setStatus(status);
		response.setStatusCode(statusCode);
		response.setMessage(message);
		return response;
	}
	
	@Autowired
	private LoginRegistrationService service;
	
	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/auth/login")
	public ResponseEntity<String> login(@RequestBody Login login) {
		if (service.checkCredentials(login)) {
			String token = jwtUtil.generateToken(login.getUsername(), login.getPassword());
			return new ResponseEntity<String>(token, HttpStatus.OK); 
		}
		return new ResponseEntity<String>("Bad", HttpStatus.NOT_ACCEPTABLE);
		//Mono<Boolean> checkCredentials = service.checkCredentials(login);
//		Accounts account = new Accounts((Integer)null, null, null, null, null, null, null, null, null, null, null, null);
//		Flux<Accounts> credentials = service.checkCredentials(login);
//		//credentials.nu
//		return credentials.defaultIfEmpty(account)
//				//.onErrorReturn(account)
//				.flatMap(value -> {
//			if (value.getUsername() != null)
//				return Mono.just(new ResponseEntity<String>(jwtUtil.generateToken(login.getUsername(), login.getPassword()), HttpStatus.OK));
//			return Mono.doOnError();
//		});
//		Map<String, String> response = new HashMap<>();
//		try {
//			Mono<Accounts> checkCredentials = service.checkCredentials(login);
//			System.out.println(checkCredentials);
//			if (checkCredentials != null) {
//				String token = jwtUtil.generateToken(login.getUsername(), login.getPassword());
//				response.put("token", token);
//			}
//				return new ResponseEntity<Object>(response, HttpStatus.OK);
//		} catch(Exception exception) {
//			response.put("Unauthorized : ", "Bad credentials or User is not registered");
//			return new ResponseEntity<Object>(response, HttpStatus.NOT_ACCEPTABLE);
//		}
		
//		if (service.checkCredentials(login).flatMap(validLogin _.)) {
//			String token = jwtUtil.generateToken(login.getUsername());
//			return new ResponseEntity<String>(token, HttpStatus.OK);
//		}
//		return new ResponseEntity<String>("Bad credentials", HttpStatus.NOT_ACCEPTABLE);
//		if (service.checkPassword(login)) {
//			String token = jwtUtil.generateToken(login.getUsername());
//			return new ResponseEntity<String>(token, HttpStatus.OK);
//		}
//		return new ResponseEntity<String>("Bad credentials", HttpStatus.NOT_ACCEPTABLE);

		
	}
	
	@PostMapping("/auth/register")
	public Mono<ResponseEntity<ResponseMessage>> registerAccount(@RequestBody Accounts account)
			throws URISyntaxException {
		Mono<Accounts> acc = service.registerAccount(account);

		StringBuilder locationStr = new StringBuilder();
		acc.subscribe(a -> locationStr.append("http://localhost:8080/register/"));

		// Getting current resource path
		URI location = new URI(locationStr.toString());

		return Mono.just(ResponseEntity.created(location).body(this.getResponse("OK", 201,"Account Registered")));
	}

//	@PostMapping("/auth/register")
//	public ResponseEntity<String> register(@RequestBody Accounts account) {
//		// Persist user to some persistent storage
//		service.registerAccount(account)
//		service.registerAccount(account);
//		System.out.println("Info saved...");
//
//		return new ResponseEntity<String>("Registered", HttpStatus.OK);
//	}
	
}

/*
 * return checkFieldAExistence(email).flatMap(fieldAExists -> {
        if (fieldAExists) {
            return reactiveMongoTemplate.updateMulti(query(where("customer.email.address").is(email.address())),
                    new Update().set("customer.publicId", fieldA), Account.class, accountCollection).map(result -> {
                if (result.wasAcknowledged()) {
                    return true;
                } else {
                    throw new IllegalArgumentException(
                            "Error adding fieldA value to customer with email address " + email.address());
                }
            });
        } else {
            return Mono.just(false);
        }
    });
    */
