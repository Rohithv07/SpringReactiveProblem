package com.example.service;

import com.example.model.Accounts;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * This is a service interface which have the method definition for update,
 * delete operations
 * 
 * @author group 5
 *
 */
public interface AccountUpdateService {
	/**
	 * Method declaration for dealing with the updating of the account;
	 * 
	 * @param accounts
	 * @return Mono&ltBoolean&gt
	 */
	public Mono<Boolean> updateAccount(Accounts accounts);

	public Flux<Accounts> getAllAccounts();

	/**
	 * Method declaration for dealing with the deletion of the account
	 * 
	 * @param id
	 * @return Mono&ltBoolean&gt
	 */
	public Mono<Boolean> deleteAccount(Integer id);
}
