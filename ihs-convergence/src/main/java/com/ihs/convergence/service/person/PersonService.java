package com.ihs.convergence.service.person;

import java.util.Map;

import com.ihs.convergence.entity.Person;
import com.ihs.convergence.utils.page.Page;

public interface PersonService {
	
	public Map<String, Object> selectPersonsByPage(Person drug,Page page);
	
	public boolean insertPersons(Person drug);
	
	public boolean deletePersons(Person drug);
	
	public boolean updatePersons(Person drug);
}
