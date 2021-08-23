package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Accounts;
import com.example.repository.AccountRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountUpdateServiceImpl implements AccountUpdateService{
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Mono<Boolean> updateAccount(Accounts accounts) {
		try {
			accountRepository.save(accounts).block();
		} catch (Exception e) {
			return Mono.just(Boolean.FALSE);
		}
		return Mono.just(Boolean.TRUE);
	}

	@Override
	public Flux<Accounts> getAllAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public Mono<Boolean> deleteAccount(Integer id) {
		try {
			accountRepository.deleteById(id).block();
		} catch (Exception e) {
			return Mono.just(Boolean.FALSE);
		}
		return Mono.just(Boolean.TRUE);
	}

}
