package com.jsp.fit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.fit.dao.TrainerDao;
import com.jsp.fit.dto.Trainer;

@Service
public class TrainerServices {

	@Autowired
	TrainerDao trainerDao;
	
	//==================================toSave_Trainer===========================

	public Trainer saveTrainer(Trainer trainer) {
		return trainerDao.saveTrainer(trainer);
	}
	
	//=============================toGet_All_Trainers===========================

	public List<Trainer> getTrainers(){
		return trainerDao.getTrainers();
	}
	
	//==========================toGet_Trainer_By_ID============================

	public Trainer getTrainer(int id) {
		return trainerDao.getTrainer(id); 
	}
	
	
}
