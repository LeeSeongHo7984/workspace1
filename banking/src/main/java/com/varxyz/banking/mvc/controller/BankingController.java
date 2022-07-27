package com.varxyz.banking.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.mvc.dto.Account;
import com.varxyz.banking.mvc.dto.Customer;
import com.varxyz.banking.service.AccountService;
import com.varxyz.banking.service.AccountServiceImpl;
import com.varxyz.banking.service.CustomerService;
import com.varxyz.banking.service.CustomerServiceImpl;

@Controller("controller.bankingController")
public class BankingController {
	
	CustomerService customerService = new CustomerServiceImpl();
	AccountService accountService = new AccountServiceImpl();
	
	// Customer
	@GetMapping("/customer/addCustomer")
	public String addCustomerForm() {
		return "customer/addCustomer";
	}

	@PostMapping("/customer/addCustomer")
	public String addCustomer(Customer customer, Model model) {
		
		model.addAttribute("customer", customer);
		customerService.addCustomer(customer);
		CustomerService.context.close();
		return "customer/successAddCustomer";
	}

	
	// Account
	@GetMapping("/account/addAccount")
	public String addAccountForm() {
		return "account/addAccount";
	}
	
	@PostMapping("/account/addAccount")
	public String addAccountForm(Account account, Model model) {
		
		model.addAttribute("account", account);
		accountService.addAccount(account);
		AccountService.context.close();
		
		return "account/successAddAccount";
	}
	
	// findAccount
	@GetMapping("/account/findAccount")
	public String findAccountForm() {
		return "account/findAccount";
	}
	
	@PostMapping("/account/findAccount")
	public String findAccountsByCustomerId(String customerId, Model model) {
		List<Account> account = new ArrayList<Account>();
		
		account = accountService.findAccountsByCustomerId(customerId);
		model.addAttribute("account", account);
		System.out.println(account.get(0).getAccountNum());
		AccountService.context.close();
		
		return "account/successFindAccount";
	}
}























