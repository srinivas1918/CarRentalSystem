package com.pramati.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.crs.entity.Fare;

@Repository
public interface FareRepository extends JpaRepository<Fare, Long>{

	public Fare findByVehicleCategoryAndVehicleTypeAndVendorIdAndIsActive(String vehicleCategory, String vehicleType, long vendorId, boolean isActive);

}
