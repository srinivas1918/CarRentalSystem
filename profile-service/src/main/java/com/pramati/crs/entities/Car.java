package com.pramati.crs.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pramati.crs.constants.CarStatus;
import com.pramati.crs.constants.CarType;

@Entity
@Table(name = "CRS_CARS")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAR_ID")
	private Long id;
	
	@Column(name = "CAR_MODEL_NAME")
	private String carModelName;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "CAR_TYPE")
	private CarType carType;
	
	@Column(name = "CAR_REG_NUMBER")
	private String carRegistrationNumber;
	
	@Column(name = "CAR_SEATS")
	private Integer seats;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "CAR_ACTIVE")
	private CarStatus isActive;
	
	@Column(name = "CAR_PRICE_PER_DAY")
	private Integer pricePerDay;
	
	@Column(name = "CAR_COLOR")
	private String carColor;
	
	@Column(name = "CAR_VENDOR_ID")
	private Long vendorId;
	
	@Column(name = "CAR_LOCATION_ID")
	private Integer locationId;
	
	@Column(name = "CAR_REG_ON")
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
