package com.ihs.convergence.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class Resignation implements Serializable {
	/**
	 * @date:2017/4/20
	 * @author pengfei.zhou
	 */
	private static final long serialVersionUID = 7518807156917938700L;

	@JsonSerialize(using=ToStringSerializer.class)
	private long id;

	private String name;

	private String number;

	private String depart;
	
	private String reason;
	
	@JsonProperty(value="apply_time")
	private String applyTime;
	
	private String status;
	
	private String approver;
	
	@JsonProperty(value="approval_view")
	private String approvalView;
	
	@JsonProperty(value="approval_time")
	private String approvalTime;

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

	public String getNumber() {
		return number;
	}

	

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getApprovalView() {
		return approvalView;
	}

	public void setApprovalView(String approvalView) {
		this.approvalView = approvalView;
	}

	public String getApprovalTime() {
		return approvalTime;
	}

	public void setApprovalTime(String approvalTime) {
		this.approvalTime = approvalTime;
	}
	
	
	
	
	
	
	
	
}
