package com.jsp.fit.admincontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.jsp.fit.dto.Admin;
import com.jsp.fit.services.AdminServices;

@Controller
public class AdminLogin {

	@Autowired
	AdminServices adminServices;
	
	@GetMapping("/loginadmin")
	public ModelAndView loginForm() {
		ModelAndView modelAndView=new ModelAndView("adminLogin.jsp");
		return modelAndView.addObject("login", new Admin());
	}
	
	@PostMapping("/adminLogin")
	public ModelAndView adminLogin(@ModelAttribute("login") Admin login,HttpServletRequest req) {
		int id=login.getId();
		String password=login.getPassword();
		Admin admin=adminServices.getAdmin(id);
		if(admin!=null&&admin.getPassword().equals(password)) {

			HttpSession session=req.getSession();
			session.setAttribute("adminId", admin.getId());
			
			return new ModelAndView("adminPage.jsp");
		}else {
			ModelAndView modelAndView=new ModelAndView("adminLogin.jsp");
			return 	modelAndView.addObject("authMessage", "Invalid ID or Password");

		}
	}
	
	
}
