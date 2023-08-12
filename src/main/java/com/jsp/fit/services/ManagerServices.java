package com.jsp.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.fit.dao.ManagerDao;
import com.jsp.fit.dto.Manager;

@Service
public class ManagerServices {

	@Autowired
	ManagerDao managerDao;
	
	//==============================toSave_Manager=================================

	public Manager getManager(int id) {
		return managerDao.getManager(id);
	}
	//==============================toUpdate_Manager===============================

	public Manager updateManager(Manager manager) {
		return managerDao.updateManager(manager);
	}
	

}
