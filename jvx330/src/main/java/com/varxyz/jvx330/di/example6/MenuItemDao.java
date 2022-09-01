package com.varxyz.jvx330.di.example6;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("menuItemDao")
public class MenuItemDao {
   private static final List<MenuItem> MENU = new ArrayList<>();
   
   
   /**
    * 신규 메뉴 추가
    * @param item
    */
   public void save(MenuItem item) {
      if(!MENU.contains(item)) {	// contains는 값이 안에 있는지 없는지 비교
         MENU.add(item);
      }
   }
   
   /**
    * 전체 메뉴 조회
    * @return
    */
   public List<MenuItem> findAllMenuItemList() {
      return MENU;
   }
   
   /**
    * 이름으로 메뉴 검색
    * @param name
    * @return
    */
   public MenuItem findByName(String name) {
      for(MenuItem item : MENU) {
         if(item.getName().equals(name)) {
            return item;
         }
      }
      throw new RuntimeException(name + " menu does not exist");
   }
}