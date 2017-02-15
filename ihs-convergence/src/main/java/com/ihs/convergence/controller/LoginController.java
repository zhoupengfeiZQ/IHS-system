package com.ihs.convergence.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ihs.convergence.entity.Person;
import com.ihs.convergence.service.LoginService;
import com.ihs.convergence.utils.CommonUtil;
import com.ihs.convergence.utils.ConvergenceAPIUtil;
import com.ihs.convergence.utils.bean.ResponseBaseBean;
import com.ihs.convergence.utils.exception.ConvergenceException;

@RestController
@RequestMapping(value=CommonUtil.IHS_URL_PREFIX)
public class LoginController {
@Autowired
private LoginService loginService;

@ResponseBody
@RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseBaseBean login(Person person,HttpServletRequest request){
	try {
		String result=null;
		Person resultPerson=loginService.selectPersonById(person);
		if(resultPerson!=null&&resultPerson.getPassword().equals(person.getPassword())){
			result="success"+resultPerson.getAuthority();
			request.getSession().setAttribute("loginPerson", resultPerson);
		}else{
			result="fail";
		}
		return ConvergenceAPIUtil.biuldSuccessRespons(result);
	} catch (ConvergenceException e) {
		return  ConvergenceAPIUtil.biuldErrorRespons(e);
	}
	
}
}
