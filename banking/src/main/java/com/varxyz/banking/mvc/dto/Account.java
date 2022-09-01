package com.varxyz.banking.mvc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
	private long aid;
	private String customerId;
	private String accountNum;
	private String accType;
	private String deposit;	// 입금
	private String withdrawal;	// 출금
	private double balance;	// 잔고
	private double interestRate;	// 이자율
	private double amount;	// 총액
	
	public Account() {
		super();
	}
}
