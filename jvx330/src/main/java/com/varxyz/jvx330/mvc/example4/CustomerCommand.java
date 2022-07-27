package com.varxyz.jvx330.mvc.example4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerCommand {
	private String email;
	private String passwd;
	private String name;
	private String ssn;
	private String phone;
}
