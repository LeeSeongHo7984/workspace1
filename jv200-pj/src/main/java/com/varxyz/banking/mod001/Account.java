package com.varxyz.banking.mod001;

/**
 * 계좌정보를 캡슐화
 * 
 * @author Administrator
 * 
 */

public class Account {
	double balance;
	
	public Account(double initBalance) {
		balance = initBalance;
	}
	
	public double getBalance() {	// void 가 붙지 않으면 return을 해야 error이 안남 (return 은 타입)
		return balance;
	}
	
	public void deposite(double amt) {
		
	}
	
	public void withdraw(double amt) {
		
	}
}


// 문제
//Account
//
//<<constructors>>
//+Account (initBalance: double)
//
//<<method>>
//+getBalance(): double
//+deposit(amt:double): void
//+withdraw(amt:double):void