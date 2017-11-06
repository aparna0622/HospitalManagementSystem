package com.aparna.project.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class DoctorPatient implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	Doctor doctor;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "patient_id")
	Patient patient;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoctorPatient other = (DoctorPatient) obj;
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		return true;
	}
	
	
}
