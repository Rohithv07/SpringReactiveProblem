package com.example.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.model.Loan;

import reactor.core.publisher.Flux;

/**
 * To deal with the crud operation, we need to make use of a repository that
 * extends {@link ReactiveCrudRepository}
 * 
 * @author group 5
 *
 */
public interface LoanDao extends ReactiveCrudRepository<Loan, Integer> {

	public Flux<Loan> findByAccId(Integer accId);

}
