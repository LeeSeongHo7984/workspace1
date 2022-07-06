package com.varxyz.jv300.mod010;

public class UserService {
	private AddUserDao adduserdao = AddUserDao.getInstance();
	private static UserService instance = new UserService(); // 싱글톤
	private UserService() {
      
	}
   
	public static UserService getInstance() {
		return instance;
	}
   
	public void addUser(User user) {
		adduserdao.insertUser(user);
		
	}
}