package com.aparna.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.aparna.project.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

	public List<Doctor> findBySpeciality(String speciality);

	public List<Doctor> findByDoctorName(String docName);



}
