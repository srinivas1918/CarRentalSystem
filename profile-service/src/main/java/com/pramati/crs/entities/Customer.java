package com.pramati.crs.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pramati.crs.constants.Gender;

@Entity
@Table(name = "CRS_CUSTOMER")
public class Customer {

	@Id
	@Column(name = "CUSTOMER_ID")
	private Long id;
	
	@Column(name = "CUSTOMER_NAME")
	private String customerName;
	
	@Column(name = "CUSTOMER_AGE")
	private Integer customerAge;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "CUSTOMER_GENDER")
	private Gender customerGender;
	
	@Column(name = "CUSTOMER_PHONE")
	private String customerPhone;
	
	@Column(name = "CUSTOMER_EMAIL")
	private String customerEmail;
	
	@Column(name = "CUSTOMER_ADDRESS")
	private String customerAddress;
	
	@Column(name = "CUSTOMER_LIECENCE")
	private String customerLicence;
	
	@Column(name = "CUSTOMER_PAN")
	private String customerPAN;
	
	@Column(name = "CUSTOMER_ADHAAR")
	private String customerAdhaar;
	
	@Column(name = "CUSTOMER_REG_DATE")
	private Date customerRegDate;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(Integer customerAge) {
		this.customerAge = customerAge;
	}

	public Gender getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(Gender customerGender) {
		this.customerGender = customerGender;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	
	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerLicence() {
		return customerLicence;
	}

	public void setCustomerLicence(String customerLicence) {
		this.customerLicence = customerLicence;
	}

	public String getCustomerPAN() {
		return customerPAN;
	}

	public void setCustomerPAN(String customerPAN) {
		this.customerPAN = customerPAN;
	}

	public String getCustomerAdhaar() {
		return customerAdhaar;
	}

	public void setCustomerAdhaar(String customerAdhaar) {
		this.customerAdhaar = customerAdhaar;
	}

	public void setCustomerRegDate(Date customerRegDate) {
		this.customerRegDate = customerRegDate;
	}
	
	public Date getCustomerRegDate() {
		return customerRegDate;
	}
}
