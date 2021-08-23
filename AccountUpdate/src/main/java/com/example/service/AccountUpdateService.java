package com.example.service;

import com.example.model.Accounts;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountUpdateService {
	public Mono<Boolean> updateAccount(Accounts accounts);
	public Flux<Accounts> getAllAccounts();
	public Mono<Boolean> deleteAccount(Integer id);
}
