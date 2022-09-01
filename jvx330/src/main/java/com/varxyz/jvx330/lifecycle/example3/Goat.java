package com.varxyz.jvx330.lifecycle.example3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifecycle.AppConfig;
import com.varxyz.jvx330.lifecycle.example2.Eagle;

public class Goat {
	private static int count;
	
	public Goat() {
		count++;
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void main(String[] args) {
		GenericApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		context.getBean("goat", Goat.class);
		context.getBean("goat", Goat.class);
		context.getBean("goat", Goat.class);
		Eagle eagle = context.getBean("eagle", Eagle.class);
		System.out.println("Goat's final name : " + Goat.getCount());
		context.close();
	}
}
