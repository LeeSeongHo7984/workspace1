package com.varxyz.banking.mvc.dao;

import com.varxyz.banking.mvc.dto.Account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingAccount extends Account {
	private double interestRate;	// 이자율
	
	public void withdraw(double amount) {
		
	}
}

