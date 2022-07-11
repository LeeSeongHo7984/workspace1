package com.varxyz.jv300.mod010;

import java.util.List;

import com.varxyz.jv300.mod011.UserDao;

public class UserService {
	
	private UserDao  userdao = UserDao.getInstance();
	
	private static UserService instance = new UserService(); // 싱글톤, static은 모든 객체가 메모리를 공유
	
	private UserService() {
      
	}
   
	public static UserService getInstance() {
		return instance;
	}
   
	public void addUser(User user) {
		userdao.insertUser(user);
		
	}
	
	public void userList(User user) {
		
	}

	public List<User> getfindAllUser() {
		return userdao.findAllUser();
	}

}