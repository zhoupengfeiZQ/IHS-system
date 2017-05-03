package com.ihs.convergence.controller.resignation;

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

import com.ihs.convergence.dao.PersonDao;
import com.ihs.convergence.entity.Person;
import com.ihs.convergence.entity.Resignation;
import com.ihs.convergence.service.resignation.ResignationService;
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
 * 2017年4月13日
 */


@RestController
@RequestMapping(value=CommonUtil.IHS_URL_PREFIX)
public class ResignationController {
	@Autowired
	private ResignationService resignationService;
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private Snowflake snowflake;
	
	
	@ResponseBody
	@RequestMapping(value = "/resignations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String,Object> getResignations(Resignation resignation,Page page ){
		try {
			page.setPageSize(page.getRows());
			page.setPageNo(page.getPage());
			Map<String, Object> data=resignationService.selectResignationsByPage(resignation, page);
			return data;
		} catch (ConvergenceException e) {
			Map<String,Object> result=new HashMap<String, Object>();
			result.put("result", e);
			return result;
		}
	}

	
	@ResponseBody
	@RequestMapping(value = "/resignations/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean selectResignations(@PathVariable("id") long id){
		try {
			Resignation param=new Resignation();
			param.setId(id);
			Resignation returnResignation=resignationService.selectResignationsDetail(param);
			return ConvergenceAPIUtil.biuldSuccessRespons(returnResignation);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/resignations", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean addResignations(@RequestBody Resignation resignation){
		try {
			resignation.setId(snowflake.next());
			resignation.setApplyTime(DateUtils.getDefaultCurrentStrDate());
			resignationService.insertResignations(resignation);
			return ConvergenceAPIUtil.biuldSuccessRespons(true);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/resignations/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean updateResignations(@RequestBody Resignation resignation,@PathVariable("id") long id){
		try {
			resignation.setId(id);
			resignation.setApprovalTime(DateUtils.getDefaultCurrentStrDate());
			resignationService.updateResignations(resignation);
			Person person=new Person();
			person.setId(Integer.parseInt(resignation.getNumber()));
			person.setLeavedate(DateUtils.getDefaultCurrentStrDate());
			personDao.personResign(person);
			return ConvergenceAPIUtil.biuldSuccessRespons(true);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
		
	}
	
}