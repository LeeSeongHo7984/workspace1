package com.varxyz.jvx330.jdbc;

import java.sql.Timestamp;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor	// 생성자
@ToString
public class Account {
	private long aid;
	private Customer customer;
	private String accountNum;
	private char accountType;
	private double balance;
	private Date regDate;
	
	public Account() {
		super();
	}
}
