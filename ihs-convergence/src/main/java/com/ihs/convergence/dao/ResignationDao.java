package com.ihs.convergence.dao;

import java.util.List;
import com.ihs.convergence.entity.Resignation;


public interface ResignationDao {
	
	public Resignation selectResignationDetail(Resignation resignation);
	
	public List<Resignation> selectResignation(Resignation resignation);
	
	public boolean insertResignation(Resignation resignation);
	
	public boolean updateResignation(Resignation resignation);
}
