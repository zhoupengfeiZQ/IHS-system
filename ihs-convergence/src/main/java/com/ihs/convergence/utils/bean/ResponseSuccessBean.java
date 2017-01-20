package com.ihs.convergence.utils.bean;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * project name is ihs
 * 返回请求成功之后的实体
 * @author pengfei.zhou
 * @date 2017/1/20
 */
@XmlRootElement
@Component
public class ResponseSuccessBean extends ResponseBaseBean{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6947835080658921780L;
	//响应成功数据
    private Object result;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
