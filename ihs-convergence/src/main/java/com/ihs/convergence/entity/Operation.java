package com.ihs.convergence.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class Operation implements Serializable {
	/**
	 * @date:2017/4/13
	 * @author pengfei.zhou
	 */
	private static final long serialVersionUID = 7518807156917938700L;

	@JsonSerialize(using=ToStringSerializer.class)
	@JsonProperty(value="operation_id")
	private long operationId;

	private String patient;
	
	@JsonSerialize(using=ToStringSerializer.class)
	private long account;

	private String doctor;
	
	@JsonSerialize(using=ToStringSerializer.class)
	@JsonProperty(value="doctor_id")
	private long doctorId;
	
	@JsonSerialize(using=ToStringSerializer.class)
	@JsonProperty(value="record_id")
	private long recordId;
	
	@JsonProperty(value="doctor_view")
	private String doctorView;
	
	@JsonProperty(value="patient_view")
	private String patientView;
	
	@JsonProperty(value="family_view")
	private String familyView;
	
	@JsonProperty(value="approval_view")
	private String approvalView;
	
	private String approver;
	
	private String status;
	
	private String date;

	public long getOperationId() {
		return operationId;
	}

	public void setOperationId(long operationId) {
		this.operationId = operationId;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public long getAccount() {
		return account;
	}

	public void setAccount(long account) {
		this.account = account;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public long getRecordId() {
		return recordId;
	}

	public void setRecordId(long recordId) {
		this.recordId = recordId;
	}

	

	public String getDoctorView() {
		return doctorView;
	}

	public void setDoctorView(String doctorView) {
		this.doctorView = doctorView;
	}

	public String getPatientView() {
		return patientView;
	}

	public void setPatientView(String patientView) {
		this.patientView = patientView;
	}

	public String getFamilyView() {
		return familyView;
	}

	public void setFamilyView(String familyView) {
		this.familyView = familyView;
	}

	public String getApprovalView() {
		return approvalView;
	}

	public void setApprovalView(String approvalView) {
		this.approvalView = approvalView;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
	
}
