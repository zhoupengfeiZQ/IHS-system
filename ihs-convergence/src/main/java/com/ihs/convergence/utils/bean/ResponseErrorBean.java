package com.ihs.convergence.utils.bean;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * project name is ihs
 * 请求错误时候返回的实体
 * @author pengfei.zhou
 * @date 2017/1/20
 */
//添加此处注解为了controller层返回xml类型数据
@XmlRootElement
@Component
public class ResponseErrorBean extends ResponseBaseBean {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1278411840361570434L;
	//error bean
    private ResponseSysErrorData error;

	public ResponseSysErrorData getError() {
		return error;
	}

	public void setError(ResponseSysErrorData error) {
		this.error = error;
	}
}
