package com.pramati.crs.fare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.crs.fare.entity.Fare;

/**
 * Repository class to do database related operations
 * 
 * @author ashishr
 *
 */
@Repository
public interface FareRepository extends JpaRepository<Fare, Long> {

	/**
	 * Fetch active fare by the car type, category and vendor
	 * 
	 * @param carCategory The car category
	 * @param carType     The car type
	 * @param vendorId    The vendor Id
	 * @param isActive    the active flag
	 * @return The Active fare for the vendor for the car type
	 */
	public Fare findByCarCategoryAndCarTypeAndVendorIdAndIsActive(String carCategory, String carType, long vendorId,
			boolean isActive);

	/**
	 * Fetch all the fares for a vendor and order by effective date decreasing
	 * 
	 * @param vendorId The vendor id
	 * @return List of fares
	 */
	public List<Fare> findByVendorIdOrderByEffectiveFromDesc(long vendorId);
}
