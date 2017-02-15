package com.ihs.convergence.entity;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1789805062900598852L;

	private int id;
	
	private String name;
	
	private String sex;
	
	private String depart;
	
	private String position;
	
	private int authority;
	
	private String phone;
	
	private Date hiredate;
	
	private Date leavedate;
	
	private String status;
	
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Date getLeavedate() {
		return leavedate;
	}
	public void setLeavedate(Date leavedate) {
		this.leavedate = leavedate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
