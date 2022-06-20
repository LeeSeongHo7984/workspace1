package com.varxyz.banking.domain;

import java.util.List;

public interface AccountService {
	public Account createSavingsAccount(String accountNum, double balance, double interestRate);
	public Account createCheckingAccount(String accountNum, double balance, double overdraftAmount);
	public void addAccount(Account account);
	public void addAccount(Account account, String ssn);
	public List<Account> getAccountBySsn(String ssn);
	public Account getAccountByAccountNum(String accounNum);
}
