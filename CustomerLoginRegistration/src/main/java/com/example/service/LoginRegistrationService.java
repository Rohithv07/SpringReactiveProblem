package com.example.service;



import com.example.model.Accounts;
import com.example.model.Login;

import reactor.core.publisher.Mono;

public interface LoginRegistrationService {
	
	public Mono<Accounts> registerAccount(Accounts account);

	public Mono<Boolean> checkCredentials(Login loginCredentials);
	
	
	
}
