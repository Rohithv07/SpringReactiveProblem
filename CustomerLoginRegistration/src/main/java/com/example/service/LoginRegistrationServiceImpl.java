package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public Mono<Boolean> checkCredentials(Login loginCredentials) {
		List<Accounts> accountVerified = new ArrayList<>();
		Flux<Accounts> account = accRepo.findByUsernameAndPassword(loginCredentials.getUsername(),
				loginCredentials.getPassword());
//		Optional<String> optionalUsername = accRepo.getUsername(loginCredentials.getUsername()).blockOptional();
//		String username = optionalUsername.get();
//		if (username == null || username.length() == 0)
//			return Mono.just(false);
//		Optional<String> optionalPassword = accRepo.getPasswordForGivenUsername(loginCredentials.getUsername()).blockOptional();
//		String password = optionalPassword.get();
//		if (password == null || password.length() == 0 || !password.equals(loginCredentials.getPassword())) {
//			return Mono.just(false);
//		}
//		if (username.equalsIgnoreCase(loginCredentials.getUsername()) && password.equals(loginCredentials.getPassword())) {
//				return Mono.just(true);
//		}
//		return Mono.just(false);
		account.subscribe(a -> System.out.println(a));
		account.subscribe(accountVerified::add);
		logger.info(accountVerified.toString());
		try {
			Mono<Boolean> loginSuccessful = account == null ? null : account.map(a -> a != null).elementAt(0);
			return loginSuccessful;
			//return true;
		} catch (IndexOutOfBoundsException e) {
			return Mono.just(false);
			//return false;
		}
	}

}