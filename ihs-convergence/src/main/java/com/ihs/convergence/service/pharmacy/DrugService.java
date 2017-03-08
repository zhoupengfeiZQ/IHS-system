package com.ihs.convergence.service.pharmacy;

import java.util.Map;

import com.ihs.convergence.entity.Drug;
import com.ihs.convergence.utils.page.Page;

public interface DrugService {
	
	public Map<String, Object> selectDrugsByPage(Drug drug,Page page);
	
	public boolean insertDrugs(Drug drug);
	
	public boolean deleteDrugs(Drug drug);
	
	public boolean updateDrugs(Drug drug);
}
