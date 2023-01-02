package com.varxyz.user.service;

import java.util.List;

import com.varxyz.user.domain.User;

public class UserServiceImpl implements UserService {

	
	// 회원가입
	@Override
	public void addUser(User user) {
		
		userDao.addUser(user);
	}

	// 회원 정보
	@Override
	public List<User> readUser(String userId) {
		
		return userDao.readUser(userId);
	}

	// 회원 정보 수정
	@Override
	public void userModify(User user) {
		
		userDao.userModify(user);
	}

	// 회원 탈퇴
	@Override
	public void userDelete(String userId) {
		
		userDao.userDelete(userId);
	}
	
	
	

}
