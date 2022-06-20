package com.varxyz.jv200.mod008;

public class PrimeException extends Exception {
	public PrimeException() {
	
	}		
	
	PrimeException(String message) {
		super(message);
	}
	
	public String getMessage() {
		return "입력하신 숫자은(는) 소수가 아닙니다.";
	}
}
