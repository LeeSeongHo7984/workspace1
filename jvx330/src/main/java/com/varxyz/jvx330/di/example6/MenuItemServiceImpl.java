package com.varxyz.jvx330.di.example6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("menuItemService")	//@component("menuItemService") 는 beans.xml 안에 name="menuItemService" 이랑 같음
public class MenuItemServiceImpl implements MenuItemService {
   
   @Autowired // service는 itemDao가 필요하다
   private MenuItemDao itemDao; // itemDao 객체 생성
   

   @Override
   public void addMenuItem(MenuItem item) {
      itemDao.save(item);
   }

   public List<MenuItem> getAllMenuItemList() {
      return itemDao.findAllMenuItemList();
   }
   
   public MenuItem getMenuItem(String name) {
      return itemDao.findByName(name);
   }
   
}

// 여기가 service 역할