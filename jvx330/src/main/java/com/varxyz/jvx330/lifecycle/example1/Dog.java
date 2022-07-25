package com.varxyz.jvx330.lifecycle.example1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifecycle.AppConfig;

import lombok.Getter;
import lombok.Setter;

public class Dog implements InitializingBean, DisposableBean {
	private String name;
	
	public Dog(String name) {	// 생성자
		this.name = name;
	}
	
		public void setName(String name) {	// Setter
		this.name = name;
	}
	
	public String getName() {	// Getter
		return name;
	}
	
	public static void main(String[] args) {
		GenericApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Dog dog = context.getBean("dog", Dog.class);
		System.out.println("Dog's final name : " + dog.getName());
		context.close();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertitesSet 호출");
		if( name == null ) {
			System.out.println("Property name must be set");
		} else {
			System.out.println(name);
		}
		
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("destory호출");
	}


}
