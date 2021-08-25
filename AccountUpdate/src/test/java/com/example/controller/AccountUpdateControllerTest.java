package com.example.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.model.Accounts;
import com.example.service.AccountUpdateService;

import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountUpdateControllerTest {

	@Autowired
	private WebTestClient webTestClient;

	@MockBean
	private AccountUpdateService accountUpdateService;

	private Accounts account;

	@BeforeEach
	public void setupTest() {
		System.out.println("Before Each called...");
		account = new Accounts(1, "ABC", "abc", "user", "pass", "add", "stae", "country", "email", "pan", "12345",
				"12/12/12");
	}

	@Test
	public void testDeleteAccount_GivenId() {
		Mockito.when(accountUpdateService.deleteAccount(1)).thenReturn(Mono.just(true));
		webTestClient.delete().uri("/update/1").exchange().expectStatus().isAccepted();
	}

	@Test
	public void testUpdateAccount_updateAccountType() {
		account.setAcc_type("type");
		Mockito.when(accountUpdateService.updateAccount(account)).thenReturn(Mono.just(true));
		webTestClient.put().uri("/update/1").body(Mono.just(account), Accounts.class).exchange().expectStatus().isOk()
				.expectBody().jsonPath("$.message").isEqualTo("Account is Updated");
	}

	@Test
	public void testUpdateAccount_updateAccountName() {
		account.setAcc_name("another name");
		Mockito.when(accountUpdateService.updateAccount(account)).thenReturn(Mono.just(true));
		webTestClient.put().uri("/update/1").body(Mono.just(account), Accounts.class).exchange().expectStatus().isOk()
				.expectBody().jsonPath("$.message").isEqualTo("Account is Updated");
	}

	@Test
	public void testUpdateAccount_updateUsername() {
		account.setAcc_name("username");
		Mockito.when(accountUpdateService.updateAccount(account)).thenReturn(Mono.just(true));
		webTestClient.put().uri("/update/1").body(Mono.just(account), Accounts.class).exchange().expectStatus().isOk()
				.expectBody().jsonPath("$.message").isEqualTo("Account is Updated");
	}

	@Test
	public void testUpdateAccount_updatePassword() {
		account.setPassword("passowrd");
		Mockito.when(accountUpdateService.updateAccount(account)).thenReturn(Mono.just(true));
		webTestClient.put().uri("/update/1").body(Mono.just(account), Accounts.class).exchange().expectStatus().isOk()
				.expectBody().jsonPath("$.message").isEqualTo("Account is Updated");
	}

	@Test
	public void testUpdateAccount_updateAddress() {
		account.setAddress("address");
		Mockito.when(accountUpdateService.updateAccount(account)).thenReturn(Mono.just(true));
		webTestClient.put().uri("/update/1").body(Mono.just(account), Accounts.class).exchange().expectStatus().isOk()
				.expectBody().jsonPath("$.message").isEqualTo("Account is Updated");
	}

	@Test
	public void testUpdateAccount_updateState() {
		account.setAddress("state");
		Mockito.when(accountUpdateService.updateAccount(account)).thenReturn(Mono.just(true));
		webTestClient.put().uri("/update/1").body(Mono.just(account), Accounts.class).exchange().expectStatus().isOk()
				.expectBody().jsonPath("$.message").isEqualTo("Account is Updated");
	}

	@Test
	public void testUpdateAccount_updateCountry() {
		account.setCountry("country");
		Mockito.when(accountUpdateService.updateAccount(account)).thenReturn(Mono.just(true));
		webTestClient.put().uri("/update/1").body(Mono.just(account), Accounts.class).exchange().expectStatus().isOk()
				.expectBody().jsonPath("$.message").isEqualTo("Account is Updated");
	}

	@Test
	public void testUpdateAccount_updateEmail() {
		account.setEmail("abc@mail.com");
		Mockito.when(accountUpdateService.updateAccount(account)).thenReturn(Mono.just(true));
		webTestClient.put().uri("/update/1").body(Mono.just(account), Accounts.class).exchange().expectStatus().isOk()
				.expectBody().jsonPath("$.message").isEqualTo("Account is Updated");
	}

	@Test
	public void testUpdateAccount_updatePan() {
		account.setPan("djijwjd1121");
		Mockito.when(accountUpdateService.updateAccount(account)).thenReturn(Mono.just(true));
		webTestClient.put().uri("/update/1").body(Mono.just(account), Accounts.class).exchange().expectStatus().isOk()
				.expectBody().jsonPath("$.message").isEqualTo("Account is Updated");
	}

	@Test
	public void testUpdateAccount_updateContactNumber() {
		account.setContact_no("country");
		Mockito.when(accountUpdateService.updateAccount(account)).thenReturn(Mono.just(true));
		webTestClient.put().uri("/update/1").body(Mono.just(account), Accounts.class).exchange().expectStatus().isOk()
				.expectBody().jsonPath("$.message").isEqualTo("Account is Updated");
	}

	@Test
	public void testUpdateAccount_updateDob() {
		account.setDob("country");
		Mockito.when(accountUpdateService.updateAccount(account)).thenReturn(Mono.just(true));
		webTestClient.put().uri("/update/1").body(Mono.just(account), Accounts.class).exchange().expectStatus().isOk()
				.expectBody().jsonPath("$.message").isEqualTo("Account is Updated");
	}

}
