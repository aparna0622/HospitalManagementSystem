package com.aparna.project.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
@IdClass(value = DoctorPatient.class)

public class Appointment implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	Doctor doctor;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "patient_id")
	Patient patient;
	
	@Id
	private Date appointmentDate;
	private String visitNotes;
	private String status;
	
	public Appointment()
	{
		
	}
		
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Column(name = "appointment_date")
	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date date) {
		this.appointmentDate = date;
	}

	@Column(name = "visit_notes")
	public String getVisitNotes() {
		return visitNotes;
	}

	public void setVisitNotes(String visitNotes) {
		this.visitNotes = visitNotes;
	}
	
	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
