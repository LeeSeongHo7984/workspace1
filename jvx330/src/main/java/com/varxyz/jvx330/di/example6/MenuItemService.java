package com.varxyz.jvx330.di.example6;

import java.util.List;

import org.springframework.stereotype.Component;

public interface MenuItemService {

   void addMenuItem(MenuItem item);

   List<MenuItem> getAllMenuItemList();

   MenuItem getMenuItem(String string);

}

// 