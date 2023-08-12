//package com.jsp.fit.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//import com.jsp.fit.dto.Customer;
//import com.jsp.fit.services.CustomerServices;
//
//@Controller
//public class CustomerLogin {
//
//	@Autowired
//	CustomerServices customerServices;
//	
//	@GetMapping("/customer")
//	public ModelAndView login() {
//		ModelAndView modelAndView=new ModelAndView("customerLogin.jsp");
//		modelAndView.addObject("login1", new Customer());
//		return modelAndView;
//	}
//	
//	@PostMapping("/loginCustomer")
//	public ModelAndView loginForm(@ModelAttribute("login1") Customer login1){
//		int id = login1.getId();
//        String password = login1.getPassword();
//		Customer customer=customerServices.getCustomer(id);
//		if(customer!=null&&customer.getPassword().equals(password)) {
//			
//			return new ModelAndView("customerPage.jsp");
//		}else {
//			 ModelAndView modelAndView = new ModelAndView("customerLogin.jsp");
//	            modelAndView.addObject("authMessage", "Invalid ID or Password");
//			return  modelAndView;
//		}
//		
//	}
//}
