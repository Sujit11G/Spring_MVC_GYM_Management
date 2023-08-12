//package com.jsp.fit.controller;
//import java.util.List;
//
////
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.ModelAttribute;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.servlet.ModelAndView;
////import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import com.jsp.fit.dto.Customer;
//import com.jsp.fit.services.CustomerServices;
//import com.jsp.fit.services.BranchServices;
//
//@Controller
//public class CustomerController {
////
//	@Autowired
//	CustomerServices customerServices;
//	
//	@RequestMapping("/customerload")
//	public ModelAndView customerLoad() {
//	
//		ModelAndView modelAndView=new ModelAndView("saveCustomer.jsp");
//		
//		modelAndView.addObject("customer1", new Customer());
//		
//		return modelAndView;
//	}
//	
//	@PostMapping("/customeradd")
//	public ModelAndView saveCustomer(@ModelAttribute Customer customer,RedirectAttributes redirectAttributes) {
//		Customer c=customerServices.saveCustomer(customer);
//		ModelAndView modelAndView=new ModelAndView("redirect:home.jsp");
//		redirectAttributes.addFlashAttribute("saved", c.getName()+" saved successfully");
//		
//		return modelAndView;	
//	}

//public static void main(String[] args) {
//		
//		BranchServices branchServices=new BranchServices();
		
//	List <Customer> customers=branchServices.getAllCustomertoBrach(2);
//	
//	for(Customer c:customers) {
////		System.out.println(c.getName());
//	}
	
	
//}
//	
//	
//	
//
//
//
//}


