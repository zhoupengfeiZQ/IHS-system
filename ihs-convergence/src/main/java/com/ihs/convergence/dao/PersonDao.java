package com.ihs.convergence.dao;

import java.util.List;

import com.ihs.convergence.entity.Person;


public interface PersonDao {
	
	public Person selectPersonDetail(Person person);
	
	public List<Person> selectPerson(Person person);
	
	public boolean insertPerson(Person person);
	
	public boolean deletePerson(Person person);
	
	public boolean updatePerson(Person person);
}
