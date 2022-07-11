package com.varxyz.jv300.mod011;

import java.util.List;	

import com.varxyz.jv300.mod010.User;

// 메소드 생성
// 메소드 집합
public class UserService {
	private UserDao userdao = UserDao.getInstance();
	
	private static UserService instance = new UserService();
	
	public UserService() {
      
	}
  
	public void addUser(User user) {
		userdao.insertUser(user);
		
	}
	
	// 5. 이 함수의 결과가 또 equalsUser를 호출함 -> equalsUser 메소드의 결과가 곧 임마의 결과
	// 6. 그래서 equalsUser 메소드를 확인하러 가야함
	// 9. equalsUser 메소드 에서 반환된 결과가 여기로 들어감 
	public boolean isValidUser(String userId, String passwd) {	// 로그인페이지에서 내가 친 아이디, 비번 값이 들어감
		return userdao.equalsUser(userId, passwd);
	}

	public static UserService getInstance() {
		return instance ;
	}
	
	public List<User> getfindAllUser() {
		return userdao.findAllUser();
	}
}