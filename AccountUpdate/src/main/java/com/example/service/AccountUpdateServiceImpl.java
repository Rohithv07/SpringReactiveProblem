package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Accounts;
import com.example.repository.AccountRepository;

import reactor.core.publisher.Mono;

/**
 * Service class which implements all the methods declared in the respective
 * service interface {@link AccountUpdateService}
 * 
 * @author group 5
 *
 */
@Service
public class AccountUpdateServiceImpl implements AccountUpdateService {

	/**
	 * This field used for dealing with the crud operation and it is autowired
	 */
	@Autowired
	private AccountRepository accountRepository;

	/**
	 * The method implementation for update account {@link AccountUpdateService}
	 */
	@Override
	public Mono<Boolean> updateAccount(Accounts accounts) {
		try {
			accountRepository.save(accounts).block();
		} catch (Exception e) {
			return Mono.just(Boolean.FALSE);
		}
		return Mono.just(Boolean.TRUE);
	}

}
