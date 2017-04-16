package com.ihs.convergence.service.impl.person;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.ihs.convergence.dao.PatientDao;
import com.ihs.convergence.entity.Patient;
import com.ihs.convergence.service.ProccessQueryPage;
import com.ihs.convergence.service.person.PatientService;
import com.ihs.convergence.utils.enums.ConvergenceCode;
import com.ihs.convergence.utils.enums.ErrorTypes;
import com.ihs.convergence.utils.exception.ConvergenceDataAccessException;
import com.ihs.convergence.utils.exception.ConvergenceDataTransferException;



@Service
public class PatientServiceImpl implements PatientService{
	@Autowired
	private PatientDao patientDao;

	@Autowired
	private ProccessQueryPage proccessQueryPage;
	

	public Patient selectPatientsDetail(Patient patient) {
		try {
		return	patientDao.selectPatientDetail(patient);
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.PATIENT_QUERY_ERROR.getType(), e.getMessage(), e);
		}
		
	}
	
	@Transactional
	public boolean insertPatients(Patient patient) {
		if(StringUtils.isEmpty(patient.getPassword())||StringUtils.isEmpty(patient.getEmail())){
			throw new ConvergenceDataTransferException(ConvergenceCode.NULL_PARAM_ERROR.getCode(), ErrorTypes.PATIENT_INSERT_ERROR.getType(), ConvergenceCode.NULL_PARAM_ERROR.getMessage());
		}
		try {
			patientDao.insertPatient(patient);
			return true;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.PATIENT_INSERT_ERROR.getType(), e.getMessage(), e);
		}
		
	}


	@Transactional
	public boolean updatePatients(Patient patient) {
		try {
			patientDao.updatePatient(patient);
			return true;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.PATIENT_UPDATE_ERROR.getType(), e.getMessage(), e);
		}
		
	}




}
