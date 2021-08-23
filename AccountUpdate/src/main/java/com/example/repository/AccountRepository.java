package com.example.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.model.Accounts;

public interface AccountRepository extends ReactiveCrudRepository<Accounts, Integer>{

}
