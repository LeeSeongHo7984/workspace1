package com.varxyz.jv251.exception;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends RuntimeException {
	private double balance;
	
	public InsufficientBalanceException (String msg) {
		super(msg);
	}
	
	public InsufficientBalanceException(String msg, double balance) {
		super(msg);
		this.balance = balance;
	}
	
	public String getMessage() {
		return super.getMessage() + "현제 잔고는" + balance + "입니다";
	}
}
