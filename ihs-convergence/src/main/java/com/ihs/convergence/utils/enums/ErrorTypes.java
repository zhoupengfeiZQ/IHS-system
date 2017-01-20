package com.ihs.convergence.utils.enums;

/**
 * 
 * 项目名 ihs
 * 
 * 异常类型
 * @author pengfei.zhou
 * @date 2017/1/20
 *
 */
public enum ErrorTypes {

	NULL_POINT("java.lang.NullPointerException");
	
	private String type;
	ErrorTypes(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}