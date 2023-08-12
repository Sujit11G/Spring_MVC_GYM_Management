package com.jsp.fit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.fit.dto.Trainer;

@Component
public class TrainerDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	//==================================toSave_Trainer===========================
	public Trainer saveTrainer(Trainer trainer) {
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	if(trainer!=null) {
		entityTransaction.begin();
		entityManager.persist(trainer);
		entityTransaction.commit();
		return trainer;
	}else {
		return null;
	}
	}
	
	//==========================toGet_Trainer_By_ID============================
	public Trainer getTrainer(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();

		return entityManager.find(Trainer.class, id);
	}
	
	//=============================toGet_All_Trainers===========================
	
	public List<Trainer> getTrainers(){
		EntityManager entityManager=entityManagerFactory.createEntityManager();

		String jpql="SELECT t FROM Trainer t";
		Query query=entityManager.createQuery(jpql);
		return query.getResultList();
		
	}
	
	
}
