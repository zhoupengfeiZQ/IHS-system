package com.ihs.convergence.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ihs.convergence.entity.Patient;
import com.ihs.convergence.entity.Person;
import com.ihs.convergence.service.LoginService;
import com.ihs.convergence.service.person.PatientService;
import com.ihs.convergence.utils.CommonUtil;
import com.ihs.convergence.utils.ConvergenceAPIUtil;
import com.ihs.convergence.utils.bean.ResponseBaseBean;
import com.ihs.convergence.utils.exception.ConvergenceException;

@RestController
@RequestMapping(value=CommonUtil.IHS_URL_PREFIX)
public class LoginController {
@Autowired
private LoginService loginService;

@Autowired
private PatientService patientService;

@ResponseBody
@RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseBaseBean login(Person person,HttpServletRequest request){
	try {
		if((person.getIdentity()).contains("@")){
			Patient patient=new Patient();
			patient.setEmail(person.getIdentity());
			Patient returnPatient=patientService.selectPatientsDetail(patient);
			if(returnPatient!=null&&returnPatient.getPassword().equals(person.getPassword())){
				person.setAuthority(3);
				person.setIdentity(returnPatient.getEmail());
				
			}
		}else{
			person.setId(Integer.parseInt(person.getIdentity()));
			Person resultPerson=loginService.selectPersonById(person);
			if(resultPerson!=null&&resultPerson.getPassword().equals(person.getPassword())){
				person.setAuthority(resultPerson.getAuthority());
			}
		}
		
		return ConvergenceAPIUtil.biuldSuccessRespons(person);
	} catch (ConvergenceException e) {
		return  ConvergenceAPIUtil.biuldErrorRespons(e);
	}
	
}
}
