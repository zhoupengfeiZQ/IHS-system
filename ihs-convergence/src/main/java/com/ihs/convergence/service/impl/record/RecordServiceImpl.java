package com.ihs.convergence.service.impl.record;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.ihs.convergence.dao.RecordDao;
import com.ihs.convergence.dao.RegistrationDao;
import com.ihs.convergence.entity.Record;
import com.ihs.convergence.service.ProccessQueryPage;
import com.ihs.convergence.service.record.RecordService;
import com.ihs.convergence.utils.enums.ConvergenceCode;
import com.ihs.convergence.utils.enums.ErrorTypes;
import com.ihs.convergence.utils.exception.ConvergenceDataAccessException;
import com.ihs.convergence.utils.exception.ConvergenceDataTransferException;
import com.ihs.convergence.utils.page.Page;
import com.ihs.convergence.utils.page.PageUtils;



@Service
public class RecordServiceImpl implements RecordService{
	@Autowired
	private RecordDao recordDao;
	
	@Autowired
	private RegistrationDao registrationDao;
	

	@Autowired
	private ProccessQueryPage proccessQueryPage;
	

	public Map<String, Object> selectRecordsByPage(Record record, Page page) {
		
		try {
			if (page.getPageNo() == null || page.getPageSize() == null) {
				page.setPageNo(1);
				page.setPageSize(5);
			}
			PageUtils.page(page);
			List<Record> list=recordDao.selectRecord(record);
			Map<String,Object> map = proccessQueryPage.proccess(list);
			Map<String,Object> data=new HashMap<String, Object>();
			data.put("rows", list);
			data.put("total",map.get("total") );
			return data;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.RECORD_QUERY_ERROR.getType(), e.getMessage(), e);
		}
	}
	/*public Patient selectPatientsDetail(Patient patient) {
		try {
		return	patientDao.selectPatientDetail(patient);
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.PATIENT_QUERY_ERROR.getType(), e.getMessage(), e);
		}
		
	}*/
	
	@Transactional
	public boolean insertRecords(Record record) {
		if(StringUtils.isEmpty(record.getResult())||StringUtils.isEmpty(record.getSuggestion())){
			throw new ConvergenceDataTransferException(ConvergenceCode.NULL_PARAM_ERROR.getCode(), ErrorTypes.RECORD_INSERT_ERROR.getType(), ConvergenceCode.NULL_PARAM_ERROR.getMessage());
		}
		try {
			registrationDao.updateStatusById(record.getRegistrationId());
			return	recordDao.insertRecord(record);
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.RECORD_INSERT_ERROR.getType(), e.getMessage(), e);
		}
		
	}


	/*@Transactional
	public boolean updatePatients(Patient patient) {
		try {
			patientDao.updatePatient(patient);
			return true;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.PATIENT_UPDATE_ERROR.getType(), e.getMessage(), e);
		}
		
	}
*/



}
