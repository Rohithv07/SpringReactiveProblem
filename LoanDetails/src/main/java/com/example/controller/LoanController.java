package com.example.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Loan;
import com.example.model.ResponseMessage;
import com.example.service.LoanService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Have the endpoints for apply the loan viewing the details about the loan of a
 * user
 * 
 * @author group 5
 *
 */
@RestController
@RequestMapping("/loan")
@Tag(name = "Loan Account Table", description = "Apis for updating and deleting the account")
public class LoanController {

	private static final Logger logger = LoggerFactory.getLogger(LoanController.class);

	/**
	 * The service interface for the loan service {@link LoanService}
	 */
	@Autowired
	LoanService service;

	/**
	 * Rest end point for which a new loan is applied
	 * 
	 * @param loan
	 * @return Mono&ltResponseEntity&ltResponseMessage&gt&gt
	 * @throws URISyntaxException
	 */
	@PostMapping("/apply")
	@Operation(description = "Endpoint for applying the loan", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody())
	public Mono<ResponseEntity<ResponseMessage>> applyLoan(@RequestBody Loan loan) throws URISyntaxException {
		URI location = null;
		try {
			Mono<Loan> saveloan = service.applyLoan(loan);
			StringBuilder locationStr = new StringBuilder();
			saveloan.subscribe(e -> locationStr.append("http://localhost:8080/loan/").append(e.getLoanId()));
			location = new URI(locationStr.toString());
			return Mono.just(ResponseEntity.created(location).body(this.getResponse("Loan Applied!!!", HttpStatus.OK)));
		} catch (Exception ex) {
			return Mono.just(ResponseEntity.created(location)
					.body(this.getResponse("Failed to Apply Loan!!!", HttpStatus.INTERNAL_SERVER_ERROR)));

		}

	}

	/**
	 * Rest end point to get the loan details using loan id
	 * 
	 * @param id
	 * @return Mono&ltLoan&gt {@link Loan}
	 */
	@GetMapping("/{id}")
	@Operation(description = "Endpoint for getting all loan details of loan id")
	public Mono<Loan> getLoanDetails(@PathVariable Integer id) {
		return service.getLoanDetails(id);
	}

	/**
	 * Rest end point to get all loan details for an account id
	 * 
	 * @param id
	 * @return Flux&ltLoan&gt {@link Loan}
	 */
	@GetMapping("/getAll/{id}")
	@Operation(description = "getting all loan details of account id")
	public Flux<Loan> getLoanDetailsByAccId(@PathVariable Integer id) {
		return service.getLoanDetailsByAccId(id);
	}

	/**
	 * Field which is used as the response message for the API
	 * 
	 * @param message
	 * @param status
	 * @return {@link ResponseMessage}
	 */
	private ResponseMessage getResponse(String message, HttpStatus status) {
		ResponseMessage response = new ResponseMessage();
		response.setStatus(status.name());
		response.setStatusCode(status.value());
		response.setMessage(message);
		return response;
	}

}
