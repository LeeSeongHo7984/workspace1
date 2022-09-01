package com.varxyz.jvx330.mvc.example5;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("example5.addCustomerController")	// 빈에게 등록하라고 적어줌
@RequestMapping("/example5/add_customer")
public class AddCustomerController {
	
	@GetMapping
	public String addCustomerForm(Model model) {
		model.addAttribute("customer", new CustomerCommand());
		
		return "example5/add_customer";
	}
	
	@ModelAttribute("emailProviderList")
	public List<EmailProvider> getEmailProviderList() {
		List<EmailProvider> list = new ArrayList<EmailProvider>();
		list.add(new EmailProvider("Google", "gamil.com"));
		list.add(new EmailProvider("Naver", "naver.com"));
		list.add(new EmailProvider("Daum", "kakao.com"));
		
		return list;
	}
	
	@ModelAttribute("phoneProviderList")
	public List<String> getPhoneProviderList() {
		List<String> list = new ArrayList<String>();
		list.add("010");
		list.add("02");
		list.add("053");
		
		return list;
	}
	
	@PostMapping
	public String addCustomer(@ModelAttribute("customer") 
							CustomerCommand customer, Model model) {
		
		String email = customer.getEmail1() + "@" + customer.getEmail2();
		String phone = customer.getPhone1() + "-" + customer.getPhone2() 
					+ customer.getPhone3();		
		
		customer.setEmail(email);	// setEmail 해줘야 성공페이지에서 내가 입력한 이메일이 뜬다.
		customer.setPhone(phone);	// setPhone 해줘야 성공페이지에서 내가 입력한 전화번호가 뜬다.
		model.addAttribute("customer", customer);
		
		// db처리
		// ....
		// customer = customerServcie.addCustomer(customer); db에서 customer를 받음
		
		return "example5/success_add_customer";
	}
}
