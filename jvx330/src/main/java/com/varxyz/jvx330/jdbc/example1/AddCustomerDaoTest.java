package com.varxyz.jvx330.jdbc.example1;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.DataSourceConfig;

public class AddCustomerDaoTest {

	   public static void main(String[] args) {
	      AnnotationConfigApplicationContext context = 
	            new AnnotationConfigApplicationContext(DataSourceConfig.class);
	      
	      AddCustomerDao dao = context.getBean("addCustomerDao", AddCustomerDao.class);
//	      addCustomer(dao);
	      addCustomer2(dao);
//	      addCustomer3(dao);
	      
	      context.close();
	   }
	   
	   public static void addCustomer(AddCustomerDao dao) {
	      Customer c = new Customer();
	      c.setEmail("yubi@java.com");
	      c.setPasswd("1111");
	      c.setName("유비");
	      c.setSsn("980618-1234567");
	      c.setPhone("010-3490-3180");
	      
	      dao.addCustomer(c);
	      System.out.println("-inserted-");
	   }

	   public static void addCustomer2(AddCustomerDao dao) {
	      Customer c = new Customer();
	      c.setEmail("sssssg06@java.com");
	      c.setPasswd("1234");
	      c.setName("Boy");
	      c.setSsn("980618-1234567");
	      c.setPhone("010-3490-3180");
	      
	      dao.addCustomer2(c);
	      System.out.println("-inserted2-");
	   }
	   
	   public static void addCustomer3(AddCustomerDao dao) {
	      Customer c = new Customer();
	      c.setEmail("psg@java.com");
	      c.setPasswd("0070");
	      c.setName("Girl");
	      c.setSsn("980618-1234567");
	      c.setPhone("010-3490-3180");
	      
	      long key = dao.addCustomer3(c);
	      System.out.println("key : " + key);
	      System.out.println("-inserted2-");
	   }
	   
	}

