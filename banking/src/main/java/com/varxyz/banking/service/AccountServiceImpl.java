package com.varxyz.banking.service;

import java.util.List;

import com.varxyz.banking.mvc.dto.Account;

public class AccountServiceImpl implements AccountService {
	
	// 계좌 생성
	@Override
	public void addAccount(Account account) {
		accountDao.addAccount(account);
	}
	
	// 계좌 조회
	@Override
	public List<Account> findAccountsByCustomerId(String customerId) {
		return accountDao.findAccountsByCustomerId(customerId);
	}
	
	// 입금
	@Override
	public void deposit(String accountNum, double money) {
		accountDao.deposit(accountNum, money);
	}
	
	// 출금
	@Override
	public void withdraw(String accountNum, double money) {
		accountDao.withdraw(accountNum, money);
	}
	
	// 잔액 조회
	@Override
	public List<Account> getBalance(String accountNum) {
		return accountDao.getBalance(accountNum);
	}

	
}
