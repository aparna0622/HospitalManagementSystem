package com.aparna.project.dao;

import java.util.Date;
import java.util.List;

import com.aparna.project.model.Appointment;


public interface AppointmentsRepositoryCustom {

	List<Appointment> getUpcomingAppointmentsByDoctorId(int doctorId);
	
	List<Appointment> getPatientAppointmentHistory(int patientId);
}
