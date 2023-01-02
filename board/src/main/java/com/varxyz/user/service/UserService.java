package com.varxyz.user.service;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.varxyz.board.data.DataSourceConfig;
import com.varxyz.user.dao.UserDao;
import com.varxyz.user.domain.User;

@Service
public interface UserService {
	AnnotationConfigApplicationContext context =
			new AnnotationConfigApplicationContext(DataSourceConfig.class);
	
	UserDao userDao = context.getBean("userDao", UserDao.class);
	
	// 회원 가입
	public void addUser(User user);
	
	// 회원 정보
	public List<User> readUser(String userId);

	//회원 정보 수정
	public void userModify(User user);

	// 회원 탈퇴
	public void userDelete(String userId);

	
}
