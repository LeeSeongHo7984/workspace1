package com.varxyz.jvx330.jdbc.example5;

import com.varxyz.jvx330.jdbc.Account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingAccount extends Account {
	private double interestRate;	// 이자율
	
	public void withdraw(double amount) {
		
	}
}
