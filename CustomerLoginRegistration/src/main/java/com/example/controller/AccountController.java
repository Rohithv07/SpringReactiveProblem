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

/**
 * A new user can register his account with specifying the registered fields and
 * the user needs to sign in using valid credentials
 * 
 * @author group 5
 *
 */
@RestController
@Tag(name = "Register a new User and Login the registered user", description = "Apis for Login and Registering the User")
public class AccountController {

	/**
	 * The service interface for the account login and registration
	 */
	@Autowired
	private LoginRegistrationService service;

	/**
	 * Utitlity component to generate the token for signed in user
	 */
	@Autowired
	private JwtUtil jwtUtil;

	/**
	 * The rest end point for which the user credentials are validated and generates
	 * a token.
	 * 
	 * @param login
	 * @return ResponseEntity&ltString&gt
	 */
	@PostMapping("/auth/login")
	@Operation(description = "Endpoint for validating the credentials and generating token for Login", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody())
	public ResponseEntity<String> login(@RequestBody Login login) {
		if (service.checkCredentials(login)) {
			String token = jwtUtil.generateToken(login.getUsername(), login.getPassword());
			return new ResponseEntity<String>(token, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Bad Credentials or User is not Registered", HttpStatus.NOT_ACCEPTABLE);

	}
	

	/**
	 * The rest end point for which the user credentials are validated and generates
	 * a token.
	 * 
	 * @param account
	 * @return Mono<ResponseEntity&ltResponseMessage&gt
	 * @throws URISyntaxException
	 */
	@PostMapping("/auth/register")
	@Operation(description = "Endpoint for Registering a new user", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody())
	public Mono<ResponseEntity<ResponseMessage>> registerAccount(@RequestBody Accounts account)
			throws URISyntaxException {
		StringBuilder locationStr = new StringBuilder();
		if (!service.checkUsernamePassword(account)) {
			Mono<Accounts> acc = service.registerAccount(account);
			acc.subscribe(a -> locationStr.append("http://localhost:8080/register/"));

			URI location = new URI(locationStr.toString());

			return Mono.just(ResponseEntity.created(location).body(this.getResponse("OK", 201, "Account Registered")));
		}
		URI location = new URI(locationStr.toString());
		return Mono.just(ResponseEntity.created(location)
				.body(this.getResponse("Ok", 201, "Username or password already used")));
	}

	/**
	 * The fields which is used as the response message for the API
	 * 
	 * @param status
	 * @param statusCode
	 * @param message
	 * @return ResponseMessage {@link ResponseMessage}
	 */
	private ResponseMessage getResponse(String status, Integer statusCode, String message) {
		ResponseMessage response = new ResponseMessage();
		response.setStatus(status);
		response.setStatusCode(statusCode);
		response.setMessage(message);
		return response;
	}

}
