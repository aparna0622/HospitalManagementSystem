CREATE DATABASE  IF NOT EXISTS `HospitalManagement` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `HospitalManagement`;

DROP TABLE IF EXISTS `Doctor`;

CREATE TABLE `Doctor` (
  `doctor_id` int(3) unsigned NOT NULL,
  `doctor_name` varchar(255) DEFAULT NULL,
  `speciality` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`doctor_id`)
);


DROP TABLE IF EXISTS `Patient`;

CREATE TABLE `Patient` (
  `patient_id` int(3) unsigned NOT NULL,
  `patient_first_name` varchar(255) DEFAULT NULL,
  `patient_last_name` varchar(255) DEFAULT NULL,
  `age` int(3) unsigned NULL,
  `email` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`patient_id`)
);

DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment` (
	
  `doctor_id` int(3) unsigned NOT NULL,
  `patient_id` int(3) unsigned NOT NULL,
  `appointment_date` datetime DEFAULT NULL,
  `visit_notes` datetime DEFAULT NULL,
  `status`  datetime DEFAULT NULL,
  PRIMARY KEY (`doctor_id`,`patient_id`,`appointment_date`),
  CONSTRAINT `fk_appointments_doctor` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`),
  CONSTRAINT `fk_appointments_patient` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) 
)

select * from Doctor;

select * from Patient;

select * from appointment;



--Patient Appt Schedule

SELECT D.Doctor_Name  AS Name, D.Speciality, A.appointment_date AS Schedule, A.Status, A.visit_notes AS Notes
FROM Appointment AS A
INNER JOIN Doctor AS D ON
	A.Doctor_ID = D.Doctor_ID
INNER JOIN Patient AS P ON
	A.Patient_ID = P.Patient_ID
    AND A.Patient_ID = 2;

--Doctor Appt Schedule
SELECT P.Patient_First_Name, P.Patient_Last_Name, P.Age, P.E_Mail AS Email, A.appointment_date AS Schedule, A.Status, A.visit_notes AS Notes
FROM Appointment AS A
INNER JOIN Patient AS P ON
	A.Patient_ID = P.Patient_ID
INNER JOIN Doctor AS D ON
	A.Doctor_ID = D.Doctor_ID
    AND D.Doctor_ID = 2;
    


insert into doctor (doctor_name, speciality)values('Harini','Heart');
insert into doctor (doctor_name, speciality)values('Harshini','Brain');

select * from patient;


insert into patient(age,email,patient_first_name,patient_last_name) values(30, 'aparna@gmail.com','Aparna','Narayanan');
insert into patient(age,email,patient_first_name,patient_last_name) values(30, 'blaha@gmail.com','bla','Blah');
select * from appointment;


SELECT a.doctorId, a.patientId, a.appointment_date, a.visit_notes from Appointment a WHERE a.appointment_date >= CURDATE() and a.doctor_id = 1;

