package com.pramati.crs.service;

import com.pramati.crs.dto.NewFareDTO;
import com.pramati.crs.dto.FareDTO;
import com.pramati.crs.dto.MessageDTO;

public interface FareService {

	public FareDTO getFare(String vehicleCategory, String vehicleType, long vendorId);

	public MessageDTO addNewFare(NewFareDTO newFareDto);
}
