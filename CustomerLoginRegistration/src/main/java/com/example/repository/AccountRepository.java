package com.example.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.model.Accounts;
import com.example.model.Login;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface AccountRepository extends ReactiveCrudRepository<Accounts, Integer>{
	
	@Query("Select a.username from accounts a")
	public Flux<String> getAllUsername();
	
	@Query("Select a.password from accounts a where a.username= :username")
	public Flux<String> getPasswordForUsername(@Param("username") String username);
	
	public Flux<Accounts> findByUsernameAndPassword( String username, String password);
	
	@Query("Select a.username from accounts a where a.username= :username")
	public Mono<String> getUsername(@Param("username") String username);
	
	@Query("Select a.password from accounts a where a.username= :username")
	public Mono<String> getPasswordForGivenUsername(@Param("username") String username);
	
	public Mono<Login> findByUsername(String username);
	
	
}
