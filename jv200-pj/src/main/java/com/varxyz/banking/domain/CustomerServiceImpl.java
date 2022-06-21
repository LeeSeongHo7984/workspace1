package com.varxyz.banking.domain;

import java.util.Map;
import java.util.Collection;
import java.util.HashMap;

// Map 형식
public class CustomerServiceImpl implements CustomerService {
	private static CustomerService service = new CustomerServiceImpl();
    private Map<String, Customer> map = new HashMap<>();
   
    private CustomerServiceImpl() {
    	super();
   }
   
    public static CustomerService getInstance() {
	   return service;
   }
   
   @Override
   public void addCustomer(Customer customer) {
    if(!map.containsKey(customer.getSsn())) {
    map.put(customer.getSsn(), customer);
    }
 }


   @Override
   public Customer getCustomerByssn(String ssn) {
      if(map.containsKey(ssn)) {
         return map.get(ssn);
      }
      return null;
   }

   @Override
   public Collection<Customer> getAllCustomers() {
      return map.values();
   }

   @Override
   public int getNumOfCustomers() {
      return map.size();
   }

}