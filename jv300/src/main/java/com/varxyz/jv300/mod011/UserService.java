package com.varxyz.jv300.mod011;

import java.util.List;	

import com.varxyz.jv300.mod010.User;

// 메소드 생성

public class UserService {
	private UserDao adduserdao = UserDao.getInstance();
	
	public UserService() {
      
	}
  
	public void addUser(User user) {
		adduserdao.insertUser(user);
		
	}

	public boolean isValidUser(String userId, String passwd) {
		return false;
	}

	public static UserService getInstance() {
		return null;
	}
	
	public List<User> getfindAllUser() {
		return adduserdao.findAllUser();
	}
}