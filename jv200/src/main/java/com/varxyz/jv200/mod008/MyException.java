package com.varxyz.jv200.mod008;

public class MyException extends Exception {
	public MyException() {
		
	}
	
	MyException(String message) {
		super(message);
	}
	
	public String getMessage() {
		return "0 또는 음수는 입력할 수 없습니다.";
	}
}
