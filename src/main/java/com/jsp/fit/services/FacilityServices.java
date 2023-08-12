package com.jsp.fit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.fit.dao.FacilityDao;
import com.jsp.fit.dto.Facility;

@Service
public class FacilityServices {

	@Autowired
	FacilityDao facilityDao;
	
	//==========================toSave_Facility===================================

	public Facility saveFacility(Facility facility) {
		return facilityDao.saveFacility(facility);
	}
	
	//===============================toGet_All_Facility==============================

	public List<Facility> getFacilities(){
		return facilityDao.getAllFacilities();
	}
	
	//===============================toGet_Facility_By_ID=============================

	public Facility getFacility(int id) {
		return facilityDao.getFacility(id);
	}
	
	//================================toUpdate_Facility===============================

	public Facility updateFacility(Facility facility) {
		return facilityDao.updateFacility(facility);
	}
	
	
}
