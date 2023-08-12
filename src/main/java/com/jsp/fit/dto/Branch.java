package com.jsp.fit.dto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String location;
	
//	@ManyToOne
//	private Admin admin;
	
	@OneToOne
	private Manager manager;
	
	@OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
	private List<Customer> customers;
	
	@OneToMany(cascade =CascadeType.ALL)
	private List<Facility> facilities;
	
	@OneToMany(mappedBy = "branch",cascade = CascadeType.ALL)
	private List<Trainer> trainers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Facility> getFacilities() {
		if (facilities == null) {
            facilities = new ArrayList<>();
        }
		return facilities;
	}

	public void setFacilities(List<Facility> facilities) {
		this.facilities = facilities;
	}

	public List<Trainer> getTrainers() {
		return trainers;
	}

	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}
	
	
}
