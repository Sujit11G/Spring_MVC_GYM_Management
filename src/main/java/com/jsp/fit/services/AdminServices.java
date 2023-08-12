package com.jsp.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jsp.fit.dao.AdminDao;
import com.jsp.fit.dao.BranchDao;
import com.jsp.fit.dao.ManagerDao;
import com.jsp.fit.dto.Admin;
import com.jsp.fit.dto.Branch;
import com.jsp.fit.dto.Manager;

@Service
public class AdminServices {

	@Autowired
	AdminDao adminDao;
	
	@Autowired
	BranchDao branchDao;
	
	@Autowired
	ManagerDao managerDao;
	
	//===========================toSave_Customer======================

	public Admin saveAdmin(Admin admin) {
		return adminDao.saveAdmin(admin);
	}
	
	//===========================toGet_Admin==========================
	
	public Admin getAdmin(int id) {
		return adminDao.getAdmin(id);
	}
	
	//============================toSave_Branch========================
	
	public Branch savebranch(Branch branch) {
		return branchDao.saveBranch(branch);
	}
	
	//==============================toSave_Manager======================

	public Manager saveManager(Manager manager) {
		return managerDao.saveManager(manager);
	} 
	
	//=====================toUpdate_Admin==============
	public Admin updateAdmin(Admin admin) {
		return adminDao.updateAdmin(admin);
	}
	
	
	
}
