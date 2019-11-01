package com.pramati.crs.profiles.dto;

import java.util.Date;

import com.pramati.crs.constants.Gender;

public class CustomerDTO {

	private Long id;
	
	private String customerName;
	
	private Integer customerAge;
	
	private Gender customerGender;
	
	private String customerPhone;
	
	private String customerEmail;
	
	private String customerAddress;
	
	private String customerLicence;
	
	private String customerPAN;
	
	private String customerAdhaar;
	
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

	public Date getCustomerRegDate() {
		return customerRegDate;
	}

	public void setCustomerRegDate(Date customerRegDate) {
		this.customerRegDate = customerRegDate;
	}

	
}
