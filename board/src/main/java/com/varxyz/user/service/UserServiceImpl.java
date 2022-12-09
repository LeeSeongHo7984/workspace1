package com.varxyz.user.service;

import java.util.List;

import com.varxyz.user.domain.User;

public class UserServiceImpl implements UserService {

	
	// 회원가입
	@Override
	public void addUser(User user) {
		
		userDao.addUser(user);
	}

	// 회원 정보ㄴ
	@Override
	public List<User> readUser(String userId) {
		
		return userDao.readUser(userId);
	}
	

}
