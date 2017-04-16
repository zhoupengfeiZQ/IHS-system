package com.ihs.convergence.dao;


import com.ihs.convergence.entity.Patient;


public interface PatientDao {
	
	public Patient selectPatientDetail(Patient patient);
	
	public boolean insertPatient(Patient patient);
	
	public boolean updatePatient(Patient patient);
}
