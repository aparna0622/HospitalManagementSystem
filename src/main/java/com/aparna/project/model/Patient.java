package com.aparna.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "patient_id", nullable = false, unique = true)
	int patientId;
	String patientFirstName;
	String patientLastName;
	int age;
	String eMail;
	@OneToMany(mappedBy = "patient" ,cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	Set<Appointment> appointments;
	
	public Patient()
	{
		
	}


	
	
	public Patient(String patientFirstName, String patientLastName, int age, String eMail) {
		
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.age = age;
		this.eMail = eMail;
	}




	
	@Column(name = "patient_id")
	public int getPatientId() {
		return patientId;
	}
	
	
	
	
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	
	
	@Column(name = "patient_first_name")
	public String getPatientFirstName() {
		return patientFirstName;
	}
	
	
	
	
	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}
	
	
	
	@Column(name = "patient_last_name")
	public String getPatientLastName() {
		return patientLastName;
	}
	
	
	
	
	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}
	
	
	
	@Column(name = "age")
	public int getAge() {
		return age;
	}
	
	
	
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	@Column(name = "email")
	public String geteMail() {
		return eMail;
	}
	
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	
	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}
		
}
