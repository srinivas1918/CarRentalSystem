package com.pramati.crs.profiles.dto;

import java.util.Date;

import com.pramati.crs.constants.CarStatus;
import com.pramati.crs.constants.CarType;

public class CarDTO {

	private Long id;
	
	private String carModelName;
	
	private CarType carType;
	
	private String carRegistrationNumber;
	
	private Integer seats;
	
	private CarStatus isActive;
	
	private Integer pricePerDay;
	
	private String carColor;
	
	private Long vendorId;
	
	private Integer locationId;
	
	private Date registredOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarModelName() {
		return carModelName;
	}

	public void setCarModelName(String carModelName) {
		this.carModelName = carModelName;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public String getCarRegistrationNumber() {
		return carRegistrationNumber;
	}

	public void setCarRegistrationNumber(String carRegistrationNumber) {
		this.carRegistrationNumber = carRegistrationNumber;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public CarStatus getIsActive() {
		return isActive;
	}

	public void setIsActive(CarStatus isActive) {
		this.isActive = isActive;
	}

	public Integer getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Integer pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Date getRegistredOn() {
		return registredOn;
	}

	public void setRegistredOn(Date registredOn) {
		this.registredOn = registredOn;
	}

}
