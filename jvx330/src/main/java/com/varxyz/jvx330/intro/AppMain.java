package com.varxyz.jvx330.intro;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/intro/beans.xml";	//beans.xml 경로
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(config);
		
		// 괄호안("helloBean")은 beans.xml파일에 name이랑 값이 동일해야 한다.
		Hello hello = context.getBean("helloBean", Hello.class);
		// Hello hello = new HelloBeanEn();
		System.out.println(hello.sayHello("Spring"));
		context.close();
	}
}
