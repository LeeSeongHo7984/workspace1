package com.varxyz.banking.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


//List로 처리
public class CustomerServiceImpl2 implements CustomerService {
   private List<Customer> customerList = new ArrayList<>();

   @Override
   public void addCustomer(Customer customer) {
      if(getCustomerByssn(customer.getSsn()) == null) {
         customerList.add(customer);
      }
      
   }

   @Override
   public Customer getCustomerByssn(String ssn) {
      for(Customer c : customerList) {
         if(ssn.equals(c.getSsn())) {
            System.out.println("이름 : "+c.getName()+"\n주민번호 : "+ssn 
            + "\n휴대전화 : " + c.getPhone() + "\n아이디 : " + c.getCustomerId() 
            + "\n비밀번호 : " + c.getPasswd() + "\n보유계좌 : " + c.getAccount());
            //getName을 사용하여야만 주소값안에 있는 value값이 호출됨
            return c;
         } else {
        	 System.out.println("찾으시는 회원정보가 없습니다.");
         }
      }
      return null;
   }

   @Override
   public Collection<Customer> getAllCustomers() {
      return customerList;
   }
   
   @Override
   public int getNumOfCustomers() {
      return customerList.size();
   }
}