package com.ihs.convergence.service.operation;

import java.util.Map;
import com.ihs.convergence.entity.Operation;
import com.ihs.convergence.utils.page.Page;

public interface OperationService {
	
	public Map<String, Object> selectOperationsByPage(Operation operation,Page page);
	
	public Operation  selectOperationsDetail(Operation operation);
	
	public boolean insertOperations(Operation operation);
	
	public boolean updateOperations(Operation operation);
}
