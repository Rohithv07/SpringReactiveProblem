package com.example.service;



import com.example.model.Accounts;
import com.example.model.Login;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LoginRegistrationService {
	
	public Mono<Accounts> registerAccount(Accounts account);

	public Flux<Accounts> checkCredentials(Login loginCredentials);
	
	
	
}
