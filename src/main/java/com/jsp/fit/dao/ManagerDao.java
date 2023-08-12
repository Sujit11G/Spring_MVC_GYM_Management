package com.jsp.fit.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.fit.dto.Manager;

@Component
public class ManagerDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	//==============================toSave_Manager=================================
	
	public Manager saveManager(Manager manager) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		if(manager!=null) {
			entityTransaction.begin();
			entityManager.persist(manager);
			entityTransaction.commit();
		}
		return manager;
	}
	
	//==============================toGet_Manager_ID===============================
	
	public Manager getManager(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager.find(Manager.class, id);
	}
	
	//==============================toUpdate_Manager===============================
			public Manager updateManager(Manager manager) {
				EntityManager entityManager=entityManagerFactory.createEntityManager();
				
				EntityTransaction entityTransaction=entityManager.getTransaction();
				
				if(manager!=null) {
					entityTransaction.begin();
					entityManager.merge(manager);
					entityTransaction.commit();
				}
			
				return manager;
	}
			
}
