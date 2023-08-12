package com.jsp.fit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.fit.dto.Facility;

@Component
public class FacilityDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	//==========================toSave_Facility===================================
	
	public Facility saveFacility(Facility facility) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		if(facility!=null) {
			entityTransaction.begin();
			entityManager.persist(facility);
			entityTransaction.commit();
			return facility;
		}else {
			return null;
		}
	}
	
	//===============================toGet_All_Facility==============================
	
	public List<Facility> getAllFacilities(){
		EntityManager entityManager=entityManagerFactory.createEntityManager();

		String jpql="SELECT f FROM Facility f";
		Query query=entityManager.createQuery(jpql);
		return query.getResultList();
				
	}
	
	//===============================toGet_Facility_By_ID=============================
	
	public Facility getFacility(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();

		return entityManager.find(Facility.class, id);
	}
	
	//================================toUpdate_Facility===============================
	
	public Facility updateFacility(Facility facility) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		if(facility!=null) {
			entityTransaction.begin();
			entityManager.merge(facility);
			entityTransaction.commit();
			
			return facility;
		}else {
			return null;
		}
	}
	
	
}
