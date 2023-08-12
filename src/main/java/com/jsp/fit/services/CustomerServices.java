package com.jsp.fit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.fit.dao.CustomerDao;
import com.jsp.fit.dto.Customer;
import com.jsp.fit.dto.Facility;

@Service
public class CustomerServices {

	@Autowired
	CustomerDao customerDao;
	
	//==============================toSave_Customer=============================
	
	public Customer saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}
	
	//===========================toGet_Customer===================================
	
	public Customer getCustomer(int id) {
		return customerDao.getCustomer(id);
	}
	
	//============================toGetALL_Customer==============================

	public List<Customer> getCustomers(){
		return customerDao.getAllCustomers();
	}
	
	//============================toUpdate_Customer===============================

	public Customer updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);	
	}
	
//	public List<Facility> getAllFacilities(){
//		List<Facility> facilities=customer.getBranch().getFacilities();
//		return 
//	}
}
