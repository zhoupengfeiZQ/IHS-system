package com.ihs.convergence.service.registration;

import java.util.Map;

import com.ihs.convergence.entity.Registration;
import com.ihs.convergence.utils.page.Page;

public interface RegistrationService {
	public Map<String, Object> selectRegistrationsByPage(Registration registration,Page page);
	
	public Registration selectRegistrationById(long registration_id);
	
	public Registration selectRegistrationsDetail(Registration registration);
	
	public boolean addRegistrations(Registration registration);
	
	public boolean cancelRegistration(long registration_id);
}
