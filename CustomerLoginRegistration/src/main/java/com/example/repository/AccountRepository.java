package com.example.repository;

import java.util.List;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.example.model.Accounts;

import reactor.core.publisher.Flux;


public interface AccountRepository extends ReactiveCrudRepository<Accounts, Integer>{
	
	@Query("Select a.username from accounts a")
	public Flux<String> getAllUsername();
	
	@Query("Select a.password from accounts a where a.username= :username")
	public Flux<String> getPasswordForUsername(@Param("username") String username);
	
	public Flux<Accounts> findByUsernameAndPassword( String username, String password);
}
