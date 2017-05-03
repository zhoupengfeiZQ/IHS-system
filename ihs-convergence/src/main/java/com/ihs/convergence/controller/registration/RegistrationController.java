package com.ihs.convergence.controller.registration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ihs.convergence.entity.Patient;
import com.ihs.convergence.entity.Person;
import com.ihs.convergence.entity.Registration;
import com.ihs.convergence.service.person.PatientService;
import com.ihs.convergence.service.person.PersonService;
import com.ihs.convergence.service.registration.RegistrationService;
import com.ihs.convergence.utils.CommonUtil;
import com.ihs.convergence.utils.ConvergenceAPIUtil;
import com.ihs.convergence.utils.bean.ResponseBaseBean;
import com.ihs.convergence.utils.gen.Snowflake;
import com.ihs.convergence.utils.page.Page;
import com.ihs.convergence.utils.exception.ConvergenceException;

@RestController
@RequestMapping(value=CommonUtil.IHS_URL_PREFIX)
public class RegistrationController {

	@Autowired
	private Snowflake snowflake;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private RegistrationService registrationService;
	
	
	
	/**
	 * 新增挂号单
	 * @param Registration
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/registrations/{email}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean addRegistrations(@RequestBody Registration registration,@PathVariable String email){
		try {
			long id=snowflake.next();
			registration.setRegistrationId(id);
			Person person=new Person();
			person.setName(registration.getDoctor());
			Person doctor=personService.selectPersonsDetail(person);
			registration.setDoctorId(doctor.getId());
			Patient p=new Patient();
			p.setEmail(email);
			Patient patient=patientService.selectPatientsDetail(p);
			registration.setPatientAccount(patient.getAccount());
			registration.setPatientName(patient.getUsername());
			registrationService.addRegistrations(registration);
			return ConvergenceAPIUtil.biuldSuccessRespons(true);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
	}
	
	/**
	 * 查询挂号单列表
	 * @param page,Registration
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/registrations/{doctorId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String,Object> getRegistrationsList(Registration registration,Page page,@PathVariable long doctorId ){
		try {
			page.setPageSize(page.getRows());
			page.setPageNo(page.getPage());
			registration.setDoctorId(doctorId);
			Map<String, Object> data=registrationService.selectRegistrationsByPage(registration, page);
			return data;
		} catch (ConvergenceException e) {
			Map<String,Object> result=new HashMap<String, Object>();
			result.put("result", e);
			return result;
		}
	}
	
	/**
	 *查询挂号单详情
	 * @param Registration
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/registrations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean selectRegistrations(Registration registration){
		try {
			Registration returnRegistration=registrationService.selectRegistrationsDetail(registration);
			return ConvergenceAPIUtil.biuldSuccessRespons(returnRegistration);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
	}
	
	/**
	 * 取消预约
	 * @param registration_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/registrations/{registration_id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean cancelRegistration(@PathVariable("registration_id") long registration_id){
		try {
			registrationService.cancelRegistration(registration_id);
			return ConvergenceAPIUtil.biuldSuccessRespons(true);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
		
	}
}
