package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.FailedLoginException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Accounts;
import com.example.model.Login;
import com.example.repository.AccountRepository;
import com.example.util.JwtUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LoginRegistrationServiceImpl implements LoginRegistrationService {

	@Autowired
	AccountRepository accRepo;
	
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public Mono<Accounts> registerAccount(Accounts account) {
		return accRepo.save(account);
	}

	private static final Logger logger = LoggerFactory.getLogger(LoginRegistrationServiceImpl.class);

	@Override
	public boolean checkCredentials(Login loginCredentials) {
		List<Accounts> accountVerified = new ArrayList<>();
		Flux<Accounts> account = accRepo.findByUsernameAndPassword(loginCredentials.getUsername(),
				loginCredentials.getPassword());
//		account.subscribe(a -> System.out.println(a));
		account.subscribe(accountVerified::add);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountVerified.size() > 0;
//		logger.info(accountVerified.toString());
//		try {
//			Mono<Boolean> loginSuccessful = account == null ? null : account.map(a -> a != null).elementAt(0);
//			return loginSuccessful;
//			//return true;
//		} catch (IndexOutOfBoundsException e) {
//			return Mono.just(false);
////			//return false;
//		}
	}
//	
//	@Override
//	public Mono<Accounts> checkCredentials(Login loginCredentials) {
//		Accounts account = new Accounts();
//		account.setUsername(null);
//		account.setPassword(null);
//		Mono<Accounts> fallback = Mono.error(new Throwable("No user account was found with username: " + loginCredentials.getUsername()));
//		return  accRepo.findByUsernameAndPassword(loginCredentials.getUsername(), loginCredentials.getPassword())
//				.defaultIfEmpty(account)
//				.flatMap(a -> {
//					if (a.getUsername() != null && a.getPassword() != null) {
//						String token = jwtUtil.generateToken(loginCredentials.getUsername(), loginCredentials.getPassword());
//					}
//					return Mono.just(a);
//				});
//	}
	
//	@Override
//	public Mono<Accounts> checkCredentials(Mono<Login> loginCredentials) {
//		return loginCredentials.flatMap(userLogin -> {
//			return accRepo.findByUsernameAndPassword(userLogin.getUsername(), userLogin.getPassword())
//					.switchIfEmpty(Mono.error(new FailedLoginException("Failed Login!")));
//		});
//	}
	
				//.switchIfEmpty(fallback);
//		credentials.subscribe(a -> System.out.println(a.getUsername()));
//		credentials.subscribe(a -> System.out.println(a.getPassword()));
//		
//		return credentials;
		
//		List<Accounts> accountVerified = new ArrayList<>();
//		Flux<Accounts> account = accRepo.findByUsernameAndPassword(loginCredentials.getUsername(),
//				loginCredentials.getPassword());
//		account.subscribe(a -> System.out.println(a));
//		account.subscribe(accountVerified::add);
//		logger.info(accountVerified.toString());
//		try {
//			Mono<Boolean> loginSuccessful = account == null ? null : account.map(a -> a != null).elementAt(0);
//			return loginSuccessful;
//		} catch (IndexOutOfBoundsException e) {
//			return Mono.just(false);
//		}
		
//	@Override
//	public Flux<Accounts> checkCredentials(Login loginCredentials) {
//		
//		List<String> accountVerified = new ArrayList<>();
//		Flux<Accounts> account = accRepo.findByUsernameAndPassword(loginCredentials.getUsername(),
//				loginCredentials.getPassword());
//		return account;
//	}
		//Mono<Login> currentUser = accRepo.findByUsername(loginCredentials.getUsername());
//		account.map(person -> {
//			return person.getUsername();
//		}).subscribe(
//			accountVerified::addAll;
//		});
//		System.out.println(accountVerified);
//		System.out.println(accountVerified);
//
//		logger.info(accountVerified.toString());
//		try {
//			Mono<Boolean> loginSuccessful = account == null ? null : account.map(a -> a != null).elementAt(0);
//			return Mono.just(true);
//			//return true;
//		} catch (IndexOutOfBoundsException e) {
//			return Mono.just(false);
//			//return false;
//		}
	
	
	
	
	
	

}
//System.out.println(accountVerified.add(account));
//account.subscribe(a -> sya.getUsername());
//account.subscribe(accountVerified::add);
////account.subscribe(a-> accountVerified.add(a));
//System.out.println(accountVerified);
//Optional<String> optionalUsername = accRepo.getUsername(loginCredentials.getUsername()).blockOptional();
//String username = optionalUsername.get();
//if (username == null || username.length() == 0)
//	return Mono.just(false);
//Optional<String> optionalPassword = accRepo.getPasswordForGivenUsername(loginCredentials.getUsername()).blockOptional();
//String password = optionalPassword.get();
//if (password == null || password.length() == 0 || !password.equals(loginCredentials.getPassword())) {
//	return Mono.just(false);
//}
//if (username.equalsIgnoreCase(loginCredentials.getUsername()) && password.equals(loginCredentials.getPassword())) {
//		return Mono.just(true);
//}
//return Mono.just(false);
//return account;
//account.subscribe(a -> System.out.println(a));
//account.subscribe(accountVerified::add);
