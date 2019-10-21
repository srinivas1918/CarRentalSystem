package com.pramati.crs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.crs.entity.Fare;

@Repository
public interface FareRepository extends JpaRepository<Fare, Long>{

	public Fare findByCarCategoryAndCarTypeAndVendorIdAndIsActive(String carCategory, String carType, long vendorId, boolean isActive);

	public List<Fare> findByVendorIdOrderByEffectiveFromDesc(long vendorId);
}
