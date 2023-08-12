package com.jsp.fit.admincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.jsp.fit.dto.Admin;
import com.jsp.fit.services.AdminServices;

@Controller
public class AdminController {

	@Autowired
	AdminServices adminServices;
	
	@RequestMapping("/adminLoad")
	public ModelAndView adminPage() {
		ModelAndView modelAndView=new ModelAndView("adminSignIN.jsp");
		modelAndView.addObject("admin", new Admin());
		return modelAndView;
	}
	
	@PostMapping("/adminSave")
	public ModelAndView saveAdmin(@ModelAttribute Admin admin,RedirectAttributes redirectAttributes){
		
        Admin a = adminServices.saveAdmin(admin);
		//	ModelAndView modelAndView=new ModelAndView("redirect:adminHome.jsp");
//            redirectAttributes.addFlashAttribute("adminSaved", a.getName() + " saved Successfully");
//			return modelAndView;
			return new ModelAndView("redirect:adminHome.jsp");
	}
	
	
	 
}
