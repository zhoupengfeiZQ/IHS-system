package com.ihs.convergence.controller.depart;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ihs.convergence.dao.DepartDao;
import com.ihs.convergence.entity.Depart;
import com.ihs.convergence.service.depart.DepartService;
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
 * 2017年2月06日
 */


@RestController
@RequestMapping(value=CommonUtil.IHS_URL_PREFIX)
public class DepartController {
	@Autowired
	private DepartService departService;
	@Autowired
	private DepartDao departDao;
	
	@Autowired
	private Snowflake snowflake;
	
	/**
	 * 查询科室
	 * @param depart
	 * @param page,Depart
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/departs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String,Object> getDeparts(Depart depart,Page page ){
		try {
			page.setPageSize(page.getRows());
			page.setPageNo(page.getPage());
			Map<String, Object> data=departService.selectDepartsByPage(depart, page);
			return data;
		} catch (ConvergenceException e) {
			Map<String,Object> result=new HashMap<String, Object>();
			result.put("result", e);
			return result;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/totalDeparts", method = RequestMethod.GET)
	public List<Depart> getTotalDeparts(Depart depart,Page page ){
		try {
			List<Depart> list=departDao.selectDeparts(depart);
		return list;
		} catch (ConvergenceException e) {
			throw e;
		}
	}

	
	/**
	 * 增加科室
	 * @param depart
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/departs", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean addDeparts(@RequestBody Depart depart){
		try {
			long id=snowflake.next();
			depart.setId(id);
			depart.setCreateBy(1);
			depart.setCreateDate(DateUtils.getDefaultCurrentStrDate());
			departService.insertDeparts(depart);
			return ConvergenceAPIUtil.biuldSuccessRespons(true);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
	}
	/**
	 * 删除城市
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/departs/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean deleteDeparts(@PathVariable("id") long id){
		try {
			Depart depart=new Depart();
			depart.setId(id);
			departService.deleteDepart(depart);
			return ConvergenceAPIUtil.biuldSuccessRespons(true);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
	}
	
	/**
	 * 更新科室
	 * @param id
	 * @param depart
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/departs/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean updateDepart(@PathVariable("id") long id,@RequestBody Depart depart){
		try {
			depart.setId(id);
			departService.updateDepart(depart);
			return ConvergenceAPIUtil.biuldSuccessRespons(true);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
		
	}
}