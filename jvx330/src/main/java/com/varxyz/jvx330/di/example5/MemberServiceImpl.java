package com.varxyz.jvx330.di.example5;

import com.varxyz.jvx330.di.example5.ex1.MemberService;

public class MemberServiceImpl implements MemberService {
	
	public MemberServiceImpl() {
		System.out.println("빈 생성 : " + this);
	}
	
	public void addMember(String id, String passwd) {
		System.out.println("New Member inserted : " + id + "/" + passwd);
	}
}
