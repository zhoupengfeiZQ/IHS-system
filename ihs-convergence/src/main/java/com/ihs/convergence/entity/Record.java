package com.ihs.convergence.entity;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class Record implements Serializable{
/**
	 * 病历
	 */
	private static final long serialVersionUID = 2103279544115482220L;

	@JsonSerialize(using=ToStringSerializer.class)
	@JsonProperty(value="registration_id")
	private long registrationId;
	
	@JsonSerialize(using=ToStringSerializer.class)
	@JsonProperty(value="record_id")
	private long recordId;
	
	private String name;
	
	@JsonSerialize(using=ToStringSerializer.class)
	private long account;
	
	private int age;
	
	private String depart;
	
	private String history;
	
	private String complain;
	
	private String result;
	
	private String suggestion;
	
	private String prescription;
	
	private String date;
	
	@JsonSerialize(using=ToStringSerializer.class)
	@JsonProperty(value="doctor_id")
	private long doctorId;
	
	private String doctor;

	public long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(long registrationId) {
		this.registrationId = registrationId;
	}

	public long getRecordId() {
		return recordId;
	}

	public void setRecordId(long recordId) {
		this.recordId = recordId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public long getAccount() {
		return account;
	}

	public void setAccount(long account) {
		this.account = account;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getComplain() {
		return complain;
	}

	public void setComplain(String complain) {
		this.complain = complain;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	


}
