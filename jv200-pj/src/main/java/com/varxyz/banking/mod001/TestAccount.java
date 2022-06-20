package com.varxyz.banking.mod001;

public class TestAccount {
	public static void main(String[] args) {
		Account Ac = new Account(10000);	// 객체 생성
		// error가 나는 이유는 생성자가 하난데 ()괄호에 공백을 해서 error가 남!! 값을 넣어줘야 함
		System.out.println(Ac.getBalance());
	}
}
