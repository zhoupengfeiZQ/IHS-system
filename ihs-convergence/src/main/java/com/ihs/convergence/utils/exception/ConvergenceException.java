package com.ihs.convergence.utils.exception;

import com.ihs.convergence.utils.enums.ConvergenceCode;



/**
 * 
 * 项目名 ihs
 * 定义ihs 基本的异常信息
 * 
 * @author pengfei.zhou
 * @date   2017年1月20日 
 *
 */
public class ConvergenceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/** 模块代码 */
	private int code;
	/** 提供待验证的code码 */
	private int errorSubCode;
	/** 报错类型 */
	private String type;
	/** 错误信息 */
	private String message;
	/** 用于调试追踪 */


	/**
	 *
	 * 只要传入type ，message，追踪错误，e
	 * @param type
	 * @param message
	 * @param e
	 */
	public ConvergenceException(String type,String message,Throwable e) {
		super(message,e);
		this.code = ConvergenceCode.CONVERGENCE_CODE.getCode();
		this.type = type;
		this.message = message;
	}
	
	/**
	 * 需要
	 * @param errorSubCode
	 * @param type
	 * @param message
	 * @param e
	 * @return 
	 */
	public ConvergenceException(int errorSubCode,String type,String message) {
		super(message);
		this.code = ConvergenceCode.CONVERGENCE_CODE.getCode();
		this.errorSubCode = errorSubCode;
		this.type = type;
		this.message = message;
	}
	
	public ConvergenceException(int errorSubCode, String type, String message,Throwable e) {
		super(message,e);
		this.code = ConvergenceCode.CONVERGENCE_CODE.getCode();
		this.errorSubCode = errorSubCode;
		this.type = type;
		this.message = message;
		
	}
	
	public ConvergenceException(int code, int errorSubCode, String type, String message) {
		super(message);
		this.code = code;
		this.errorSubCode = errorSubCode;
		this.type = type;
		this.message = message;
	}

	public ConvergenceException(int code, int errorSubCode, String type, String message,Throwable e) {
		super(message,e);
		this.code = code;
		this.errorSubCode = errorSubCode;
		this.type = type;
		this.message = message;
	}
	
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getErrorSubCode() {
		return errorSubCode;
	}

	public void setErrorSubCode(int errorSubCode) {
		this.errorSubCode = errorSubCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
