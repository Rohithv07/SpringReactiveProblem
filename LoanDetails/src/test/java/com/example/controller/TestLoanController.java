package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.model.Loan;
import com.example.service.LoanService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestLoanController {

	@Autowired
	private WebTestClient webTestClient;

	@MockBean
	private LoanService service;

	@Test
	public void givenAccId_whenGetLoans_thenCorrectLoans() {

		List<Loan> loanList = new ArrayList<>();

		Loan l1 = new Loan(1, "Home Loan", 500000, 5, 2, "22-08-2019", 2);
		Loan l2 = new Loan(2, "Personal Loan", 200000, 2, 2, "02-10-2021", 2);
		loanList.add(l1);
		loanList.add(l2);

		Mockito.when(service.getLoanDetailsByAccId(2)).thenReturn(Flux.fromIterable(loanList));

		webTestClient.get().uri("/loan/2").exchange().expectStatus().isOk().expectBodyList(Loan.class);

	}

	@Test
	public void givenLoanId_whenGetLoan_thenMatchedLoan() {

		Loan l1 = new Loan(1, "Home Loan", 500000, 5, 2, "22-08-2019", 2);

		Mockito.when(service.getLoanDetails(1)).thenReturn(Mono.just(l1));

		webTestClient.get().uri("/loan/1").exchange().expectStatus().isOk().expectBody().jsonPath("$.loanId").isEqualTo(1);

	}

}
