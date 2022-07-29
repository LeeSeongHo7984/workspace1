package com.varxyz.banking.service;

import java.util.List;

import com.varxyz.banking.mvc.dto.Customer;

public class LoginServiceImpl implements LoginService {
	
	@Override
	public Customer login(String z) {	
		return loginDao.login(z);
	}
}
