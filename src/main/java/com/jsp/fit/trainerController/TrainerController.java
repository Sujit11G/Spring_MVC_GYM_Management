package com.jsp.fit.trainerController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.jsp.fit.dto.Branch;
import com.jsp.fit.dto.Trainer;
import com.jsp.fit.services.BranchServices;
import com.jsp.fit.services.TrainerServices;

@Controller
public class TrainerController {
	
	@Autowired
	TrainerServices trainerServices;
	
	@Autowired
	BranchServices branchServices;

	
	@RequestMapping("/trainerload")
	public ModelAndView customerLoad() {
	
		ModelAndView modelAndView=new ModelAndView("saveTrainer.jsp");
		modelAndView.addObject("trainer", new Trainer());
		modelAndView.addObject("branches", branchServices.getAllBranches());

		return modelAndView;
	}
	
	@PostMapping("/trainerSave")
	public ModelAndView saveTrainer(@ModelAttribute Trainer trainer,@RequestParam(name = "branchID")int bId){
		Branch branch=branchServices.getBranch(bId);
		trainer.setBranch(branch);
		branchServices.updateBranch(branch);
		trainerServices.saveTrainer(trainer);
	ModelAndView modelAndView= new ModelAndView("redirect:home.jsp");
	modelAndView.addObject("trainer", trainer);
	modelAndView.addObject("locations", branchServices.updateBranch(branch));

	return modelAndView;
	}
	
	@GetMapping("/loginTrainer")
	public ModelAndView loginForm() {
		ModelAndView modelAndView=new ModelAndView("trainerLogin.jsp");
		Trainer trainer=new Trainer();
		modelAndView.addObject("tLogin", trainer);
		return modelAndView;
	}
	
	@PostMapping("/trainerLogin")
	public ModelAndView loginAdmin(@ModelAttribute("tLogin") Trainer login,HttpServletRequest req) {
		int id =login.getId();
		String password=login.getPassword();
		Trainer trainer=trainerServices.getTrainer(id);
		if(trainer!=null&&trainer.getPassword().equals(password)) {

			HttpSession session=req.getSession();
			session.setAttribute("trainerId", trainer.getId());
			
			return new ModelAndView("trainerPage.jsp");
		}else {
			ModelAndView modelAndView=new ModelAndView("trainerLogin.jsp");
			return 	modelAndView.addObject("authMessage", "Invalid ID or Password");

		}
	}
	
	
	
}
