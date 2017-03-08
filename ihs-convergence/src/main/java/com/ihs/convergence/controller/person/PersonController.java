package com.ihs.convergence.controller.person;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ihs.convergence.entity.Person;
import com.ihs.convergence.service.person.PersonService;
import com.ihs.convergence.utils.CommonUtil;
import com.ihs.convergence.utils.ConvergenceAPIUtil;
import com.ihs.convergence.utils.DateUtils;
import com.ihs.convergence.utils.bean.ResponseBaseBean;
import com.ihs.convergence.utils.exception.ConvergenceException;
import com.ihs.convergence.utils.gen.Snowflake;
import com.ihs.convergence.utils.page.Page;



/**
 * 
 * @author pengfei.zhou
 * 2017年3月02日
 */


@RestController
@RequestMapping(value=CommonUtil.IHS_URL_PREFIX)
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@Autowired
	private Snowflake snowflake;
	
	/**
	 * 查询员工信息
	 * @param page,Person
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/persons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String,Object> getPersons(Person person,Page page ){
		try {
			page.setPageSize(page.getRows());
			page.setPageNo(page.getPage());
			Map<String, Object> data=personService.selectPersonsByPage(person, page);
			return data;
		} catch (ConvergenceException e) {
			Map<String,Object> result=new HashMap<String, Object>();
			result.put("result", e);
			return result;
		}
	}

	
	/**
	 * 增加员工信息
	 * @param person
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/persons", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean addPersons(@RequestBody Person person){
		try {
			person.setHiredate(DateUtils.getDefaultCurrentStrDate());
			personService.insertPersons(person);
			
			return ConvergenceAPIUtil.biuldSuccessRespons(true);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
	}
	/**
	 * 删除员工信息
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/persons/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean deletePersons(@PathVariable("id") int id){
		try {
			Person person=new Person();
			person.setId(id);
			personService.deletePersons(person);
			return ConvergenceAPIUtil.biuldSuccessRespons(true);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
	}
	
	/**
	 * 更新员工信息
	 * @param id
	 * @param Person
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/persons/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean updatePersons(@PathVariable("id") int id,@RequestBody Person person){
		try {
			person.setId(id);
			personService.updatePersons(person);
			return ConvergenceAPIUtil.biuldSuccessRespons(true);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
		
	}
}