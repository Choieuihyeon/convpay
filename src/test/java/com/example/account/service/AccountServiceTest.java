package com.example.account.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.account.domain.Account;
import com.example.account.type.AccountStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountServiceTest {
	@Autowired
	private AccountService accountService;

//	@BeforeEach
//	void init() {
//		accountService.createAccount();
//	}


	@Test
	@DisplayName("Test 이름 변경")
	void testGetAccount() {
		Account account = accountService.getAccount(1L);

		assertEquals("40000", account.getAccountNumber());
		assertEquals(AccountStatus.IN_USE, account.getAccountStatus());

	}

	@Test
	void testGetAccount2() {
		Account account = accountService.getAccount(2L);

		assertEquals("40000", account.getAccountNumber());
		assertEquals(AccountStatus.IN_USE, account.getAccountStatus());

	}


}