package com.ihs.convergence.dao;

import java.util.List;

import com.ihs.convergence.entity.Depart;

public interface DepartDao {
	
	public List<Depart> selectDeparts(Depart depart);
	
	public boolean insertDeparts(Depart depart);
	
	public boolean deleteDepart(Depart depart);
	
	public boolean updateDepart(Depart depart);

}
