package com.jsp.fit.customercontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
public class CustomerController {

	@Autowired
	CustomerServices customerServices;
	
	@Autowired
	BranchServices branchServices;
	
	@Autowired
	FacilityServices facilityServices;
	
	
	@RequestMapping("/customerload")
	public ModelAndView customerLoad() {
	
		
		ModelAndView modelAndView=new ModelAndView("saveCustomer.jsp");
		modelAndView.addObject("customer",  new Customer());
		modelAndView.addObject("branches", branchServices.getAllBranches());
//		modelAndView.addObject("facilities", facilityServices.getFacilities());

		return modelAndView;
	}
	
	
	@PostMapping("/customeradd")
	public ModelAndView saveCustomer(@ModelAttribute Customer customer,@RequestParam(name = "branchID")int bId,
			@RequestParam(name = "facilityID", required = false) List<Integer> facilityIds) {
//		
		Branch branch=branchServices.getBranch(bId);
		customer.setBranch(branch);
		if (facilityIds != null) {
	        List<Facility> selectedFacilities = new ArrayList<>();
	        for (Integer fId : facilityIds) {
	            Facility facility = facilityServices.getFacility(fId);
	            selectedFacilities.add(facility);
	            customer.getFacilities().add(facility);
	        }
	        
	        customerServices.saveCustomer(customer); 
	        for (Facility facility : selectedFacilities) {
	            facilityServices.updateFacility(facility);
	        }
	    } else {
	        customerServices.saveCustomer(customer); 
	    }
		ModelAndView modelAndView=new ModelAndView("redirect:home.jsp");
		modelAndView.addObject("customer",customer);
		modelAndView.addObject("locations", branchServices.updateBranch(branch));
		return modelAndView;	
	}
	
}
