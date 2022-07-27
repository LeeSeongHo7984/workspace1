package com.varxyz.banking.service;

import java.util.List;

import com.varxyz.banking.mvc.dto.Account;

public class AccountServiceImpl implements AccountService {
	
	@Override
	public void addAccount(Account account) {
		accountDao.addAccount(account);
	}
	
	@Override
	public List<Account> findAccountsByCustomerId(String customerId) {
		return accountDao.findAccountsByCustomerId(customerId);
	}
}
