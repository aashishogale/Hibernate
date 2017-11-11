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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;





@Entity
@Table(name="doctorm2m")

public class Doctor implements Serializable {

		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		@Column(name="name")
		private String name;
		@Column(name="speciality")
		private String speciality;

		
		@ManyToMany
		
			
		private Collection<Patient> patient=new ArrayList<Patient>();
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
		public String getSpeciality() {
			return speciality;
		}
		public void setSpeciality(String speciality) {
			this.speciality = speciality;
		}
	
		public Collection<Patient> getPatient() {
			return patient;
		}
		public void setPatient(Collection<Patient> patient) {
			this.patient = patient;
		}
		

	

}
