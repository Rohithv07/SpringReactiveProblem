package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

import com.example.dao.LoanDao;
import com.example.model.Accounts;
import com.example.model.Loan;

import reactor.core.publisher.Mono;

/**
 * Service class that implements all the methods from the respective interface
 * {@link LoanService}
 * 
 * @author rohithvazhathody
 *
 */
@Service
public class LoanServiceImpl implements LoanService {

	/**
	 * This field used for dealing with the crud operation and it is autowired
	 */
	@Autowired
	private LoanDao dao;

	/**
	 * The method implementation for the apply loan {@link Loan} {@link LoanService}
	 */
	@Override
	public Mono<Loan> applyLoan(Loan loan) {
		return dao.save(loan);
	}

	/**
	 * The method implementation for getting the loan details {@link Loan}
	 * {@link LoanService}
	 */
	public Mono<Loan> getLoanDetails(Integer id) {
		return dao.findById(id);
	}

	/**
	 * The method implementation for getting loan details by account id
	 * {@link Accounts} {@link Loan} {@link LoanService}
	 */
	@Override
	public Flux<Loan> getLoanDetailsByAccId(Integer id) {
		return dao.findByAccId(id);
	}

}
