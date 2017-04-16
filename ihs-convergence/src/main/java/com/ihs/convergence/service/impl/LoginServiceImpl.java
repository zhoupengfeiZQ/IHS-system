package com.ihs.convergence.service.impl;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihs.convergence.dao.PersonDao;
import com.ihs.convergence.entity.Person;
import com.ihs.convergence.service.LoginService;
import com.ihs.convergence.utils.enums.ConvergenceCode;
import com.ihs.convergence.utils.enums.ErrorTypes;
import com.ihs.convergence.utils.exception.ConvergenceDataAccessException;
import com.ihs.convergence.utils.exception.ConvergenceDataTransferException;

@Service
public class LoginServiceImpl implements LoginService{
@Autowired
private PersonDao personDao;

	
	public Person selectPersonById(Person person) {
		if(person.getId()==0||StringUtils.isEmpty(person.getPassword())){
			throw new ConvergenceDataTransferException(ConvergenceCode.INVALID_ACCOUNT_OR_PASSWORD.getCode(), ErrorTypes.PERSON_QUERY_ERROR.getType(), ConvergenceCode.INVALID_ACCOUNT_OR_PASSWORD.getMessage());
		}
		try {
			Person	resultPerson=personDao.selectPersonDetail(person);
			return resultPerson;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.PERSON_QUERY_ERROR.getType(), e.getMessage(), e);
		}
	}

}
