package com.ihs.convergence.utils.page;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * 项目名 ihs
 * Page类的相关信息，
 * 自定义输出信息的格式,查看
 * {@link ProccessQueryPage.java} 进行分页输出处理
 * 
 * @author  pengfei.zhou
 * @date 2017年1月20日 
 */
public class Page implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8002715636925787343L;
	@JsonProperty(value="page_no")
	/**页码*/
	private Integer pageNo;
	@JsonProperty(value="page_size")
	/**每页显示条数*/
	private Integer pageSize;
	@JsonProperty(value="total_pages")
	/**总页数*/
	private Integer totalPages;
	@JsonProperty(value="total_elements")
	/**总条数*/
	private Integer totalElements;
	@JsonProperty(value="number_elements")
	/**当页总条数*/
	private Integer numberElements;
	
	private  int page=1;//当前�? easyui必须是此名称
	private int rows=5;//跨度  easyui必须是此名称

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Integer totalElements) {
		this.totalElements = totalElements;
	}

	public Integer getNumberElements() {
		return numberElements;
	}

	public void setNumberElements(Integer numberElements) {
		this.numberElements = numberElements;
	}
	
}
