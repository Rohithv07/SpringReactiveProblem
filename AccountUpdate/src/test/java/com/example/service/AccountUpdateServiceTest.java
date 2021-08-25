package com.example.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.model.Accounts;

import reactor.test.StepVerifier;

public class AccountUpdateServiceTest {
	private AccountUpdateServiceImpl accountUpdateServiceImpl;
	private Accounts account;

	@BeforeAll
	public static void setup() {
		System.out.println("Before All called...");
	}

	@BeforeEach
	public void setupTest() {
		System.out.println("Before Each called...");
		accountUpdateServiceImpl = new AccountUpdateServiceImpl();
		account = new Accounts(1, "ABC", "abc", "user", "pass", "add", "stae", "country", "email", "pan", "12345",
				"12/12/12");
	}

	@Test
	public void testUpdateAccount_updateId() {
		account.setAcc_id(2);
		accountUpdateServiceImpl.updateAccount(account);
		StepVerifier.create(accountUpdateServiceImpl.updateAccount(account)).expectNext(false).expectComplete()
				.verify();
	}

	@Test
	public void testUpdateAccount_updateAccountType() {
		account.setAcc_type("type");
		accountUpdateServiceImpl.updateAccount(account);
		StepVerifier.create(accountUpdateServiceImpl.updateAccount(account)).expectNext(false).expectComplete()
				.verify();
	}

	@Test
	public void testUpdateAccount_updateAccountName() {
		account.setAcc_name("another name");
		accountUpdateServiceImpl.updateAccount(account);
		StepVerifier.create(accountUpdateServiceImpl.updateAccount(account)).expectNext(false).expectComplete()
				.verify();
	}

	@Test
	public void testUpdateAccount_updateUsername() {
		account.setAcc_name("username");
		accountUpdateServiceImpl.updateAccount(account);
		StepVerifier.create(accountUpdateServiceImpl.updateAccount(account)).expectNext(false).expectComplete()
				.verify();
	}

	@Test
	public void testUpdateAccount_updatePassword() {
		account.setPassword("passowrd");
		accountUpdateServiceImpl.updateAccount(account);
		StepVerifier.create(accountUpdateServiceImpl.updateAccount(account)).expectNext(false).expectComplete()
				.verify();
	}

	@Test
	public void testUpdateAccount_updateAddress() {
		account.setAddress("address");
		accountUpdateServiceImpl.updateAccount(account);
		StepVerifier.create(accountUpdateServiceImpl.updateAccount(account)).expectNext(false).expectComplete()
				.verify();
	}

	@Test
	public void testUpdateAccount_updateState() {
		account.setAddress("state");
		accountUpdateServiceImpl.updateAccount(account);
		StepVerifier.create(accountUpdateServiceImpl.updateAccount(account)).expectNext(false).expectComplete()
				.verify();
	}

	@Test
	public void testUpdateAccount_updateCountry() {
		account.setCountry("country");
		accountUpdateServiceImpl.updateAccount(account);
		StepVerifier.create(accountUpdateServiceImpl.updateAccount(account)).expectNext(false).expectComplete()
				.verify();
	}

	@Test
	public void testUpdateAccount_updateEmail() {
		account.setEmail("abc@mail.com");
		accountUpdateServiceImpl.updateAccount(account);
		StepVerifier.create(accountUpdateServiceImpl.updateAccount(account)).expectNext(false).expectComplete()
				.verify();
	}

	@Test
	public void testUpdateAccount_updatePan() {
		account.setPan("djijwjd1121");
		accountUpdateServiceImpl.updateAccount(account);
		StepVerifier.create(accountUpdateServiceImpl.updateAccount(account)).expectNext(false).expectComplete()
				.verify();
	}

	@Test
	public void testUpdateAccount_updateContactNumber() {
		account.setContact_no("country");
		accountUpdateServiceImpl.updateAccount(account);
		StepVerifier.create(accountUpdateServiceImpl.updateAccount(account)).expectNext(false).expectComplete()
				.verify();
	}

	@Test
	public void testUpdateAccount_updateDob() {
		account.setDob("country");
		accountUpdateServiceImpl.updateAccount(account);
		StepVerifier.create(accountUpdateServiceImpl.updateAccount(account)).expectNext(false).expectComplete()
				.verify();
	}

	@AfterEach
	public void tearDownTest() {
		accountUpdateServiceImpl.deleteAccount(account.getAcc_id());
		System.out.println("After Each called...");
	}

	@AfterAll
	public static void tearDown() {

		System.out.println("After All called...");
	}
}
