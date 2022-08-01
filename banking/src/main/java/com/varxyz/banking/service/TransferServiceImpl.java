package com.varxyz.banking.service;

import com.varxyz.banking.mvc.dto.Account;

public class TransferServiceImpl implements TransferService {
	
	@Override
	public Account transfer(String deposit, String withdraw, String accountNum) {
		return transferDao.transfer();
	}
}
