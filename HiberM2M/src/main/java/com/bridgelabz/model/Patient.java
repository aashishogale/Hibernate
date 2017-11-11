package com.bridgelabz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="patientm2m")
public class Patient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3007491928654116458L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patientid")
	private int id;
	
	@Column(name="name")
	private String name;
	@Column(name="address")
	
	private String address;
	
	
	@ManyToMany(mappedBy="patient")

	
	private Collection<Doctor> doctor =new ArrayList<Doctor>();
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Collection<Doctor> getDoctor() {
		return doctor;
	}
	
	public void setDoctor(Collection<Doctor> doctor) {
		this.doctor = doctor;
	}

}