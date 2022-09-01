package com.varxyz.jvx330.di.example6;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class MenuItemServiceTest {

	   public static void main(String[] args) {
	      GenericApplicationContext context = 
	            new AnnotationConfigApplicationContext(AppConfig.class);

	      MenuItemService itemService = context.getBean("menuItemService", MenuItemService.class);
	      
	      //1. 등록
	      itemService.addMenuItem(new MenuItem("아메리카노", 1500.0));
	      itemService.addMenuItem(new MenuItem("카페모카", 4500.0));
	      itemService.addMenuItem(new MenuItem("자몽에이드", 5500.0));
	      
	      //2. 조회
	      List<MenuItem> list = itemService.getAllMenuItemList();
	      for(MenuItem item : list) {
	         System.out.println(item);
	      }
	      System.out.println("--------------------------------------------------------");
	      
	      //3. 검색
	      MenuItem item = itemService.getMenuItem("아메리카노");
	      System.out.println(item);
	      context.close();
	   }

	}