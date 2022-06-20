package com.varxyz.banking.domain;

import java.util.List;

/*Customer (고객)
 * 이름 (name)
 * 주민번호 (ssn)
 * 연락처 (phone)
 * 고객id (customerId)
 * 비밀번호 (passwd)
 * 보유계좌 (List<Account> or Collection<Account>*/

/*CustomerService : Customer에 대한 서비스를 처리하는 클래스
 * 1. 주요 메소드
 *    - .addCustomer() : 신규 고객추가
 *  - .getCustomerBySsn : 주민번호로 고객 조회
 *  - .getAllCustomers() : 전체 고객 목록
 *  - .getNumOfCustomers() : 전체 고객 수
 * 
 * 
 * 2.
 *  -. CustomerService는 고객의 정보를 보관할 수 있는 속성을 유지해야 한다
 *  -. 고객의 정보를 유지할 수 있는 속성을 정의하라.*/


public class Customer {	// Customer 클래스는 고객 정보들
   private String name; //이름
   private String ssn; //주민번호
   private String phone; //연락처
   private String customerId; //고객id
   private String passwd; //비밀번호
   private List<Account> account; //보유계좌
   
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   public String getSsn() {
      return ssn;
   }
   
   public void setSsn(String ssn) {
      this.ssn = ssn;
   }
   
   public String getPhone() {
      return phone;
   }
   
   public void setPhone(String phone) {
      this.phone = phone;
   }
   
   public String getCustomerId() {
      return customerId;
   }
   
   public void setCustomerId(String customerId) {
      this.customerId = customerId;
   }
   
   public String getPasswd() {
      return passwd;
   }
   
   public void setPasswd(String passwd) {
      this.passwd = passwd;
   }
   
   public List<Account> getAccount() {
      return account;
   }
   
   public void setAccount(List<Account> account) {
      this.account = account;
   }
}