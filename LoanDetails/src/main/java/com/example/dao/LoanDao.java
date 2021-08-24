package com.example.dao;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.model.Loan;

import reactor.core.publisher.Flux;

public interface LoanDao extends ReactiveCrudRepository<Loan, Integer> {

	public Flux<Loan> findByAccId(Integer accId);

}
