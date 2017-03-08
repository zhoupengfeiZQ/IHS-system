package com.ihs.convergence.controller.pharmacy;

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
import com.ihs.convergence.entity.Drug;
import com.ihs.convergence.service.pharmacy.DrugService;
import com.ihs.convergence.utils.CommonUtil;
import com.ihs.convergence.utils.ConvergenceAPIUtil;
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
public class DrugController {
	@Autowired
	private DrugService drugService;
	
	@Autowired
	private Snowflake snowflake;
	
	/**
	 * 查询药品信息
	 * @param page,Drug
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/drugs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String,Object> getDrugs(Drug drug,Page page ){
		try {
			page.setPageSize(page.getRows());
			page.setPageNo(page.getPage());
			Map<String, Object> data=drugService.selectDrugsByPage(drug, page);
			return data;
		} catch (ConvergenceException e) {
			Map<String,Object> result=new HashMap<String, Object>();
			result.put("result", e);
			return result;
		}
	}

	
	/**
	 * 增加药品信息
	 * @param depart
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/drugs", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean addDrugs(@RequestBody Drug drug){
		try {
			long id=snowflake.next();
			drug.setDrugId(id);
			drugService.insertDrugs(drug);
			return ConvergenceAPIUtil.biuldSuccessRespons(true);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
	}
	/**
	 * 删除药品信息
	 * @param drugId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/drugs/{drugId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean deleteDrugs(@PathVariable("drugId") long drugId){
		try {
			Drug drug=new Drug();
			drug.setDrugId(drugId);
			drugService.deleteDrugs(drug);
			return ConvergenceAPIUtil.biuldSuccessRespons(true);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
	}
	
	/**
	 * 更新药品信息
	 * @param drugId
	 * @param drug
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/drugs/{drugId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean updateDrugs(@PathVariable("drugId") long drugId,@RequestBody Drug drug){
		try {
			drug.setDrugId(drugId);
			drugService.updateDrugs(drug);
			return ConvergenceAPIUtil.biuldSuccessRespons(true);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
		
	}
}