package com.varxyz.jv200.mod009;

import java.util.*;

public class MapExample {
	public static void main(String[] args) {
	      Map<Integer, String> map = new HashMap<Integer, String>(); // int는 primitive 자료형으로 객체가 아니기 때문에 Integer로 사용
	      map.put(Integer.valueOf(1), "돈까스"); // 1:돈까스 이런식으로 key,value형태로 저장이 가능하다
	      map.put(2, "우동"); // java 5.0부터 autoboxing이라는 기능이 추가되어 2자체는 primitive형태이지만 자동으로 boxing을 해주기때문에 사용이 가능하다.
	      map.put(new Integer(3), "라면");  // new Integer(int) 형태는 자바 9때부터 deprecated 되었다 deprecated란 과거에는 쓰였으나 지금은 되도록 쓰지말라는 뜻으로 권고된다. 
	      
	      System.out.println(map.get(1));
	      
	      // 출력시 1의 key 값인 돈까스가 출력됨
	      
	      Set<Integer> set = map.keySet();

	      for(Integer integer : set) {
	         System.out.print(integer);
	         System.out.println(" = " + map.get(integer)); // 이렇게 사용시 키의 값을 차례대로 뽑을수있다
	      }
	      // key 값을 뽑고싶을때 사용
	}
}
