package banking;

import java.util.*;

public class CustomerDaoTest {

   public static void main(String[] args) {
      CustomerDao dao = new CustomerDao();

      //findAllCustomers() Test
      List<Customer> customerList = dao.findAllCustomer();
      for(Customer customer : customerList) {
         System.out.println(customer.toString());
      }
   
      // findCustomerBySsn
      Customer customer = dao.findCustomerBySsn("930418-1111111");
      System.out.println("---------------");
      System.out.println(customer);
      System.out.println("----------------");
      
      // addCustomer for DB
      Customer c = new Customer();
      c.setName("수호");
      c.setSsn("931212-1111111");
      c.setPhone("010-1111-1111");
      c.setCustomerId("spring");
      c.setPasswd("1111");
      dao.addCustomer(c);
   }

}
