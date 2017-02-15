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

	NULL_POINT("java.lang.NullPointerException"),
	//人事
	PERSON_QUERY_ERROR("person query error"),
	//科室
	DEPART_UPDATE_ERROR("depart update error"),
	DEPART_DELETE_ERROR("depart delete error"),
	DEPART_INSERT_ERROR("depart insert error"),
	DEPART_QUERY_ERROR("depart query error");
	
	
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
