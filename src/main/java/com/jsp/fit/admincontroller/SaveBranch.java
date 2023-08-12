package com.jsp.fit.admincontroller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.jsp.fit.dto.Admin;
import com.jsp.fit.dto.Branch;
import com.jsp.fit.dto.Facility;
import com.jsp.fit.dto.Manager;
import com.jsp.fit.services.AdminServices;
import com.jsp.fit.services.BranchServices;
import com.jsp.fit.services.FacilityServices;
import com.jsp.fit.services.ManagerServices;

@Controller
public class SaveBranch {
	
	@Autowired
	AdminServices adminServices;
	
	@Autowired
	BranchServices branchServices;
	
	@Autowired
	ManagerServices managerServices;
	
	@Autowired
	FacilityServices facilityServices;

	@RequestMapping("/adminLogin")
	public ModelAndView adminPage(HttpServletRequest req) {

		Integer adminId = (Integer) req.getSession().getAttribute("adminId");
		
		Admin admin=adminServices.getAdmin(adminId);
	
		ModelAndView modelAndView=new ModelAndView("adminPage.jsp");
		modelAndView.addObject("admin", admin);
		modelAndView.addObject("branch", new Branch());
		modelAndView.addObject("manager", new Manager());
		
		return modelAndView;	
	}
	 
	
	@PostMapping("/setBranch")
	public ModelAndView persistBranch(@RequestParam(name="adminId")int adminId,@RequestParam(name="branchName")String branchName,
		@RequestParam(name="branchLocation")String branchLocation,@RequestParam(value  ="facility",required = false)List<String> selectedFacility	 ) {
		
		
		Admin admin=adminServices.getAdmin(adminId);
	    Branch branch=new Branch();
	    branch.setLocation(branchLocation);
	    branch.setName(branchName);
//	    branch.setAdmin(admin);
	    adminServices.savebranch(branch);
//	    branch.setFacilities(new ArrayList<>());
	    
	    if(selectedFacility!=null) {
	    	for(String facilityName:selectedFacility) {
	    		Facility facility=new Facility();
	    		facility.setName(facilityName);
//	    		facility.setAdmin(admin);
//	    		facility.setBranch(branch);
	    		facilityServices.saveFacility(facility);
	    	    branch.getFacilities().add(facility);
	    	}
	    }
	    
	    admin.getBranchs().add(branch);
	    adminServices.updateAdmin(admin);
	    branchServices.updateBranch(branch);
		return new ModelAndView ("adminPage.jsp");
	}
	
//	@RequestMapping("/adminLogin")
//	public ModelAndView saveManager(HttpServletRequest req) {
//		
//		Integer adminId = (Integer) req.getSession().getAttribute("adminId");
//		if (adminId == null) {
//			return new ModelAndView("redirect:adminLogin.jsp");
//		}
//		Admin admin=adminServices.getAdmin(adminId);
//
//		if (admin == null) {
//			return new ModelAndView("redirect:adminLogin.jsp");
//		}
//		
//		ModelAndView modelAndView=new ModelAndView("adminPage.jsp");
//		modelAndView.addObject("admin", admin);
//		//modelAndView.addObject("branches", admin.getBranchs());
//		modelAndView.addObject("manager", new Manager());
//		return modelAndView;
//	}
	
	
	
	@GetMapping("/viewAllBranch")
	public ModelAndView viewAllBranch() {
		ModelAndView modelAndView=new ModelAndView("adminPage.jsp");

//		modelAndView.addObject("facilities", facilityServices.getFacilities());
		modelAndView.addObject("branches", branchServices.getAllBranches());

		return modelAndView;
	}
	
	
	
	
}
