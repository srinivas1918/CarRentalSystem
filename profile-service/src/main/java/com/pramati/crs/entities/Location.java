package com.pramati.crs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CRS_LOCATONS")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOCATION_ID")
	private Integer id;
	
	@Column(name = "LOCATION_NAME")
	private String locationName;
	
	@Column(name = "CITY_ID")
	private Integer cityId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	
}
