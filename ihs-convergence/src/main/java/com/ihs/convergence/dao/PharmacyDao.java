package com.ihs.convergence.dao;

import java.util.List;

import com.ihs.convergence.entity.Drug;


public interface PharmacyDao {
	public List<Drug> selectDrug(Drug drug);
	
	public boolean insertDrug(Drug drug);
	
	public boolean deleteDrug(Drug drug);
	
	public boolean updateDrug(Drug drug);
}
