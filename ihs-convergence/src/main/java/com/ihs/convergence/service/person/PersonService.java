package com.ihs.convergence.service.person;

import java.util.Map;

import com.ihs.convergence.entity.Person;
import com.ihs.convergence.utils.page.Page;

public interface PersonService {
	
	public Map<String, Object> selectPersonsByPage(Person person,Page page);
	
	public Person  selectPersonsDetail(Person person);
	
	public boolean insertPersons(Person person);
	
	public boolean deletePersons(Person person);
	
	public boolean updatePersons(Person person);
}
