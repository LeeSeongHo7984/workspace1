package com.varxyz.jvx330.di.example1;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.varxyz.jvx330.intro.Hello;

public class AppMain {
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example1/beans.xml";	//beans.xml 경로
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(config);
		
		Foo foo = context.getBean("foo", Foo.class);
		System.out.println(foo);
		
		Foo foo2 = context.getBean("foo", Foo.class);	// "foo"는 beans.xml에 name=""이랑 같아야함
		System.out.println(foo2);
		context.close();
		
//		기존 방식
//		Bar bar = new Bar();
//		Foo foo = new Foo(bar);
	}
}
