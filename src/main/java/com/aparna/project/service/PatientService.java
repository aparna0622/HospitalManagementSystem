package com.aparna.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aparna.project.dao.PatientRepository;
import com.aparna.project.model.Patient;



@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepository;

	public List<Patient> getAllPatients() {
		List<Patient> patients = new ArrayList<>();
		patientRepository.findAll().forEach(patients :: add);
		return patients;		
	}

	public Patient getPatientById(int id) {
		return patientRepository.findOne(id);
	}

	public void updatePatient(Patient patient) {
		patientRepository.save(patient);
	}

	public void addPatient(Patient patient) {
		patientRepository.save(patient);
	}

	public void deletePatient(int id) {
		patientRepository.delete(id);
	}	

}
