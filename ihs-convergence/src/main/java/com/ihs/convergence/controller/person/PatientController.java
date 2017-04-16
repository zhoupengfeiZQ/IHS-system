package com.ihs.convergence.controller.person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ihs.convergence.entity.Patient;
import com.ihs.convergence.service.person.PatientService;
import com.ihs.convergence.utils.CommonUtil;
import com.ihs.convergence.utils.ConvergenceAPIUtil;
import com.ihs.convergence.utils.bean.ResponseBaseBean;
import com.ihs.convergence.utils.exception.ConvergenceException;
import com.ihs.convergence.utils.gen.Snowflake;




/**
 * 
 * @author pengfei.zhou
 * @date 2017年3月09日
 */


@RestController
@RequestMapping(value=CommonUtil.IHS_URL_PREFIX)
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private Snowflake snowflake;
	
	/**
	 * 查询患者详细信息
	 * @param patient
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/patients/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean getPatients(@PathVariable("email") String email,Patient patient){
		try {
			patient.setEmail(email);
			Patient returnPatient=patientService.selectPatientsDetail(patient);
			return ConvergenceAPIUtil.biuldSuccessRespons(returnPatient);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
	}
	
	/**
	 * 注册
	 * @param patient
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/patients", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean addPatients(@RequestBody Patient patient){
		try {
			patient.setAccount(snowflake.next());
			patient.setAuthority("3");
			patientService.insertPatients(patient);
			return ConvergenceAPIUtil.biuldSuccessRespons(true);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
	}
	
	/**
	 * 更新患者信息
	 * @param account
	 * @param Patient
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/patients/{email}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean updatePatients(@PathVariable("email") String email,@RequestBody Patient patient){
		try {
			patient.setEmail(email);
			patientService.updatePatients(patient);
			return ConvergenceAPIUtil.biuldSuccessRespons(true);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
		
	}
}