package com.varxyz.banking.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

//	 home : 메인 페이지
	@GetMapping("/homePage")
	// ↓ model을 쓰는 이유는 jsp에서 el태그로 뿌려줄려고 씀
	public String homePageForm(HttpSession session, Model model) {
		if(session.getAttribute("customerId") == null) {
			return "login/login";
		}
		
		// ↓ 로그인한 사람의 계좌를 통해서 기능을 쓸려고 정의해 놓은 것
		model.addAttribute("accountNum", accountService.findAccountsByCustomerId((String)session.getAttribute("customerId")));
		return "/homePage";
	}
	
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
	
	
	// login : 로그인 && 세션연결
	@GetMapping("/login/login")
	public String loginForm(HttpSession session) {
		session.invalidate();	// 기존세션값 삭제
		return "login/login";
	}
	
	@PostMapping("/login/login")
	public String login(Customer customer, HttpSession session, HttpServletRequest request, Model model) { //input Id
		session = request.getSession();
	
		Customer dbGetCustomer = new Customer();
		
		// 1.controller -> Service  
		dbGetCustomer = loginService.login(customer.getUserId()); //db userId (Customer 클래스에 있는 값을 customer라는 이름으로 가져와서 loginService.login에 값 넣어서 받음)
		// ↑서비스를 썼으면 서비스 안에 값을 불러와야 한다. (28, 32, 36번 줄에 서비스 객체 생성한게 있음)		
		// 리스트에서 객체를 가져온 다음 값을 가져온다
		// System.out.println(customerService.login(y.getUserId()).get(0).getUserId()); : dao에 query 쓸때 쓰는 방법
		
		//5 ↓ 끝 
 		if(customer.getPasswd().equals(dbGetCustomer.getPasswd())
				&& customer.getUserId().equals(dbGetCustomer.getUserId())) {
			System.out.println("서비스 불러온거 - > "+loginService.login(customer.getUserId()).getUserId());
			System.out.println("성공");
			return "/homePage"; 
		} else {
			model.addAttribute("아이디 또는 비밀번호를 다시 확인하세요!");
			System.out.println("사용자가 친것 -> " + customer.getUserId() );
			System.out.println("실패");
			return "/login/login";
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
	public String deposit(String accountNum, double amount) { // 파라미터명이랑 jsp name="" 안에 값이랑 같아야 한다

		accountService.deposit(accountNum, amount);
		AccountService.context.close();

		return "account/successDeposit";
	}

	// 출금
	@GetMapping("/account/withdraw")
	public String withdraw() {
		return "account/withdraw";
	}
	
	@PostMapping("/account/withdraw")
	public String withdraw(String accountNum, double amount) { // 파라미터명이랑 jsp name="" 안에 값이랑 같아야 한다

		accountService.withdraw(accountNum, amount);
		AccountService.context.close();

		return "account/successWithdraw";
	}

	// Balance : 잔고 확인
	@GetMapping("/account/balance")
	public String balanceForm() {
		return "account/balance";
	}
	
	@PostMapping("/account/balance")
	public String Balance(String accountNum, Model model) {
		List<Account> accountList = new ArrayList<Account>();

		accountList = accountService.Balance(accountNum);
		model.addAttribute("accountList", accountList);
		System.out.println(accountList.get(0).getBalance());
		AccountService.context.close();

		return "account/successBalance";
	}
	
	// 이체
	@GetMapping("/transfer/transfer")
	public String transferForm() {
		return "transfer/transfer";
	}
	
	@PostMapping("/transfer/transfer")
	public String transfer(String sendAccount, String receiveAccount, Double amount) {

		accountService.withdraw(sendAccount, amount);
		accountService.deposit(receiveAccount, amount);
		
		return "transfer/successTransfer";
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
 * 
 * 번외
 * public String login(Customer y) : y라는 파라미터는 login이라는 
 * 메소드 안에서만 실행되기 때문에 다른데서는 쓸 수 없다.
 */
