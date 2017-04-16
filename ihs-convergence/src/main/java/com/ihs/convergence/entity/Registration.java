package com.ihs.convergence.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class Registration implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5081961554811156542L;

	@JsonSerialize(using=ToStringSerializer.class)
	@JsonProperty(value="registration_id")
	private long registrationId;
	
	private String depart;
	
	@JsonSerialize(using=ToStringSerializer.class)
	@JsonProperty(value="doctor_id")
	private long doctorId;
	
	private String doctor;
	
	@JsonProperty(value="patient_name")
	private String patientName;
	
	@JsonSerialize(using=ToStringSerializer.class)
	@JsonProperty(value="patient_account")
	private long patientAccount;
	
	private String time;
	
	@JsonSerialize(using=ToStringSerializer.class)
	@JsonProperty(value="registration_index")
	private int registrationIndex;
	

	private String status;

	public long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(long registrationId) {
		this.registrationId = registrationId;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
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


	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public long getPatientAccount() {
		return patientAccount;
	}

	public void setPatientAccount(long patientAccount) {
		this.patientAccount = patientAccount;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getRegistrationIndex() {
		return registrationIndex;
	}

	public void setRegistrationIndex(int registrationIndex) {
		this.registrationIndex = registrationIndex;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
