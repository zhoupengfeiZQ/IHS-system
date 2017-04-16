package com.ihs.convergence.controller.operation;

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

import com.ihs.convergence.entity.Operation;
import com.ihs.convergence.service.operation.OperationService;
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
public class OperationController {
	@Autowired
	private OperationService operationService;
	
	@Autowired
	private Snowflake snowflake;
	
	/**
	 * 查询手术申请列表
	 * @param page,Operation
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/operations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String,Object> getOperations(Operation operation,Page page ){
		try {
			page.setPageSize(page.getRows());
			page.setPageNo(page.getPage());
			Map<String, Object> data=operationService.selectOperationsByPage(operation, page);
			return data;
		} catch (ConvergenceException e) {
			Map<String,Object> result=new HashMap<String, Object>();
			result.put("result", e);
			return result;
		}
	}

	/**
	 *查询手术申请单详情
	 * @param Operation
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/operations/{operation_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean selectOperations(@PathVariable("operation_id") long operation_id){
		try {
			Operation param=new Operation();
			param.setOperationId(operation_id);
			Operation returnOperation=operationService.selectOperationsDetail(param);
			return ConvergenceAPIUtil.biuldSuccessRespons(returnOperation);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
	}
	
	
	/**
	 * 新增手术申请单
	 * @param Operation
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/operations", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean addOperations(@RequestBody Operation operation){
		try {
			operation.setOperationId(snowflake.next());
			operation.setDate(DateUtils.getDefaultCurrentStrDate());
			operationService.insertOperations(operation);
			return ConvergenceAPIUtil.biuldSuccessRespons(true);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
	}
	
	/**
	 * 更新手术申请单
	 * @param Operation
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/operations/{operation_id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean updateOperations(@RequestBody Operation operation,@PathVariable("operation_id") long operation_id){
		try {
			operation.setOperationId(operation_id);
			operationService.updateOperations(operation);
			return ConvergenceAPIUtil.biuldSuccessRespons(true);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
		
	}
	
}