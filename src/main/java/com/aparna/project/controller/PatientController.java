package com.aparna.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aparna.project.model.Doctor;
import com.aparna.project.model.Patient;
import com.aparna.project.service.PatientService;


@Controller
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@RequestMapping("/patientform")
	public ModelAndView showForm()
	{
		return new ModelAndView("patientform","command",new Patient());
	}
	
	//Provides a list of Patients in the Model Object
		@RequestMapping(method = RequestMethod.GET, value = "/viewallpatient")
		public ModelAndView getAllPatients()
		{
			List<Patient> list =  patientService.getAllPatients();
			return new ModelAndView("viewallpatient","list",list);
		}
		
//	@RequestMapping(method = RequestMethod.GET, value = "/patients")
//	public List<Patient> getAllPatients()
//	{
//		return patientService.getAllPatients();
//	}
	
		//Display data for one patient in the form
		@RequestMapping(method = RequestMethod.GET, value = "/editpatient/{id}")
		public ModelAndView getPatient(@PathVariable int id)
		{
			Patient patient = patientService.getPatientById(id);
			return new ModelAndView("patienteditform","command",patient);
		}
		
//	@RequestMapping(method = RequestMethod.GET, value = "/patients/{id}")
//	public Patient getPatient(@PathVariable Integer id)
//	{
//		return patientService.getPatientById(id);		
//	}
		
		@RequestMapping(method = RequestMethod.POST, value = "/editsavepatient")
		public ModelAndView updatePatient(@ModelAttribute("patient") Patient patient)
		{
			patientService.updatePatient(patient);
			return new ModelAndView("redirect:/viewallpatient");
		}
	
//	@RequestMapping(method = RequestMethod.PUT, value = "/patients/{id}")
//	public void updatePatient(@RequestBody Patient doc, @PathVariable Integer id)
//	{
//		patientService.updatePatient(id, doc);
//	}
//	
		
		@RequestMapping(method = RequestMethod.POST, value = "/savepatient")
		public ModelAndView addPatient(@ModelAttribute("patient") Patient patient)
		{
			patientService.addPatient(patient);
			return new ModelAndView("redirect:/viewallpatient");
		}
//	@RequestMapping(method = RequestMethod.POST, value = "/patients")
//	public void addPatient(@RequestBody Patient doc)
//	{
//	}
	
		@RequestMapping (method = RequestMethod.GET, value = "/deletepatient/{id}")
		public ModelAndView deletePatient(@PathVariable int id)
		{
			patientService.deletePatient(id);
			return new ModelAndView("redirect:/viewallpatient");
		}

//	@RequestMapping (method = RequestMethod.DELETE, value = "/patients/{id}")
//	public void deletePatient(@PathVariable Integer id)
//	{
//		patientService.deletePatient(id);
//	}

}
