package com.ihs.convergence.service.impl.person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ihs.convergence.dao.PersonDao;

import com.ihs.convergence.entity.Person;
import com.ihs.convergence.service.ProccessQueryPage;
import com.ihs.convergence.service.person.PersonService;
import com.ihs.convergence.utils.enums.ConvergenceCode;
import com.ihs.convergence.utils.enums.ErrorTypes;
import com.ihs.convergence.utils.exception.ConvergenceDataAccessException;
import com.ihs.convergence.utils.exception.ConvergenceDataTransferException;
import com.ihs.convergence.utils.page.Page;
import com.ihs.convergence.utils.page.PageUtils;


@Service
public class PersonServiceImpl implements PersonService{
	@Autowired
	private PersonDao personDao;

	@Autowired
	private ProccessQueryPage proccessQueryPage;
	
	public Map<String, Object> selectPersonsByPage(Person person, Page page) {
	
		try {
			if (page.getPageNo() == null || page.getPageSize() == null) {
				page.setPageNo(1);
				page.setPageSize(5);
			}
			PageUtils.page(page);
			List<Person> list=personDao.selectPerson(person);
			Map<String,Object> map = proccessQueryPage.proccess(list);
			Map<String,Object> data=new HashMap<String, Object>();
			data.put("rows", list);
			data.put("total",map.get("total") );
			return data;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.PERSON_QUERY_ERROR.getType(), e.getMessage(), e);
		}
	}
	
	@Transactional
	public boolean insertPersons(Person person) {
		if(StringUtils.isEmpty(person.getName())){
			throw new ConvergenceDataTransferException(ConvergenceCode.NULL_PARAM_ERROR.getCode(), ErrorTypes.PERSON_INSERT_ERROR.getType(), ConvergenceCode.NULL_PARAM_ERROR.getMessage());
		}
		try {
			personDao.insertPerson(person);
			return true;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.PERSON_INSERT_ERROR.getType(), e.getMessage(), e);
		}
		
	}

	@Transactional
	public boolean deletePersons(Person person) {
		try {
			personDao.deletePerson(person);
			return true;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.PERSON_DELETE_ERROR.getType(), e.getMessage(), e);
		}
		
	}

	@Transactional
	public boolean updatePersons(Person person) {
		try {
			personDao.updatePerson(person);
			return true;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.PERSON_UPDATE_ERROR.getType(), e.getMessage(), e);
		}
		
	}

}
