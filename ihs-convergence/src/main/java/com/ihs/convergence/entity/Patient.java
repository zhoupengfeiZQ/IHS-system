package com.ihs.convergence.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class Patient implements Serializable {
	/**
	 * @date:2017/3/9
	 * @author pengfei.zhou
	 */
	private static final long serialVersionUID = 7518807156917938700L;

	@JsonSerialize(using=ToStringSerializer.class)
	private long account;

	private String password;

	private String username;

	@JsonSerialize(using=ToStringSerializer.class)
	@JsonProperty(value="id_card")
	private long idCard;

	private String email;

	private String country;

	private String nation;

	private String address;

	@JsonProperty(value="marital_status")
	private String maritalStatus;

	@JsonSerialize(using=ToStringSerializer.class)
	private int age;
	
	private String sex;

	private String phone;
	
	private String history;

	private String authority;

	public long getAccount() {
		return account;
	}

	public void setAccount(long account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public long getIdCard() {
		return idCard;
	}

	public void setIdCard(long idCard) {
		this.idCard = idCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
