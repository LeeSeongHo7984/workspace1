package com.varxyz.banking.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
	private long cid;
	private String userId;
	private String passwd;
	private String name;
	private String ssn;
	private String phone;
	
	public Customer() {
		super();
	}

	public Customer(long cid) {
		this.cid = cid;
	}
}
