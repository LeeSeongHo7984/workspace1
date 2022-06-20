package com.varxyz.jv200.mod009;

import java.util.*;

public class ListExample2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();	// List를 String 형식으로 생성 문법
		list.add(0, new String("Hello Java"));
		String total = ((String)list.get(0));	// list.get (get으로 값을 불러올 수 있음)
		System.out.println(total);
	}
}


// List for문 형식
//	for( int i = 0; i < list.size(); i++) {
//		Object o = list.get(i);
//	};