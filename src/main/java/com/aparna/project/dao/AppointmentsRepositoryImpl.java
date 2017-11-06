package com.aparna.project.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.From;

import org.springframework.stereotype.Repository;

import com.aparna.project.model.Appointment;

@Repository
public class AppointmentsRepositoryImpl implements AppointmentsRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Appointment> getUpcomingAppointmentsByDoctorId(int doctorId) {
		String queryStr = "SELECT P.Patient_First_Name, P.Patient_Last_Name, P.Age, P.E_Mail AS Email, A.appointment_date AS Schedule, A.Status, A.visit_notes AS Notes\r\n" + 
				"FROM Appointment AS A\r\n" + 
				"INNER JOIN Patient AS P ON\r\n" + 
				"	A.Patient_ID = P.Patient_ID\r\n" + 
				"INNER JOIN Doctor AS D ON\r\n" + 
				"	A.Doctor_ID = D.Doctor_ID\r\n" + 
				"    AND D.Doctor_ID = ?";
		Query query = entityManager.createNativeQuery(queryStr, Appointment.class);
				
	    query.setParameter(1, doctorId);
	
	
	return query.getResultList();
	}

	@Override
	public List<Appointment> getPatientAppointmentHistory(int patientId) {
		String str2 = "SELECT D.Doctor_Name  AS Name, D.Speciality, A.appointment_date AS Schedule, A.Status, A.visit_notes AS Notes \r\n" + 
				"FROM Appointment AS A INNER JOIN Doctor AS D ON 						A.Doctor_ID = D.Doctor_ID\r\n" + 
				"INNER JOIN Patient AS P ON\r\n" + 
				"A.Patient_ID = P.Patient_ID\r\n" + 
				" AND A.Patient_ID = ?;";
		Query query = entityManager.createNativeQuery(str2,Appointment.class);
		query.setParameter(1, patientId);
		return query.getResultList();
													    		
	}

	

}
