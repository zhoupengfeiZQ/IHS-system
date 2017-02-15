package com.ihs.convergence.utils.enums;

/**
 * 
 * 项目名 convergence
 * @author --pengfei.zhou
 * @date   2017年1月20日 
 */
public enum ConvergenceCode {

	CONVERGENCE_CODE("互联医疗系统","ihs",15),
	//账号
	INVALID_ACCOUNT_OR_PASSWORD("无效的账号或密码","invalid account or password",100),
	// convergence模块内部未知错误
	NULL_PARAM_ERROR("参数为空","null param error",101),
	INNER_ERROR("ihs内部错误","inner exception about ihs",999)
	;
	private String description; //代码描述
	private String message;
	private int code; //代码
	
	ConvergenceCode(String description,String message,int code){
		this.description = description;
		this.message = message;
		this.code = code;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
