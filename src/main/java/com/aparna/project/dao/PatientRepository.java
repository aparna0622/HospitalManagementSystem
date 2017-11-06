package com.aparna.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.aparna.project.model.Doctor;
import com.aparna.project.model.Patient;


public interface PatientRepository extends JpaRepository<Patient,Integer> {
	
	public List<Patient> findBypatientLastName(String lastname);

	public List<Patient> findByEMail(String email);
	

}
