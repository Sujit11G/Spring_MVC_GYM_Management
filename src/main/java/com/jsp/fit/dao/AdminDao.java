package com.jsp.fit.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jsp.fit.dto.Admin;

@Component
public class AdminDao {

		@Autowired
		EntityManagerFactory entityManagerFactory;
		
	//=================================toSave_Admin=======================================

		
		public Admin saveAdmin(Admin admin) {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			
			if(admin!=null) {
				entityTransaction.begin();
				entityManager.persist(admin);
				entityTransaction.commit();
				return admin;
			}else {
				return admin;
			}
			
		}
		
	//====================================toGet_Admin_ID============================================
		
		public Admin getAdmin(int id) {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			return entityManager.find(Admin.class, id);
		}
		
	//====================================toUpdate_Admin============================================
		
		public Admin updateAdmin(Admin admin,int id) {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			
			EntityTransaction entityTransaction=entityManager.getTransaction();
			
			if(admin!=null) {
				entityTransaction.begin();
				entityManager.merge(admin);
				entityTransaction.commit();
			}
		
			return admin;
		}
		//=================================toUpdate_Admin========================================
		
				public Admin updateAdmin(Admin admin) {
					EntityManager entityManager=entityManagerFactory.createEntityManager();
					EntityTransaction entityTransaction=entityManager.getTransaction();
					
					if(admin!=null) {
						entityTransaction.begin();
						entityManager.merge(admin);
						entityTransaction.commit();
					}
				
					return admin;
				}	
		
}
