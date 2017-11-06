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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	//@Column(name = "doctor_id", nullable = false, unique = true)
	int doctorId;
	String doctorName;
	String speciality;
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	Set<Appointment> appointments;
	
	public Doctor()
	{
		
	}
	
	public Doctor(String doctorName, String speciality) {
		this.doctorName = doctorName;
		this.speciality = speciality;
		appointments = new HashSet<>();
	}
	
	
	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	
	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	
	

}
