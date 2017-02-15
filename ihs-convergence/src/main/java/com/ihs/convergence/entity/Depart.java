package com.ihs.convergence.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class Depart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7062354460309174246L;
	
	@JsonSerialize(using=ToStringSerializer.class)
	private long id;
	
	private String name;
	
	private String summary;
	
	@JsonSerialize(using=ToStringSerializer.class)
	@JsonProperty(value="create_by")
	private long createBy;
	
	@JsonProperty(value="create_date")
	private String createDate;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(long createBy) {
		this.createBy = createBy;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	

}
