package com.ihs.convergence.dao;

import java.util.List;

import com.ihs.convergence.entity.Registration;

public interface RegistrationDao {
	public List<Registration> selectRegistration(Registration registration);
	
	public Registration selectRegistrationById(long registration_id);
	
	public Registration selectRegistrationsDetail(Registration registration);
	
	public Integer selectRegistrationCount(Registration registration);
	
	public boolean insertRegistration(Registration registration);
	
	public boolean updateStatusById(long registration_id);
	
	public boolean updateRegistrationsById(long registration_id);
}
