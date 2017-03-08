package com.ihs.convergence.dao;

import java.util.List;

import com.ihs.convergence.entity.Person;


public interface PersonDao {
	
	public Person selectPersonById(Person person);
	
	public List<Person> selectPerson(Person drug);
	
	public boolean insertPerson(Person drug);
	
	public boolean deletePerson(Person drug);
	
	public boolean updatePerson(Person drug);
}
