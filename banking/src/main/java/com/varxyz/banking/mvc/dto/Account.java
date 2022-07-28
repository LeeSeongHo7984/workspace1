package com.varxyz.banking.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Account {
	private long aid;
	private String customerId;
	private String accountNum;
	private String accType;
	private String deposit;	// 입금
	private String withdrawal;	// 출금
	private double balance;	// 잔고
	private double interestRate;	// 이자율
	private double overAmount;	// 한도액
	
	public Account() {
		super();
	}
}
