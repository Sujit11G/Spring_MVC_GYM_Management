package com.jsp.fit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jsp.fit.dto.Customer;

@Component
public class CustomerDao {


	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	//===============================toSave_Customer====================================

	public Customer saveCustomer(Customer customer) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		if(customer!=null) {
			entityTransaction.begin();
			entityManager.persist(customer);
			entityTransaction.commit();
			
			return customer;
		}else {
			return null;
		}
	}
	
	//=============================toGet_Customer_ID=============================
	
	public Customer getCustomer( int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager.find(Customer.class, id);
	}
	
	//=============================toGet_All_Customer=============================
	
	public List<Customer> getAllCustomers(){
		EntityManager entityManager=entityManagerFactory.createEntityManager();

		String jpql="SELECT c FROM Customer c";
		Query query=entityManager.createQuery(jpql);
		return query.getResultList();
	}
	
	//==============================toUpadate_Customer=============================
	
	public Customer updateCustomer(Customer customer) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		if(customer!=null) {
			entityTransaction.begin();
			entityManager.merge(customer);
			entityTransaction.commit();
			return customer;
		}
		else {
			return null;
		}
	}
}
