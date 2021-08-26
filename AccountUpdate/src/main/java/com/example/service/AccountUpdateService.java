package com.example.service;

import com.example.model.Accounts;

import reactor.core.publisher.Mono;

/**
 * This is a service interface which have the methods for update, operation
 * 
 * @author group 5
 *
 */
public interface AccountUpdateService {
	/**
	 * Method for dealing with the updating of the account;
	 * 
	 * @param accounts
	 * @return Mono&ltBoolean&gt
	 */
	public Mono<Boolean> updateAccount(Accounts accounts);

}
