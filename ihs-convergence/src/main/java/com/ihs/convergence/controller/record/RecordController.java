package com.ihs.convergence.controller.record;
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
import com.ihs.convergence.entity.Record;
import com.ihs.convergence.entity.Registration;
import com.ihs.convergence.service.person.PatientService;
import com.ihs.convergence.service.record.RecordService;
import com.ihs.convergence.service.registration.RegistrationService;
import com.ihs.convergence.utils.CommonUtil;
import com.ihs.convergence.utils.ConvergenceAPIUtil;
import com.ihs.convergence.utils.DateUtils;
import com.ihs.convergence.utils.bean.ResponseBaseBean;
import com.ihs.convergence.utils.exception.ConvergenceException;
import com.ihs.convergence.utils.gen.Snowflake;
import com.ihs.convergence.utils.page.Page;




/**
 * 
 * @author pengfei.zhou
 * @date 2017年4月10日
 */


@RestController
@RequestMapping(value=CommonUtil.IHS_URL_PREFIX)
public class RecordController {
	@Autowired
	private RecordService recordService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private Snowflake snowflake;
	
	/**
	 * 查询病历列表信息
	 * @param page,	Record
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/records", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String,Object> getRecords(Record record,Page page ){
		try {
			page.setPageSize(page.getRows());
			page.setPageNo(page.getPage());
			Map<String, Object> data=recordService.selectRecordsByPage(record, page);
			return data;
		} catch (ConvergenceException e) {
			Map<String,Object> result=new HashMap<String, Object>();
			result.put("result", e);
			return result;
		}
	}

	
	/**
	 * 病历基本信息
	 * @param registration_id
	 * @return record
	 */
	@ResponseBody
	@RequestMapping(value = "/records/{registration_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean getRecordBase(@PathVariable("registration_id") long registration_id){
		try {
			Record record=new Record();
			Registration reg=registrationService.selectRegistrationById(registration_id);
			if(reg!=null){
				record.setRegistrationId(registration_id);
				record.setName(reg.getPatientName());
				record.setAccount(reg.getPatientAccount());
				record.setAccount(reg.getPatientAccount());
				record.setDepart(reg.getDepart());
				record.setDoctor(reg.getDoctor());
				record.setDoctorId(reg.getDoctorId());
				Patient p=new Patient();
				p.setAccount(reg.getPatientAccount());
				Patient returnPatient= patientService.selectPatientsDetail(p);
				if(returnPatient!=null){
					record.setAge(returnPatient.getAge());
					record.setHistory(returnPatient.getHistory());
				}
			}
			return ConvergenceAPIUtil.biuldSuccessRespons(record);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
	}
	
	
	
	/**
	 * 新建病历
	 * @param Record
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/records", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseBaseBean newRecords(@RequestBody Record record){
		try {
			record.setRecordId(snowflake.next());
			record.setDate(DateUtils.getDefaultCurrentStrDate());
			recordService.insertRecords(record);
			return ConvergenceAPIUtil.biuldSuccessRespons(true);
		} catch (ConvergenceException e) {
			return ConvergenceAPIUtil.biuldErrorRespons(e);
		}
		
	}
	
	
}