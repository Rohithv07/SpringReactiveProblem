package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Accounts;
import com.example.model.ResponseMessage;
import com.example.service.AccountUpdateService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Contains the end points to update and delete the account details
 * 
 * @author group 5
 *
 */
@RestController
@Tag(name = "Update Account Table", description = "Apis for updating and deleting the account")
public class AccountUpdateController {

	/**
	 * The service interface for the account update
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
	 * The rest end point which deletes the account details for the provided id
	 * 
	 * @param id
	 * @return {@link ResponseMessage}
	 */
	@DeleteMapping("/update/{id}")
	@Operation(description = "Endpoint for deleting the account")
	public Mono<ResponseEntity<ResponseMessage>> deleteAccount(@PathVariable Integer id) {
		accountUpdateService.deleteAccount(id);
		ResponseMessage response = getResponse(id, "Employee Deleted");

		return Mono.just(ResponseEntity.accepted().body(response));
	}

	@GetMapping("/update")
	public Flux<Accounts> getAllAccount() {
		return accountUpdateService.getAllAccounts();
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
