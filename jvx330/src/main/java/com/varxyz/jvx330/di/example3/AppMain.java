package com.varxyz.jvx330.di.example3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class AppMain {
	public static void main(String[] args) {
	//	String config = "com/varxyz/jvx330/di/example3/beans.xml";
		GenericApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService service = context.getBean("memberService", MemberService.class);
		service.getAllMembers().forEach(member -> System.out.println(member));

//		위의 람다식을 풀어쓰면 밑에 코드
//		List<Member> list = service.getAllMembers();
//		for(Member member : list) {
//			System.out.println(member);
//		}
		context.close();
	}
}
