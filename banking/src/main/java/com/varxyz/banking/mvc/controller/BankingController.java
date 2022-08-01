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
import com.varxyz.banking.service.LoginService;
import com.varxyz.banking.service.LoginServiceImpl;

@Controller("controller.bankingController")
public class BankingController {

	// CustomerService는 interface라서 객체를 못만드니까 
	// CustomerService를 상속받은 CustomerServiceImpl을 받는다
	CustomerService customerService = new CustomerServiceImpl();
	
	// AccountService는 interface라서 객체를 못만드니까 
	// AccountService를 상속받은 AccountServiceImpl을 받는다
	AccountService accountService = new AccountServiceImpl();
	
	// LoginService는 interface라서 객체를 못만드니까 
	// LoginService를 상속받은 LoginServiceImpl을 받는다
	LoginService loginService = new LoginServiceImpl();

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
	
	
	// login : 로그인
	@GetMapping("/login/login")
	public String loginForm() {
		return "login/login";
	}
	
	@PostMapping("/login/login")
	public String login(Customer customer) { //input Id 근데 여기 y가 내가 입력한 input id면
		// 서비스를 썼으면 서비스 안에 값을 불러와야 한다. (23, 24, 25번 줄에 서비스 객체 생성한게 있음)
		// 리스트에서 객체를 가져온 다음 값을 가져온다
		// System.out.println(customerService.login(y.getUserId()).get(0).getUserId());
	
		Customer dbGetCustomer = new Customer();
		
		//1.controller -> Service  
		dbGetCustomer = loginService.login(customer.getUserId()); //db userId (Customer 클래스에 있는 값을 customer라는 이름으로 가져와서 loginService.login에 값 넣어서 받음)
		
		//5 ↓ 끝 
 		if(customer.getPasswd().equals(dbGetCustomer.getPasswd())
				&& customer.getUserId().equals(dbGetCustomer.getUserId())) {
			System.out.println("서비스 불러온거 - > "+loginService.login(customer.getUserId()));
			System.out.println("성공");
			return "login/successLogin"; 
		} else {
			System.out.println("사용자가 친것 -> " + customer.getUserId() );
			System.out.println("실패");
			return "login/login";
		}
			
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
	
	// 이체
//	@GetMapping("/transfer/transfer")
//	public String tranferFomr() {
//		return "transfer/transfer";
//	}
//	
//	@PostMapping("/transfer/transfer")
//	public String 
//	
//
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
 * 
 * 번외
 * public String login(Customer y) : y라는 파라미터는 login이라는 
 * 메소드 안에서만 실행되기 때문에 다른데서는 쓸 수 없다.
 */
