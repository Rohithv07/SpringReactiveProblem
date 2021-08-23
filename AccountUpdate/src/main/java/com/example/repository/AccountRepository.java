package com.example.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.model.Accounts;

/**
 * To deal with the crud operation, we need to make use of a repository that
 * extends {@link ReactiveCrudRepository}
 * 
 * @author group 5
 *
 */
public interface AccountRepository extends ReactiveCrudRepository<Accounts, Integer> {

}
