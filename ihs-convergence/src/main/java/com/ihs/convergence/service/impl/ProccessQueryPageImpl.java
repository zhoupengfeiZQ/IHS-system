package com.ihs.convergence.service.impl;


import com.github.pagehelper.PageInfo;
import com.ihs.convergence.service.ProccessQueryPage;
import com.ihs.convergence.utils.page.Page;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProccessQueryPageImpl implements ProccessQueryPage {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, Object> proccess(List<?> queryData) {
		Map<String,Object> map = new HashMap<String,Object>();
		PageInfo pageInfo = new PageInfo(queryData);
		
		Page outputPage = new Page();
		//页码
		outputPage.setPageNo(pageInfo.getPageNum());
		//每页显示条数
		outputPage.setPageSize(pageInfo.getPageSize());
		//总条数
		outputPage.setTotalElements((int)pageInfo.getTotal());
		//总页数
		outputPage.setTotalPages(pageInfo.getPages());
		//当前页有多少条数据
		outputPage.setNumberElements(pageInfo.getSize());
		
		//输出分页
		map.put("page", outputPage);
		//查询的数据
		map.put("data", queryData);
		map.put("total", outputPage.getTotalElements());
		return map;
	}

}
