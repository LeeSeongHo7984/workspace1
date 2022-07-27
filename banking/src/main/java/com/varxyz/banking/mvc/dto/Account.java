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
	private double balance;
	private double interestRate;
	private double overAmount;
	
	public Account() {
		super();
	}
}
