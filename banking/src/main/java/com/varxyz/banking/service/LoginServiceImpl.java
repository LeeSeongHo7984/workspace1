package com.varxyz.banking.service;

import com.varxyz.banking.mvc.dto.Customer;

public class LoginServiceImpl implements LoginService {
	//3. serviceImpl -> loginDao
	@Override
	public Customer login(String dbId) {		// db userId
		return loginDao.login(dbId);	//db userId 
	}
}