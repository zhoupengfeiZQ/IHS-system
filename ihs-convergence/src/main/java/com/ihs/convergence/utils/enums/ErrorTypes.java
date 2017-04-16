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
	PERSON_UPDATE_ERROR("person update error"),
	PERSON_DELETE_ERROR("person delete error"),
	PERSON_INSERT_ERROR("person insert error"),
	
	PATIENT_QUERY_ERROR("patient query error"),
	PATIENT_UPDATE_ERROR("patient update error"),
	PATIENT_INSERT_ERROR("patient insert error"),
	
	//药房
	PHARMACY_UPDATE_ERROR("pharmacy update error"),
	PHARMACY_DELETE_ERROR("pharmacy delete error"),
	PHARMACY_INSERT_ERROR("pharmacy insert error"),
	PHARMACY_QUERY_ERROR("pharmacy query error"),
	
	//科室
	DEPART_UPDATE_ERROR("depart update error"),
	DEPART_DELETE_ERROR("depart delete error"),
	DEPART_INSERT_ERROR("depart insert error"),
	DEPART_QUERY_ERROR("depart query error"),
	
	//挂号
	REGISTRATION_INSERT_ERROR("registration insert error"),
	REGISTRATION_QUERY_ERROR("registration query error"),
	
	//病历
	RECORD_INSERT_ERROR("record insert error"),
	RECORD_QUERY_ERROR("record query error"),
	
	//手术
	OPERATION_INSERT_ERROR("operation insert error"),
	OPERATION_QUERY_ERROR("operation query error"),
	OPERATION_UPDATE_ERROR("operation update error"),
	
	;
	
	
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
