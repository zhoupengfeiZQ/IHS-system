package com.ihs.convergence.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class Drug implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 2103279544115482220L;

	@JsonSerialize(using=ToStringSerializer.class)
	@JsonProperty(value="drug_id")
	private long drugId;
	
	@JsonProperty(value="drug_name")
	private String drugName;
	
	private String composition;
	
	@JsonSerialize(using=ToStringSerializer.class)
	private float price;
	
	@JsonProperty(value="package_unit")
	private String packageUnit;
	
	
	private String efficacy;
	
	private String matters;
	
	private String nature;
	
	private String label;
	
	@JsonSerialize(using=ToStringSerializer.class)
	private long number;
	
	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public long getDrugId() {
		return drugId;
	}
	
	public void setDrugId(long drugId) {
		this.drugId = drugId;
	}
	
	public String getDrugName() {
		return drugName;
	}
	
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	
	
	public String getComposition() {
		return composition;
	}
	
	public void setComposition(String composition) {
		this.composition = composition;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getPackageUnit() {
		return packageUnit;
	}
	
	public void setPackageUnit(String packageUnit) {
		this.packageUnit = packageUnit;
	}
	
	
	public String getEfficacy() {
		return efficacy;
	}
	
	public void setEfficacy(String efficacy) {
		this.efficacy = efficacy;
	}
	
	public String getMatters() {
		return matters;
	}
	
	public void setMatters(String matters) {
		this.matters = matters;
	}
	
	public String getNature() {
		return nature;
	}
	
	public void setNature(String nature) {
		this.nature = nature;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	

}
