package com.ihs.convergence.service.impl.depart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.ihs.convergence.dao.DepartDao;
import com.ihs.convergence.entity.Depart;
import com.ihs.convergence.service.ProccessQueryPage;
import com.ihs.convergence.service.depart.DepartService;
import com.ihs.convergence.utils.enums.ConvergenceCode;
import com.ihs.convergence.utils.enums.ErrorTypes;
import com.ihs.convergence.utils.exception.ConvergenceDataAccessException;
import com.ihs.convergence.utils.exception.ConvergenceDataTransferException;
import com.ihs.convergence.utils.page.Page;
import com.ihs.convergence.utils.page.PageUtils;


@Service
public class DepartServiceImpl implements DepartService{
	@Autowired
	private DepartDao departDao;

	@Autowired
	private ProccessQueryPage proccessQueryPage;
	@Override
	public Map<String, Object> selectDepartsByPage(Depart depart, Page page) {
	
		try {
			if (page.getPageNo() == null || page.getPageSize() == null) {
				page.setPageNo(1);
				page.setPageSize(5);
			}
			PageUtils.page(page);
			List<Depart> list=departDao.selectDeparts(depart);
			Map<String,Object> map = proccessQueryPage.proccess(list);
			Map<String,Object> data=new HashMap<String, Object>();
			data.put("rows", list);
			data.put("total",map.get("total") );
			return data;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.DEPART_QUERY_ERROR.getType(), e.getMessage(), e);
		}
	}
	
	@Transactional
	public boolean insertDeparts(Depart depart) {
		if(StringUtils.isEmpty(depart.getName())){
			throw new ConvergenceDataTransferException(ConvergenceCode.NULL_PARAM_ERROR.getCode(), ErrorTypes.DEPART_INSERT_ERROR.getType(), ConvergenceCode.NULL_PARAM_ERROR.getMessage());
		}
		try {
			departDao.insertDeparts(depart);
			return true;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.DEPART_INSERT_ERROR.getType(), e.getMessage(), e);
		}
		
	}

	@Transactional
	public boolean deleteDepart(Depart depart) {
		try {
			departDao.deleteDepart(depart);
			return true;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.DEPART_DELETE_ERROR.getType(), e.getMessage(), e);
		}
		
	}

	@Transactional
	public boolean updateDepart(Depart depart) {
		try {
			departDao.updateDepart(depart);
			return true;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.DEPART_UPDATE_ERROR.getType(), e.getMessage(), e);
		}
		
	}

}
