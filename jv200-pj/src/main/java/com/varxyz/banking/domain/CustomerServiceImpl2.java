package com.varxyz.banking.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


//List로 처리
public class CustomerServiceImpl2 implements CustomerService {
   private List<Customer> customerList = new ArrayList<Customer>();	// customerList 생성

   public void addCustomer(Customer customer) {
      if(getCustomerByssn(customer.getSsn()) == null) {
         customerList.add(customer);	//customerList에 customer 값들을 추가
      }
   }

   public Customer getCustomerByssn(String ssn) {
      for(Customer c : customerList) {	// 객체 c에 값과 customer 값들이 추가된 customerLis의 값들을 각각 비교
         if(ssn.equals(c.getSsn())) {	// equals는 문자 비교 (ssn안에 문자값과 c.getSsn 문자값을 비교)
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

   public Collection<Customer> getAllCustomers() {
      return customerList;
   }
   
   public int getNumOfCustomers() {
      return customerList.size();
   }
}	