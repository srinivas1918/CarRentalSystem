package com.pramati.crs.profiles.dto;

import java.util.Date;

import com.pramati.crs.constants.Gender;
import com.pramati.crs.constants.Role;

public class VendorDTO {

	private Long id;
	
	private String vendorName;
	
	private Integer vendorAge;
	
	private Gender vendorGender;
	
	private String vendorPhone;
	
	private String vendorAddress;
	
	private String vendorEmail;
	
	private String vendorPAN;
	
	private String vendorAdhaar;
	
	private String vendorGSTN;
	
	private Date vendorRegDate;
	
	private Role createdBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Integer getVendorAge() {
		return vendorAge;
	}

	public void setVendorAge(Integer vendorAge) {
		this.vendorAge = vendorAge;
	}

	public Gender getVendorGender() {
		return vendorGender;
	}

	public void setVendorGender(Gender vendorGender) {
		this.vendorGender = vendorGender;
	}

	public String getVendorPhone() {
		return vendorPhone;
	}

	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public String getVendorPAN() {
		return vendorPAN;
	}

	public void setVendorPAN(String vendorPAN) {
		this.vendorPAN = vendorPAN;
	}

	public String getVendorAdhaar() {
		return vendorAdhaar;
	}

	public void setVendorAdhaar(String vendorAdhaar) {
		this.vendorAdhaar = vendorAdhaar;
	}

	public String getVendorGSTN() {
		return vendorGSTN;
	}

	public void setVendorGSTN(String vendorGSTN) {
		this.vendorGSTN = vendorGSTN;
	}

	public Date getVendorRegDate() {
		return vendorRegDate;
	}

	public void setVendorRegDate(Date vendorRegDate) {
		this.vendorRegDate = vendorRegDate;
	}

	public Role getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Role createdBy) {
		this.createdBy = createdBy;
	}
	
	
}
