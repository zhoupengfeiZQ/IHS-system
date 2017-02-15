package com.ihs.convergence.service.depart;

import java.util.Map;
import com.ihs.convergence.entity.Depart;
import com.ihs.convergence.utils.page.Page;


public interface DepartService {
	
	public Map<String, Object> selectDepartsByPage(Depart depart,Page page);
	
	public boolean insertDeparts(Depart depart);
	
	public boolean deleteDepart(Depart depart);
	
	public boolean updateDepart(Depart depart);
}
