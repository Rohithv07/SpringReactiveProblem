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

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/loan")
public class LoanController {

	private static final Logger logger = LoggerFactory.getLogger(LoanController.class);

	@Autowired
	LoanService service;

	@PostMapping("/apply")
	public Mono<ResponseEntity<ResponseMessage>> applyLoan(@RequestBody Loan loan) throws URISyntaxException {
		URI location = null;
		try {
			Mono<Loan> saveloan = service.applyLoan(loan);
			StringBuilder locationStr = new StringBuilder();
			saveloan.subscribe(e -> locationStr.append("http://localhost:8080/loan/").append(e.getLoanId()));
			location = new URI(locationStr.toString());
			return Mono.just(ResponseEntity.created(location)
					.body(this.getResponse("Loan Applied!!!", HttpStatus.OK)));
		} catch (Exception ex) {
			return Mono.just(ResponseEntity.created(location).body(
					this.getResponse( "Failed to Apply Loan!!!", HttpStatus.INTERNAL_SERVER_ERROR)));

		}

	}

	@GetMapping("/{id}")
	public Mono<Loan> getLoanDetails(@PathVariable Integer id) {
		return service.getLoanDetails(id);
	}

	@GetMapping("/getAll/{id}")
	public Flux<Loan> getLoanDetailsByAccId(@PathVariable Integer id) {
		return service.getLoanDetailsByAccId(id);
	}

	private ResponseMessage getResponse(String message, HttpStatus status) {
		ResponseMessage response = new ResponseMessage();
		response.setStatus(status.name());
		response.setStatusCode(status.value());
		response.setMessage(message);
		return response;
	}

}
