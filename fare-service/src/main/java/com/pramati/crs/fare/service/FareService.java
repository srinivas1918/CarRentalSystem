package com.pramati.crs.fare.service;

import java.util.List;

import com.pramati.crs.fare.dto.FareDTO;
import com.pramati.crs.fare.dto.NewFareDTO;

/**
 * Service interface for fare related business logics
 * 
 * @author ashishr
 *
 */
public interface FareService {

	/**
	 * Fetch the current active fare for a vendor for a car type
	 * 
	 * @param carCategory The car category
	 * @param carType     The car type
	 * @param vendorId    The vendor id
	 * @return The fare details
	 */
	public FareDTO getActiveFare(String carCategory, String carType, long vendorId);

	/**
	 * Add a new fare record for a vendor and a car type
	 * 
	 * @param newFareDto The new fare details
	 * @return Newly created fare
	 */
	public FareDTO addNewFare(NewFareDTO newFareDto);

	/**
	 * Fetch all the fares of a vendor
	 * 
	 * @param vendorId The vendor id
	 * @return List of fares
	 */
	public List<FareDTO> getAllFaresForVendor(long vendorId);
}
