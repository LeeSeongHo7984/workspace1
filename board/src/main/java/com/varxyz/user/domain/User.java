package com.varxyz.user.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
	private String userId;
	private String passwd;
	private String name;
	private String ssn;
	private String address;
	private String phone;
	
}
