package com.pramati.crs.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CRS_CITIES")
public class City {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CITY_ID")
	@Id
	public Integer id;
	
	@Column(name = "CITY_NAME")
	public String cityName;
	
	@Column(name = "CITY_CREATED_ON")
	public Date createdOn;

	public Integer getId() {
		return id;
	}

	
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	
}
