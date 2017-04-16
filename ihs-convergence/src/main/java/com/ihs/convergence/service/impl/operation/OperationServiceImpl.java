package com.ihs.convergence.service.impl.operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.ihs.convergence.dao.OperationDao;
import com.ihs.convergence.entity.Operation;
import com.ihs.convergence.service.ProccessQueryPage;
import com.ihs.convergence.service.operation.OperationService;
import com.ihs.convergence.utils.enums.ConvergenceCode;
import com.ihs.convergence.utils.enums.ErrorTypes;
import com.ihs.convergence.utils.exception.ConvergenceDataAccessException;
import com.ihs.convergence.utils.exception.ConvergenceDataTransferException;
import com.ihs.convergence.utils.page.Page;
import com.ihs.convergence.utils.page.PageUtils;


@Service
public class OperationServiceImpl implements OperationService{
	@Autowired
	private OperationDao operationDao;

	@Autowired
	private ProccessQueryPage proccessQueryPage;
	
	public Map<String, Object> selectOperationsByPage(Operation operation, Page page) {
	
		try {
			if (page.getPageNo() == null || page.getPageSize() == null) {
				page.setPageNo(1);
				page.setPageSize(5);
			}
			PageUtils.page(page);
			List<Operation> list=operationDao.selectOperation(operation);
			Map<String,Object> map = proccessQueryPage.proccess(list);
			Map<String,Object> data=new HashMap<String, Object>();
			data.put("rows", list);
			data.put("total",map.get("total") );
			return data;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.OPERATION_QUERY_ERROR.getType(), e.getMessage(), e);
		}
	}
	
	@Override
	public Operation selectOperationsDetail(Operation operation) {
		try {
		return	operationDao.selectOperationDetail(operation);
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.OPERATION_QUERY_ERROR.getType(), e.getMessage(), e);
			
		}
		
	}
	
	@Transactional
	public boolean insertOperations(Operation operation) {
		if(StringUtils.isEmpty(operation.getPatient())){
			throw new ConvergenceDataTransferException(ConvergenceCode.NULL_PARAM_ERROR.getCode(), ErrorTypes.OPERATION_INSERT_ERROR.getType(), ConvergenceCode.NULL_PARAM_ERROR.getMessage());
		}
		try {
			operationDao.insertOperation(operation);
			return true;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.OPERATION_INSERT_ERROR.getType(), e.getMessage(), e);
		}
		
	}

	@Transactional
	public boolean updateOperations(Operation operation) {
		try {
			operationDao.updateOperation(operation);
			return true;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.OPERATION_UPDATE_ERROR.getType(), e.getMessage(), e);
		}
		
	}

	

}
