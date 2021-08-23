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

@Service
public class LoginRegistrationServiceImpl implements LoginRegistrationService {

	@Autowired
	AccountRepository accRepo;

	@Override
	public Mono<Accounts> registerAccount(Accounts account) {
		return accRepo.save(account);
	}

	private static final Logger logger = LoggerFactory.getLogger(LoginRegistrationServiceImpl.class);

	@Override
	public Mono<Boolean> checkPassword(Login loginCredentials) {
		List<Accounts> accountVerified = new ArrayList<>();
		Flux<Accounts> account = accRepo.findByUsernameAndPassword(loginCredentials.getUsername(),
				loginCredentials.getPassword());
		account.subscribe(a -> System.out.println(a));
		account.subscribe(accountVerified::add);
		logger.info(accountVerified.toString());
		try {
			Mono<Boolean> loginSuccessful = account == null ? null : account.map(a -> a != null).elementAt(0);
			return loginSuccessful;
		} catch (IndexOutOfBoundsException e) {
			return Mono.just(false);
		}
	}

}