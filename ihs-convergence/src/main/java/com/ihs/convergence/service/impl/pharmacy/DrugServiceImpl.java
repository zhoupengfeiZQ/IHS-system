package com.ihs.convergence.service.impl.pharmacy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.ihs.convergence.dao.PharmacyDao;
import com.ihs.convergence.entity.Drug;
import com.ihs.convergence.service.ProccessQueryPage;
import com.ihs.convergence.service.pharmacy.DrugService;
import com.ihs.convergence.utils.enums.ConvergenceCode;
import com.ihs.convergence.utils.enums.ErrorTypes;
import com.ihs.convergence.utils.exception.ConvergenceDataAccessException;
import com.ihs.convergence.utils.exception.ConvergenceDataTransferException;
import com.ihs.convergence.utils.page.Page;
import com.ihs.convergence.utils.page.PageUtils;


@Service
public class DrugServiceImpl implements DrugService{
	@Autowired
	private PharmacyDao pharmacyDao;

	@Autowired
	private ProccessQueryPage proccessQueryPage;
	
	public Map<String, Object> selectDrugsByPage(Drug drug, Page page) {
	
		try {
			if (page.getPageNo() == null || page.getPageSize() == null) {
				page.setPageNo(1);
				page.setPageSize(5);
			}
			PageUtils.page(page);
			List<Drug> list=pharmacyDao.selectDrug(drug);
			Map<String,Object> map = proccessQueryPage.proccess(list);
			Map<String,Object> data=new HashMap<String, Object>();
			data.put("rows", list);
			data.put("total",map.get("total") );
			return data;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.PHARMACY_QUERY_ERROR.getType(), e.getMessage(), e);
		}
	}
	
	@Transactional
	public boolean insertDrugs(Drug drug) {
		if(StringUtils.isEmpty(drug.getDrugName())){
			throw new ConvergenceDataTransferException(ConvergenceCode.NULL_PARAM_ERROR.getCode(), ErrorTypes.PHARMACY_INSERT_ERROR.getType(), ConvergenceCode.NULL_PARAM_ERROR.getMessage());
		}
		try {
			pharmacyDao.insertDrug(drug);
			return true;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.PHARMACY_INSERT_ERROR.getType(), e.getMessage(), e);
		}
		
	}

	@Transactional
	public boolean deleteDrugs(Drug drug) {
		try {
			pharmacyDao.deleteDrug(drug);
			return true;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.PHARMACY_DELETE_ERROR.getType(), e.getMessage(), e);
		}
		
	}

	@Transactional
	public boolean updateDrugs(Drug drug) {
		try {
			pharmacyDao.updateDrug(drug);
			return true;
		} catch (Exception e) {
			throw new ConvergenceDataAccessException(ConvergenceCode.INNER_ERROR.getCode(), ErrorTypes.PHARMACY_UPDATE_ERROR.getType(), e.getMessage(), e);
		}
		
	}

}
