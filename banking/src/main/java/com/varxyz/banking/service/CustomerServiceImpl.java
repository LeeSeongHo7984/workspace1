package com.varxyz.banking.service;

import com.varxyz.banking.mvc.dto.Customer;

public class CustomerServiceImpl implements CustomerService {
	
	@Override
	public void addCustomer(Customer customer) {	// 신규 고객 생성에 customer 정보가 필요
		customerDao.addCustomer(customer);
	}
	
}
