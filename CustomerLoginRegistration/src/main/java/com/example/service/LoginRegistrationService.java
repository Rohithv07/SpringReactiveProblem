package com.example.service;

import com.example.model.Accounts;
import com.example.model.Login;

import reactor.core.publisher.Mono;

/**
 * This is a service interface which have the method definition for registering,
 * checking credentials
 * 
 * 
 * @author group 5
 *
 */
public interface LoginRegistrationService {

	/**
	 * Method to deal with the registration of the account
	 * 
	 * @param account
	 * @return Mono&ltAccounts&gt
	 */
	public Mono<Accounts> registerAccount(Accounts account);

	/**
	 * Method to validate the username and password wrt that in database
	 * 
	 * @param loginCredentials
	 * @return boolean
	 */
	public boolean checkCredentials(Login loginCredentials);

	/**
	 * Method to validate for the username and password already existed in db
	 * 
	 * @param account
	 * @return boolean
	 */
	public boolean checkUsernamePassword(Accounts account);

}
