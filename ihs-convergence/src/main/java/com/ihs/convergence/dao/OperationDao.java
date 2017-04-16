package com.ihs.convergence.dao;

import java.util.List;
import com.ihs.convergence.entity.Operation;


public interface OperationDao {
	
	public Operation selectOperationDetail(Operation operation);
	
	public List<Operation> selectOperation(Operation operation);
	
	public boolean insertOperation(Operation operation);
	
	public boolean updateOperation(Operation operation);
}
