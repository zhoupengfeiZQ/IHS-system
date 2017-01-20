package com.ihs.convergence.utils.bean;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * project name is ihs
 * 返回实体基类
 * @author pengfei.zhou
 * @date 2017/1/20
 */
@XmlRootElement
@Component
public class ResponseBaseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6620985307074700325L;
	
}
