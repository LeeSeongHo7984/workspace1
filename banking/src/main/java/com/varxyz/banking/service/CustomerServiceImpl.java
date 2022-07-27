package com.varxyz.banking.service;

import com.varxyz.banking.mvc.dto.Customer;

public class CustomerServiceImpl implements CustomerService {
	
	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
}
