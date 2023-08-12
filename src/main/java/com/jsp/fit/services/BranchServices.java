package com.jsp.fit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.fit.dao.BranchDao;
import com.jsp.fit.dao.CustomerDao;
import com.jsp.fit.dto.Branch;
import com.jsp.fit.dto.Facility;

@Service
public class BranchServices {
	
	@Autowired
	BranchDao branchDao;
	
	@Autowired
	CustomerDao customerDao;

	//============================toGet_Branch_ID==================================
	public Branch getBranch(int id) {
		return branchDao.getBranch(id);
	}
	
	//==============================toUpdate_Branch===============================
			public Branch updateBranch(Branch branch) {
				
				return branchDao.updateBranch(branch);
			}
			
	//================================toGet_All_Branches============================
			public List<Branch>  getAllBranches(){
				
				return branchDao.getAllBranches();
			}
			
	//============================toGet_All_Location=================================		
//		public List<String> getAllLoaction(){
//			return branchDao.getAllLoaction();
//		}	
			
//			public List<Facility> getFacility(int bId){
//				Branch branch=branchDao.getBranch(bId);
//				List<Facility> facilities=
//				for(Facility f: )
//			}
	}	



