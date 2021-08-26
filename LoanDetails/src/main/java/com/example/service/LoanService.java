package com.example.service;

import reactor.core.publisher.Flux;

import com.example.model.Loan;

import reactor.core.publisher.Mono;

/**
 * This is a service interface which have the methods for applying and getting
 * the details of the loan
 * 
 * @author rohithvazhathody
 *
 */
public interface LoanService {

	/**
	 * Method dealing with applying the loan
	 * 
	 * @param loan
	 * @return Mono&ltLoan&gt {@link Loan}
	 */
	Mono<Loan> applyLoan(Loan loan);

	/**
	 * Method dealing with getting the loan details using id
	 * 
	 * @param id
	 * @return Mono&ltLoan&gt {@link Loan}
	 */
	Mono<Loan> getLoanDetails(Integer id);

	/**
	 * Method dealing with getting all the loan details ysing account id
	 * 
	 * @param id
	 * @return Flux&ltLoan&gt {@link Loan}
	 */
	Flux<Loan> getLoanDetailsByAccId(Integer id);

}
