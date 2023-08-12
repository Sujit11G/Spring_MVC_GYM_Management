package com.jsp.fit.admincontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.fit.dto.Admin;
import com.jsp.fit.dto.Manager;
import com.jsp.fit.services.AdminServices;
import com.jsp.fit.services.BranchServices;

@Controller
public class SaveManager {

	@Autowired
	AdminServices adminServices;
	
	@Autowired
	BranchServices branchServices;
	
	@PostMapping("/saveManager")
	public ModelAndView setManagertoBranch(@ModelAttribute Manager manager,HttpServletRequest req) {
		Integer id=(Integer) req.getSession().getAttribute("adminId");
		
//		String branch1=req.getParameter("branchName");
		
		Admin admin=adminServices.getAdmin(id);
		//Branch branch=branchServices.getBranch(manager.getBranch().getId());
		
		String Name=req.getParameter("managerName");
		String Email=req.getParameter("managerEmail");
		String Password=req.getParameter("managerPassword");
		//Branch branch=req.getParameter("branchName");
		//Manager m=new Manager();
		manager.setName(Name);
		manager.setEmail(Email);
		manager.setPassword(Password);
	
		admin.getManagers().add(manager);
		
		adminServices.saveManager(manager);
		adminServices.updateAdmin(admin);
		
		
		return new ModelAndView ("adminPage.jsp");
	}
}
