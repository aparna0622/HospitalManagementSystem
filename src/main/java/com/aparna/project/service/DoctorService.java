package com.aparna.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aparna.project.dao.DoctorRepository;
import com.aparna.project.model.Doctor;

@Service
public class DoctorService {
	
	@Autowired
	DoctorRepository docRepository;

	public List<Doctor> getAllDoctors() {
		List<Doctor> doctors = new ArrayList<>();
		docRepository.findAll().forEach(doctors :: add);
		return doctors;		
	}

	public Doctor getDoctorById(int id) {
		return docRepository.findOne(id);
	}

	public void updateDoctor(Doctor doc) {
		docRepository.save(doc);
	}

	public void addDoctor(Doctor doc) {
		docRepository.save(doc);
	}

	public void deleteDoctor(int id) {
		docRepository.delete(id);
		
		
	}
		
}
