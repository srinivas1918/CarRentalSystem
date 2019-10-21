package com.pramati.crs.service;

import java.util.List;

import com.pramati.crs.dto.FareDTO;
import com.pramati.crs.dto.NewFareDTO;

public interface FareService {

	public FareDTO getActiveFare(String carCategory, String carType, long vendorId);

	public FareDTO addNewFare(NewFareDTO newFareDto);

	public List<FareDTO> getAllFaresForVendor(long vendorId);
}
