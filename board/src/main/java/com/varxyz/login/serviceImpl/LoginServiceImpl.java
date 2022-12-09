package com.varxyz.login.serviceImpl;

import com.varxyz.login.service.LoginService;
import com.varxyz.user.domain.User;

public class LoginServiceImpl implements LoginService {

	@Override
	public User login(String userId) {
		
		return loginDao.login(userId);
		
	}

}
