package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;


import com.example.dao.LoanDao;
import com.example.model.Loan;

import reactor.core.publisher.Mono;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanDao dao;

	@Override
	public Mono<Loan> applyLoan(Loan loan) {
		return dao.save(loan);
	}

	public Mono<Loan> getLoanDetails(Integer id) {
		return dao.findById(id);
	}

	@Override
	public Flux<Loan> getLoanDetailsByAccId(Integer id) {
		return dao.findByAccId(id);
	}

}
