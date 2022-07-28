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

	// Customer : 고객 생성
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

	// Account : 계좌 생성
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

	// findAccount : 아이디로 계좌 목록 조회
	@GetMapping("/account/findAccount")
	public String findAccountForm() {
		return "account/findAccount";
	}

	@PostMapping("/account/findAccount")
	public String findAccountsByCustomerId(String customerId, Model model) {
		List<Account> accountList = new ArrayList<Account>();

		accountList = accountService.findAccountsByCustomerId(customerId);
		model.addAttribute("accountList", accountList);
		AccountService.context.close();

		return "account/successFindAccount";
	}

	// 입금
	@GetMapping("/account/deposit")
	public String deposit() {
		return "account/deposit";
	}

	@PostMapping("/account/deposit")
	public String deposit(String accountNum, double money) { // 파라미터명이랑 jsp name="" 안에 값이랑 같아야 한다

		accountService.deposit(accountNum, money);
		AccountService.context.close();

		return "account/successDeposit";
	}

	// 출금
	@GetMapping("/account/withdraw")
	public String withdraw() {
		return "account/withdraw";
	}
	@PostMapping("/account/withdraw")
	public String withdraw(String accountNum, double money) { // 파라미터명이랑 jsp name="" 안에 값이랑 같아야 한다

		accountService.withdraw(accountNum, money);
		AccountService.context.close();

		return "account/successWithdraw";
	}

	// getBalance : 잔고 확인
	@GetMapping("/account/balance")
	public String balanceForm() {
		return "account/balance";
	}
	
	@PostMapping("/account/balance")
	public String getBalance(String accountNum, Model model) {
		List<Account> accountList = new ArrayList<Account>();

		accountList = accountService.getBalance(accountNum);
		model.addAttribute("accountList", accountList);
		System.out.println(accountList.get(0).getBalance());
		AccountService.context.close();

		return "account/successBalance";
	}

}









/*
 * deposit method
 * 
 * 1) controller의 파라미터 이름이 jsp name값이랑 달랐음
 * 
 * 2) dao에 [ getBalance(accountNum).get(0).getBalance() + money ] 얘 타입이 달라서 연산이
 * 안됬음
 * 
 * 3) dao에 deposit 메소드 타입을 리스트로 받아줄 필요가 없었음 -> 입금기능은 이체를 위해 만드는거라 결과값 끄집어내려 할 필요
 * X == controller에서 model로 값 넘겨줄 필요 X
 */
