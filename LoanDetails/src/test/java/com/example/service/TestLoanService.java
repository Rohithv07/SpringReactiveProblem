package com.example.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.model.Loan;

import reactor.test.StepVerifier;

public class TestLoanService {

	LoanServiceImpl service;

	@BeforeAll
	public static void setup() {
		System.out.println("Before All called...");
	}

	@BeforeEach
	public void setupTest() {
		System.out.println("Before Each called...");
		service = new LoanServiceImpl();
	}

	@Test
	public void testGetLoans() {
		
		Loan l1 = new Loan(4, "Educational Loan", 5000, 5, 2, "22-08-2019", 5);

		service.applyLoan(l1);

		StepVerifier.create(service.getLoanDetails(4)).expectNextCount(4).expectComplete().verify();
	}

	@Test
	public void givenLoanId_whenGetLoan_thenMatchLoan() {
		StepVerifier.create(service.getLoanDetails(1)).expectNextCount(1).expectComplete().verify();

	}

	@Test
	public void givenLoan_whenCreateLoan_thenReturnCreatedLoan() {
		Loan loan = new Loan(5, "Home Loan", 500000, 5, 2, "22-08-2019", 1);
		StepVerifier.create(service.applyLoan(loan)).expectNext(loan).expectComplete().verify();
		StepVerifier.create(service.getLoanDetails(5)).expectNext(loan).expectComplete().verify();

	}

	@AfterEach
	public void tearDownTest() {
		// service.deleteAll();
		System.out.println("After Each called...");
	}

	@AfterAll
	public static void tearDown() {

		System.out.println("After All called...");
	}

}
