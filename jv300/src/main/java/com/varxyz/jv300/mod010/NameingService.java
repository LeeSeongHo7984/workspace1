package com.varxyz.jv300.mod010;

import java.util.HashMap;
import java.util.Map;

public class NameingService {
	private static NameingService obj = new NameingService();
	private Map<String, Object> nameValuePairs;
	
	private NameingService() {
		nameValuePairs = new HashMap<String, Object>();
	}
	
	public static NameingService getInstance() {
		return obj;
	}
	
	public void setAttribute(String name, Object obj) {
		if(!nameValuePairs.containsKey(name)) {
			nameValuePairs.put(name,obj);
		}else {
			throw new IllegalArgumentException("This name," + name + ", is already in use.");
		}
	}
	
	public Object getAttribute(String name) {
		return nameValuePairs.get(name);
	}
	
	public void removeAttribute(String name) {
		nameValuePairs.remove(name);
	}
}
