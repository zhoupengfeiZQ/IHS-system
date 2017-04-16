package com.ihs.convergence.service.impl.registration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ihs.convergence.dao.RegistrationDao;

import com.ihs.convergence.entity.Registration;
import com.ihs.convergence.service.ProccessQueryPage;
import com.ihs.convergence.service.registration.RegistrationService;
import com.ihs.convergence.utils.enums.ConvergenceCode;
import com.ihs.convergence.utils.enums.ErrorTypes;
import com.ihs.convergence.utils.exception.ConvergenceDataAccessException;
import com.ihs.convergence.utils.exception.ConvergenceDataTransferException;
import com.ihs.convergence.utils.page.Page;
import com.ihs.convergence.utils.page.PageUtils;

@Service
public class RegistrationServiceImpl implements RegistrationService{
	@Autowired
	private RegistrationDao registrationDao;
	
	@Autowired
	private ProccessQueryPage proccessQueryPage;
	
	public Map<String, Object> selectRegistrationsByPage(Registration registration, Page page) {
		
		try {
			if (page.getPageNo() == null || page.getPageSize() == null) {
				page.setPageNo(1);
				page.setPageSize(5);
			}
			PageUtils.page(page);
			List<Registration> list=registrationDao.selectRegistration(registration);
			Map<String,Object> map = proccessQueryPage.proccess(list);
			Map<String,Object> data=new HashMap<String, Object>();
			data.put("rows", list);
			data.put("total",map.get("total") );
			return data;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.REGISTRATION_QUERY_ERROR.getType(), e.getMessage(), e);
		}
	}
	
	@Override
	public Registration selectRegistrationById(long registration_id) {
		try {
		return	registrationDao.selectRegistrationById(registration_id);
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.REGISTRATION_QUERY_ERROR.getType(), e.getMessage(), e);
		}
		
	}
	

	@Transactional
	public boolean addRegistrations(Registration registration) {
		if(StringUtils.isEmpty(registration.getDepart())||StringUtils.isEmpty(registration.getDoctor())||StringUtils.isEmpty(registration.getTime())){
			throw new ConvergenceDataTransferException(ConvergenceCode.NULL_PARAM_ERROR.getCode(), ErrorTypes.REGISTRATION_INSERT_ERROR.getType(), ConvergenceCode.NULL_PARAM_ERROR.getMessage());
		}
		try {
			Integer index=registrationDao.selectRegistrationCount(registration);
			if(index==null){
				index=1;
			}else{
				index=index+1;
			}
			registration.setRegistrationIndex(index);
			return registrationDao.insertRegistration(registration);
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.REGISTRATION_INSERT_ERROR.getType(), e.getMessage(), e);
		}
		
		
	}


	

}
