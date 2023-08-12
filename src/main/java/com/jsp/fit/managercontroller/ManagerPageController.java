package com.jsp.fit.managercontroller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.jsp.fit.dto.Customer;
import com.jsp.fit.dto.Manager;
import com.jsp.fit.dto.Trainer;
import com.jsp.fit.services.CustomerServices;
import com.jsp.fit.services.ManagerServices;
import com.jsp.fit.services.TrainerServices;

@Controller
public class ManagerPageController {

	@Autowired
	ManagerServices managerServices;
	
	@Autowired
	TrainerServices trainerServices;
	
	@Autowired
	CustomerServices customerServices;
	
	@GetMapping("/branchCustomers")
	public ModelAndView managerPage(HttpServletRequest req ) {
		
		Integer managerId = (Integer) req.getSession().getAttribute("managerId");
		Manager manager=managerServices.getManager(managerId);
		List<Customer> customers=manager.getBranch().getCustomers();
		List<Trainer> trainers=manager.getBranch().getTrainers();
		ModelAndView modelAndView=new ModelAndView("managerPage.jsp");
		modelAndView.addObject("customers", customers);

		modelAndView.addObject("trainers", trainers);
		
		return modelAndView;	
	}
	
	@PostMapping("/assignTrainerToCustomer")
	public ModelAndView assignTrainertoCustomer(@RequestParam(name="managerId")int mId,
												@RequestParam(name="customerId")int cId,
												@RequestParam(name="trainerId")int tId) {
		
		Manager manager=managerServices.getManager(mId);
		Trainer trainer=trainerServices.getTrainer(tId);
		Customer customer=customerServices.getCustomer(cId);
		
		if(manager!=null) {
			customer.setTrainer(trainer);
			trainer.getCustomers().add(customer);
			customerServices.updateCustomer(customer);
			
		}
		
		List<Customer> customers=manager.getBranch().getCustomers();
		List<Trainer> trainers=manager.getBranch().getTrainers();
		ModelAndView modelAndView=new ModelAndView("managerPage.jsp");		
		modelAndView.addObject("customers", customers);
		modelAndView.addObject("trainers", trainers);

		return modelAndView;
	}
}
