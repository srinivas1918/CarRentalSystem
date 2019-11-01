package com.pramati.crs.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pramati.crs.constants.Gender;
import com.pramati.crs.constants.Role;

@Entity
@Table(name = "CRS_VENDOR")
public class Vendor {

	@Id
	@Column(name = "VENDOR_ID")
	private Long id;
	
	@Column(name = "VENDOR_NAME")
	private String vendorName;
	
	@Column(name = "VENDOR_AGE")
	private Integer vendorAge;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "VENDOR_GENDER")
	private Gender vendorGender;
	
	@Column(name = "VENDOR_PHONE")
	private String vendorPhone;
	
	@Column(name = "VENDOR_ADDRESS")
	private String vendorAddress;
	
	@Column(name = "VENDOR_EMAIL")
	private String vendorEmail;
	
	@Column(name = "VENDOR_PAN")
	private String vendorPAN;
	
	@Column(name = "VENDOR_ADHAAR")
	private String vendorAdhaar;
	
	@Column(name = "VENDOR_GSTN")
	private String vendorGSTN;
	
	@Column(name = "VENDOR_REG_DATE")
	private Date vendorRegDate;
	
	@Column(name = "VENDOR_CREATED_BY")
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

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	
	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
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
