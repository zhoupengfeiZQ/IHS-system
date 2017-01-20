package com.ihs.convergence.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ihs.convergence.utils.bean.ResponseBaseBean;
import com.ihs.convergence.utils.bean.ResponseErrorBean;
import com.ihs.convergence.utils.bean.ResponseErrorData;
import com.ihs.convergence.utils.bean.ResponseSuccessBean;
import com.ihs.convergence.utils.bean.ResponseSysErrorData;
import com.ihs.convergence.utils.enums.ConvergenceCode;
import com.ihs.convergence.utils.exception.ConvergenceApplicationException;
import com.ihs.convergence.utils.exception.ConvergenceDataAccessException;
import com.ihs.convergence.utils.exception.ConvergenceDataTransferException;
import com.ihs.convergence.utils.exception.ConvergenceException;
import com.ihs.convergence.utils.exception.ConvergenceSystemException;



/**
 * biuld api return result util
 *
 */
public class ConvergenceAPIUtil {
	protected static Logger logger = LoggerFactory.getLogger(ConvergenceAPIUtil.class);
    /**
     * biuld error response
     * @param message a descr about code
     * @param type java exception message
     * @param traceId trace id,for debug log,may be a entity id or some property string
     * @return such as {"error":{"message":"message","type":"type","code":11,"error_subcode":100,"trace_id":"traceId"}}
     */
    public static synchronized ResponseBaseBean biuldErrorRespons(int code, int errorSubCode, String message, String type) {
       
        String errorLog="{code:"+code+"},{errorSubCode:"+errorSubCode+"},{message:"+message+"},{type:"+type+"}";
        logger.error("convergenceErrorLog["+errorLog+"]");
    	ResponseErrorBean respons = new ResponseErrorBean();
        if (errorSubCode == 0) {
        	ResponseSysErrorData error = new ResponseSysErrorData();
        	error.setCode(code);
	        error.setMessage(message);
	        error.setType(type);
	        respons.setError(error);
        } else {
	        ResponseErrorData error = new ResponseErrorData();
	        error.setCode(code);
	        error.setErrorSubcode(errorSubCode);
	        error.setMessage(message);
	        error.setType(type);
	        respons.setError(error);
        }
        return respons;
    }
    
    /**
     * biuld error response
     * @param message a descr about code
     * @param type java exception message
     * @param traceId trace id,for debug log,may be a entity id or some property string
     * @return such as {"error":{"message":"message","type":"type","code":11,"error_subcode":100,"trace_id":"traceId"}}
     */
    public static synchronized ResponseBaseBean biuldErrorRespons(int errorSubCode, String message, String type) {
    	return biuldErrorRespons(CommonUtil.CODE_CONVERGENCE,errorSubCode,message,type);
    }

    /**
     * biuld success response
     * @param result
     * @return {result:object} ,such as {result:"xxx"} or {result:{}} or {result:[]} and so on.
     */
    public static synchronized ResponseBaseBean biuldSuccessRespons(Object result) {
        ResponseSuccessBean respons = new ResponseSuccessBean();
        respons.setResult(result);
        return respons;
    }
    
    /**
     * 分装异常错误信息
     * @author zhou
     * @param e 错误信息
     * @return 返回前台信息
     */
    public static synchronized ResponseBaseBean biuldErrorRespons(ConvergenceException e) {
    	
    	//应用错误
    	if (e instanceof ConvergenceApplicationException) {
    		return biuldErrorRespons(e.getCode(),e.getErrorSubCode(),e.getMessage(),e.getType());
    	}
    	//系统错误
    	else if (e instanceof ConvergenceSystemException) {
    		String type = "Cause by ConvergenceSystemException : ";
    		return biuldErrorRespons(e.getCode(),e.getErrorSubCode(),e.getMessage(),type+e.getType());
    	}
    	//数据传输
    	else if(e instanceof ConvergenceDataTransferException) {
    		String type = "Cause by ConvergenceDataTransferException : ";
    		return biuldErrorRespons(e.getCode(),e.getErrorSubCode(),e.getMessage(),type+e.getType());
    	}
    	//数据访问
    	else if(e instanceof ConvergenceDataAccessException) {
    		String type = "Cause by ConvergenceDataAccessException : ";
    		return biuldErrorRespons(e.getCode(),e.getErrorSubCode(),e.getMessage(),type+e.getType());
    	}
    	else {
    		return biuldErrorRespons(ConvergenceCode.CONVERGENCE_CODE.getCode(),e.getErrorSubCode(),e.getMessage(),e.getType());
    	}
    }
}
