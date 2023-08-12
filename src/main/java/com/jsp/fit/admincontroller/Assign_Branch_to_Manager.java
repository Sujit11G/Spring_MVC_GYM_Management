package com.jsp.fit.admincontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.jsp.fit.dto.Admin;
import com.jsp.fit.dto.Branch;
import com.jsp.fit.dto.Manager;
import com.jsp.fit.services.AdminServices;
import com.jsp.fit.services.BranchServices;
import com.jsp.fit.services.ManagerServices;

@Controller
public class Assign_Branch_to_Manager {

	@Autowired
	AdminServices adminServices;
	
	@Autowired
	ManagerServices managerServices;
	
	@Autowired
	BranchServices branchServices;
	
	 @PostMapping("/assignBranchToManager")
	    public ModelAndView assignBranchToManager(HttpServletRequest req) {
			Integer adminId = (Integer) req.getSession().getAttribute("adminId");

			String branchId=req.getParameter("branchId");
			int bID=Integer.parseInt(branchId);
			
			String managerId=req.getParameter("managerId");
			int mID=Integer.parseInt(managerId);
			
			Admin admin=adminServices.getAdmin(adminId);
			Manager manager=managerServices.getManager(mID);
			Branch branch=branchServices.getBranch(bID);
			if (admin!=null ) {
	                manager.setBranch(branch);
	                branch.setManager(manager);
	                admin.getBranchs().add(branch);
	                admin.getManagers().add(manager);
//	                branch.setAdmin(admin);
	                managerServices.updateManager(manager);
	                branchServices.updateBranch(branch);
	        }
			
			List<Branch> branches=branchServices.getAllBranches();
			ModelAndView modelAndView=new ModelAndView("adminPage.jsp");

			modelAndView.addObject("branches", branches);
	        return modelAndView; 
	    }
		
	}

