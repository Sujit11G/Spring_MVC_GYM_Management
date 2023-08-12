package com.jsp.fit.managercontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.jsp.fit.dto.Manager;
import com.jsp.fit.services.ManagerServices;

@Controller
public class ManagerController {
	
	@Autowired
	ManagerServices managerServices;
	
	

	@GetMapping("/managerLogin")
	public ModelAndView managerLogin() {
		ModelAndView modelAndView=new ModelAndView("managerLogin.jsp");
		modelAndView.addObject("mLogin", new Manager());
		return modelAndView;
	}
	
	@PostMapping("/loginManager")
	public ModelAndView loginForm(@ModelAttribute("mLogin") Manager mLogin,HttpServletRequest req, HttpServletResponse resp){
		int id = mLogin.getId();
        String password = mLogin.getPassword();
		Manager manager=managerServices.getManager(id);
		if(manager!=null&&manager.getPassword().equals(password)) {
			HttpSession session=req.getSession();
			session.setAttribute("managerId", manager.getId());
			return new ModelAndView("managerPage.jsp");
		}else {
			 ModelAndView modelAndView = new ModelAndView("managerLogin.jsp");
	            modelAndView.addObject("authMessage", "Invalid ID or Password");
			return  modelAndView;
		}
		
	}

}
