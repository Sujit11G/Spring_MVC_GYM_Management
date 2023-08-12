package com.jsp.fit.customercontroller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.fit.dto.Branch;
import com.jsp.fit.dto.Customer;
import com.jsp.fit.dto.Facility;
import com.jsp.fit.services.BranchServices;
import com.jsp.fit.services.CustomerServices;
import com.jsp.fit.services.FacilityServices;

@Controller
public class CustomerPage {

	@Autowired
	CustomerServices customerServices;
	
	@Autowired
	BranchServices branchServices;
	
	@Autowired
	FacilityServices facilityServices;
	
	@RequestMapping("/loginCustomer")
	public ModelAndView profile(HttpServletRequest req) {

			Integer id=(Integer) req.getSession().getAttribute("customerId");
			Customer customer=customerServices.getCustomer(id);
			
			ModelAndView modelAndView=new ModelAndView("customerPage.jsp");
			modelAndView.addObject("customer",customer);

		
		return modelAndView;	
	}
	
	@PostMapping("/customerDetails")
	public ModelAndView customerData(@RequestParam(name = "customerId") int id,@RequestParam(name="branchId")int bId,@RequestParam(name = "bmi")double BMI,
			@RequestParam(name = "time")String timeSlot) {
		Customer customer=customerServices.getCustomer(id);
		if(customer!=null) {
	    customer.setTimeSlot(timeSlot);
	    customer.setBMI(BMI);
		customerServices.updateCustomer(customer);

		}

		return new ModelAndView("redirect:customerPage.jsp");
		
	}
	
	
}
