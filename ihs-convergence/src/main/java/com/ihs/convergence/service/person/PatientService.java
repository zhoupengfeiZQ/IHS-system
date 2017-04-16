package com.ihs.convergence.service.person;

import com.ihs.convergence.entity.Patient;


public interface PatientService {
	
	public Patient selectPatientsDetail(Patient patient);
	
	public boolean insertPatients(Patient patient);
	
	
	public boolean updatePatients(Patient patient);
}
