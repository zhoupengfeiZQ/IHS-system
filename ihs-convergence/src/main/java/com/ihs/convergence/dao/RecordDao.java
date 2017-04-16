package com.ihs.convergence.dao;

import java.util.List;

import com.ihs.convergence.entity.Record;


public interface RecordDao {
	
	/*public Person selectPersonDetail(Person person);*/
	
	public List<Record> selectRecord(Record record);
	
	public boolean insertRecord(Record record);
	
	/*public boolean updatePerson(Person person);*/
}
