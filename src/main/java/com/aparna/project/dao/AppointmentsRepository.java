package com.aparna.project.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aparna.project.model.Appointment;


@Repository
public interface AppointmentsRepository extends JpaRepository<Appointment,Integer> {


	
	
}
