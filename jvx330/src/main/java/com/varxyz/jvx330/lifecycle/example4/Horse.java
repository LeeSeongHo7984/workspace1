package com.varxyz.jvx330.lifecycle.example4;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifecycle.AppConfig;

public class Horse implements InitializingBean, DisposableBean{
	   private static int count;
	   
	   public Horse() {
	      count++;
	   }
	   
	   public static int getCount() {
	      return count;
	   }
	   
	   @Override
	   public void afterPropertiesSet() throws Exception {
	      System.out.println("afterPropertiesSet 호출");
	      if(count == 0) {
	         System.out.println("Property name must be set");
	      }else {
	         System.out.println("Horse: "+count);
	      }
	   }
	   
	   @Override
	   public void destroy() throws Exception {
	      System.out.println("Horse destory 호출");
	   }
	   
	   public static void main(String[] args) {
	      GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	      context.getBean("horse", Horse.class);
	      context.getBean("horse", Horse.class);
	      context.getBean("horse", Horse.class);
	      
	      System.out.println("Horse's final count: " + Horse.getCount());
	      context.close();
	   }
	}