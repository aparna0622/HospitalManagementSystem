package com.aparna.project.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aparna.project.dao.AppointmentsRepository;
import com.aparna.project.dao.AppointmentsRepositoryImpl;
import com.aparna.project.dao.DoctorRepository;
import com.aparna.project.dao.PatientRepository;
import com.aparna.project.model.Appointment;
import com.aparna.project.model.Doctor;
import com.aparna.project.model.Patient;

import com.aparna.project.service.DoctorService;
import com.aparna.project.service.PatientService;

@Controller
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	PatientRepository patientrepository;
	
	@Autowired
	AppointmentsRepositoryImpl appointmentsRepositoryImpl;
	
	
	@RequestMapping("/docform")
	public ModelAndView showForm()
	{
		return new ModelAndView("docform","command",new Doctor());
	}
	//Provides a list of Doctors in the Model Object
	@RequestMapping(method = RequestMethod.GET, value = "/viewalldoc")
	public ModelAndView getAllDoctors()
	{
		List<Doctor> list =  doctorService.getAllDoctors();
		return new ModelAndView("viewalldoc","list",list);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/addappointment")
	public ModelAndView addAppointment()
	{
		return new ModelAndView("addappointment","command", new Appointment());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/viewpatientappointment/{patientId}")
	public ModelAndView getPatientAppointmentHistory(@PathVariable int patientId)
	{
		List<Appointment> list =  appointmentsRepositoryImpl.getPatientAppointmentHistory(patientId);
		
		return new ModelAndView("viewpatientappointment","list",list);
	}
		
		@RequestMapping(method = RequestMethod.GET, value = "/viewdoctorappointment/{docId}")
		public ModelAndView getUpcomingAppointmentsByDoctorId(@PathVariable int docId)
		{
			List<Appointment> list =  appointmentsRepositoryImpl.getUpcomingAppointmentsByDoctorId(docId);
			
			return new ModelAndView("viewdoctorappointment","list",list);
		}
		
	//Display data for one doctor in the form
	@RequestMapping(method = RequestMethod.GET, value = "/editdoctor/{id}")
	public ModelAndView getDoctor(@PathVariable int id)
	{
		Doctor doc = doctorService.getDoctorById(id);
		return new ModelAndView("doceditform","command",doc);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/editsavedoctor")
	public ModelAndView updatedoctor(@ModelAttribute("doc") Doctor doc)
	{
		doctorService.updateDoctor(doc);
		return new ModelAndView("redirect:/viewalldoc");
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/savedoc")
	public ModelAndView addDoctor(@ModelAttribute("doc") Doctor doc)
	{
		doctorService.addDoctor(doc);
		return new ModelAndView("redirect:/viewalldoc");
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/saveappointment")
	public ModelAndView saveAppointment(@RequestParam("doctorId") String doctorId, @RequestParam("patientId") int patientId, @RequestParam("apptDate") Date apptDate, @RequestParam("visitNotes") String visitNotes )
	{
		ModelAndView model = new ModelAndView("appointmentcreated");
		model.addObject("doctorId");
		model.addObject("patientId");
		
		System.out.println("doctorId : "+ doctorId);
		System.out.println("patientId  : "+ patientId);
		System.out.println("apptDate : "+ apptDate);
		System.out.println("visitNotes : "+ visitNotes);
		
		Doctor doc2 = doctorRepository.findOne(new Integer(1));
		System.out.println("HelloWorld");
		Doctor doc1 = doctorRepository.findOne(Integer.parseInt("doctorId"));
		Patient pt1 = patientrepository.findOne(patientId);
		System.out.println(doc1.getDoctorId());
		
		
		System.out.println(doctorService.getDoctorById(Integer.parseInt("doctorId")).getDoctorId());
		System.out.println(patientService.getPatientById(Integer.parseInt("patientId")).getPatientId());
		
		
		Appointment appt1 = new Appointment();
		appt1.setDoctor(doc1);
		appt1.setPatient(patientService.getPatientById(patientId));
		//appt1.setAppointmentDate(apptDate);
		//appt1.setVisitNotes(visitNotes);
		doctorService.getDoctorById(Integer.parseInt("doctorId")).getAppointments().add(appt1);
		
		
		doctorService.updateDoctor(doctorService.getDoctorById(Integer.parseInt("doctorId")));
		patientService.updatePatient(patientService.getPatientById(patientId));
		return model;
	}
	
	//Display data for one doctor in the form
		@RequestMapping(method = RequestMethod.POST, value = "/appointmentcreated")
		public ModelAndView getDoctor()
		{
			
			return new ModelAndView("redirect:/appointmentcreated");
		}
	
	@RequestMapping (method = RequestMethod.GET, value = "/deletedoc/{id}")
	public ModelAndView deleteDoctor(@PathVariable int id)
	{
		doctorService.deleteDoctor(id);
		return new ModelAndView("redirect:/viewalldoc");
	}

}
