package com.varxyz.banking.mvc.dao;

import com.varxyz.banking.mvc.dto.Account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckingAccount extends Account {
	private double overdraftAmount;	// 한도액
}

