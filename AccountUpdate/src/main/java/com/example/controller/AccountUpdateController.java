package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Accounts;
import com.example.model.ResponseMessage;
import com.example.service.AccountUpdateService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Mono;

/**
 * Contains the end points to update account details
 * 
 * @author group 5
 *
 */
@RestController
@Tag(name = "Update Account Table", description = "Apis for updating the account")
public class AccountUpdateController {

	/**
	 * The service interface for the account update {@link AccountUpdateService}
	 * 
	 */
	@Autowired
	private AccountUpdateService accountUpdateService;

	/**
	 * The rest end point which updates the account details for the provided id
	 * 
	 * @param account
	 * @param id
	 * @return {@link ResponseMessage}
	 */
	@PutMapping("/update/{id}")
	@Operation(description = "Endpoint for updating the account", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody())
	public Mono<ResponseEntity<ResponseMessage>> updateAccountDetails(@RequestBody Accounts account,
			@PathVariable Integer id) {
		account.setAcc_id(id);
		accountUpdateService.updateAccount(account);
		return Mono.just(ResponseEntity.ok().body(this.getResponse(account.getAcc_id(), "Account is Updated")));

	}

	/**
	 * The fields which is used as the response message for the API
	 * 
	 * @param id
	 * @param message
	 * @return {@link ResponseMessage}
	 */
	private ResponseMessage getResponse(Integer id, String message) {
		ResponseMessage response = new ResponseMessage();
		response.setId(id);
		response.setStatus(HttpStatus.OK.name());
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage(message);
		return response;
	}
}
