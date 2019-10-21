package com.pramati.crs.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pramati.crs.dto.NewFareDTO;
import com.pramati.crs.dto.FareDTO;
import com.pramati.crs.dto.MessageDTO;
import com.pramati.crs.entity.Fare;
import com.pramati.crs.exception.APIException;
import com.pramati.crs.repository.FareRepository;
import com.pramati.crs.service.FareService;

@Service
public class FareServiceImpl implements FareService {

	private FareRepository fareRepository;

	public FareServiceImpl(FareRepository fareRepository) {
		this.fareRepository = fareRepository;
	}

	@Override
	public FareDTO getFare(String vehicleCategory, String vehicleType, long vendorId) {
		Fare fare = fareRepository.findByVehicleCategoryAndVehicleTypeAndVendorIdAndIsActive(vehicleCategory,
				vehicleType, vendorId, true);

		if (null == fare) {
			throw new APIException("No result found", HttpStatus.NOT_FOUND);
		}
		return new FareDTO(fare.getPricePerDay());
	}

	@Override
	public MessageDTO addNewFare(NewFareDTO newFareDto) {

		Fare fare = new Fare();
		fare.setVehicleCategory(newFareDto.getVehicleCategory());
		fare.setVehicleType(newFareDto.getVehicleType());
		fare.setVendorId(newFareDto.getVendorId());
		fare.setEffectiveFrom(newFareDto.getEffectiveFrom());
		fare.setPricePerDay(newFareDto.getPricePerDay());

		fareRepository.save(fare);
		return new MessageDTO("New fare added successfully");
	}

}
