package com.ihs.convergence.service.impl.resignation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.ihs.convergence.dao.ResignationDao;
import com.ihs.convergence.entity.Resignation;
import com.ihs.convergence.service.ProccessQueryPage;
import com.ihs.convergence.service.resignation.ResignationService;
import com.ihs.convergence.utils.enums.ConvergenceCode;
import com.ihs.convergence.utils.enums.ErrorTypes;
import com.ihs.convergence.utils.exception.ConvergenceDataAccessException;
import com.ihs.convergence.utils.exception.ConvergenceDataTransferException;
import com.ihs.convergence.utils.page.Page;
import com.ihs.convergence.utils.page.PageUtils;


@Service
public class ResignationServiceImpl implements ResignationService{
	@Autowired
	private ResignationDao resignationDao;

	@Autowired
	private ProccessQueryPage proccessQueryPage;
	
	public Map<String, Object> selectResignationsByPage(Resignation resignation, Page page) {
	
		try {
			if (page.getPageNo() == null || page.getPageSize() == null) {
				page.setPageNo(1);
				page.setPageSize(5);
			}
			PageUtils.page(page);
			List<Resignation> list=resignationDao.selectResignation(resignation);
			Map<String,Object> map = proccessQueryPage.proccess(list);
			Map<String,Object> data=new HashMap<String, Object>();
			data.put("rows", list);
			data.put("total",map.get("total") );
			return data;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.RESIGNATION_QUERY_ERROR.getType(), e.getMessage(), e);
		}
	}
	
	@Override
	public Resignation selectResignationsDetail(Resignation resignation) {
		try {
		return	resignationDao.selectResignationDetail(resignation);
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.RESIGNATION_QUERY_ERROR.getType(), e.getMessage(), e);
			
		}
		
	}
	
	@Transactional
	public boolean insertResignations(Resignation resignation) {
		if(StringUtils.isEmpty(resignation.getName())){
			throw new ConvergenceDataTransferException(ConvergenceCode.NULL_PARAM_ERROR.getCode(), ErrorTypes.RESIGNATION_INSERT_ERROR.getType(), ConvergenceCode.NULL_PARAM_ERROR.getMessage());
		}
		try {
			resignationDao.insertResignation(resignation);
			return true;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.RESIGNATION_INSERT_ERROR.getType(), e.getMessage(), e);
		}
		
	}

	@Transactional
	public boolean updateResignations(Resignation resignation) {
		try {
			resignationDao.updateResignation(resignation);
			return true;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.RESIGNATION_UPDATE_ERROR.getType(), e.getMessage(), e);
		}
		
	}

	

}
