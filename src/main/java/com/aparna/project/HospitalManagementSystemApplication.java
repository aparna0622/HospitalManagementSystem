package com.aparna.project;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.aparna.project.dao.DoctorRepository;
import com.aparna.project.dao.PatientRepository;
import com.aparna.project.model.Appointment;
import com.aparna.project.model.Doctor;
import com.aparna.project.model.Patient;

@SpringBootApplication

public class HospitalManagementSystemApplication extends SpringBootServletInitializer implements CommandLineRunner {
	@Autowired(required = true)
	DoctorRepository doctorRepository;
	
	@Autowired(required = true)
	PatientRepository patientRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementSystemApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(
      SpringApplicationBuilder application) {
      return application.sources(HospitalManagementSystemApplication.class);
    }
	
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		
		
		Doctor raja = new Doctor("Raja","Heart");
		Doctor ravi = new Doctor("Ravi","Brain");
		
		Patient man1 = new Patient("oneFirst","oneLast",30,"man1@gmail.com");
		
		Patient man2 = new Patient("twoFirst","twoLast",35,"man2@gmail.com");
		
		System.out.println("Patient 1 id  man 1" + man1.getPatientId() );
		System.out.println("Patient 2 id  man 2" + man2.getPatientId() );
		
		System.out.println("You have " + raja.getAppointments().size() + "appointments today.");
		System.out.println("DOCTOR ID " + raja.getDoctorId());
		
		System.out.println("DOCTOR Name " + raja.getDoctorName());
		System.out.println("Doctor Appointments List" + raja.getAppointments());

		
		Appointment appt1 = new Appointment();
		appt1.setDoctor(raja);
		appt1.setPatient(man1);
		appt1.setAppointmentDate(new Date());
		
		raja.getAppointments().add(appt1);
		
		Patient pt = patientRepository.save(man1);
		
		doctorRepository.save(raja);
		appt1.setDoctor(raja);
		
		Appointment appt2 = new Appointment();
		appt2.setDoctor(ravi);
		appt2.setPatient(man2);
		appt2.setAppointmentDate(new Date());

		
		ravi.getAppointments().add(appt2);
		
		patientRepository.save(man2);
		doctorRepository.save(ravi);
		
		
		
       

     // test
        System.out.println("You have " + raja.getAppointments().size() + "appointments today.");

	}

	}
