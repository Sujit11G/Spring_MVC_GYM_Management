package com.jsp.fit.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jsp.fit.dto.Branch;
import com.jsp.fit.dto.Customer;

@Component
public class BranchDao {
	

	@Autowired
	EntityManagerFactory entityManagerFactory;

	//===============================toSave_Branch=================================
	
	public Branch saveBranch(Branch branch) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		if(branch!=null) {
			entityTransaction.begin();
			entityManager.persist(branch);
			entityTransaction.commit();
		}
		return branch;
	}
	
	//===============================toGet_Branch_ByID================================
	
	public Branch getBranch(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();

		return entityManager.find(Branch.class, id);
	}
	
	//===================================toUpadate_Branch================================
	
	public Branch updateBranch(Branch branch) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		//Branch b=entityManager.find(Branch.class, id);
		if(branch!=null) {
			entityTransaction.begin();
			entityManager.merge(branch);
			entityTransaction.commit();
		}
		return branch;
		
	}
	//==================================toGet_All_Branch================================
			public List<Branch> getAllBranches(){
				
				EntityManager entityManager=entityManagerFactory.createEntityManager();
				
				String sql="SELECT b FROM Branch b";
				Query query=entityManager.createQuery(sql);
				return query.getResultList();
				
			}
	//===============================toGet_All-Location===========================
//			public List<String> getAllLoaction(){
//				
//				EntityManager entityManager = entityManagerFactory.createEntityManager();
//			    
//			    String sql = "SELECT b.location FROM Branch b";
//			    Query query = entityManager.createQuery(sql);
//			    List<String> locations = query.getResultList();
//			    
//			    return locations;
//			}
	
	//===================================toGet_All_Customer=================================
			
			public List<Customer> getAllCustomers(int branchId){
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				
				String jpql="SELECT c FROM Customer c WHERE c.branch.id = :branchId";
				Query query=entityManager.createQuery(jpql);
				

				return query.getResultList();
						
			}

}
