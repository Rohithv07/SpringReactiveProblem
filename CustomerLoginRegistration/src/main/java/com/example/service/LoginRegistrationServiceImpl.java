package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Accounts;
import com.example.model.Login;
import com.example.repository.AccountRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service class which implements all the methods declared in the respective
 * service interface {@link LoginRegistrationService}
 * 
 * @author group 5
 *
 */
@Service
public class LoginRegistrationServiceImpl implements LoginRegistrationService {

	private static final Logger logger = LoggerFactory.getLogger(LoginRegistrationServiceImpl.class);

	/**
	 * This field used for dealing with the crud operation and it is autowired
	 */
	@Autowired
	AccountRepository accRepo;

	/**
	 * Registers a new account and saves to the database
	 */
	@Override
	public Mono<Accounts> registerAccount(Accounts account) {
		return accRepo.save(account);
	}

	/**
	 * Confirms whether the credentials is already present inside the database
	 */
	@Override
	public boolean checkCredentials(Login loginCredentials) {
		List<Accounts> accountVerified = new ArrayList<>();
		Flux<Accounts> account = accRepo.findByUsernameAndPassword(loginCredentials.getUsername(),
				loginCredentials.getPassword());
		account.subscribe(accountVerified::add);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return accountVerified.size() > 0;
	}

	/**
	 * Checks whether the username and password is already get used
	 */
	@Override
	public boolean checkUsernamePassword(Accounts account) {
		List<Accounts> accountVerified = new ArrayList<>();
		Flux<Accounts> accountFlux = accRepo.findByUsername(account.getUsername());
		accountFlux.subscribe(accountVerified::add);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return accountVerified.size() > 0;
	}

}
