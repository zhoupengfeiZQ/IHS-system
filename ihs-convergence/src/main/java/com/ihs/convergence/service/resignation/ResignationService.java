package com.ihs.convergence.service.resignation;

import java.util.Map;

import com.ihs.convergence.entity.Resignation;
import com.ihs.convergence.utils.page.Page;

public interface ResignationService {
	
	public Map<String, Object> selectResignationsByPage(Resignation resignation,Page page);
	
	public Resignation  selectResignationsDetail(Resignation resignation);
	
	public boolean insertResignations(Resignation resignation);
	
	public boolean updateResignations(Resignation resignation);
}
