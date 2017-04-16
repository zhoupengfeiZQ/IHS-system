package com.ihs.convergence.service.record;

import java.util.Map;

import com.ihs.convergence.entity.Record;
import com.ihs.convergence.utils.page.Page;



public interface RecordService {
	public Map<String, Object> selectRecordsByPage(Record record, Page page);
	
	public boolean insertRecords(Record record);
}
