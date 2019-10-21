package com.pramati.crs.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pramati.crs.dto.FareDTO;
import com.pramati.crs.dto.NewFareDTO;
import com.pramati.crs.entity.Fare;
import com.pramati.crs.exception.APIException;
import com.pramati.crs.repository.FareRepository;
import com.pramati.crs.service.FareService;
import com.pramati.crs.util.FareConverter;

@Service
public class FareServiceImpl implements FareService {

	private FareRepository fareRepository;

	public FareServiceImpl(FareRepository fareRepository) {
		this.fareRepository = fareRepository;
	}

	@Override
	public FareDTO getActiveFare(String carCategory, String carType, long vendorId) {
		Fare fare = fareRepository.findByCarCategoryAndCarTypeAndVendorIdAndIsActive(carCategory,
				carType, vendorId, true);

		if (null == fare) {
			throw new APIException("No result found", HttpStatus.NOT_FOUND);
		}
		return FareConverter.mapFareToDTO(fare);
	}

	@Override
	public FareDTO addNewFare(NewFareDTO newFareDto) {

		Fare fare = new Fare();
		fare.setCarCategory(newFareDto.getCarCategory());
		fare.setCarType(newFareDto.getCarType());
		fare.setVendorId(newFareDto.getVendorId());
		fare.setEffectiveFrom(newFareDto.getEffectiveFrom());
		fare.setPricePerDay(newFareDto.getPricePerDay());

		fare = fareRepository.save(fare);
		
		return FareConverter.mapFareToDTO(fare);
	}

	@Override
	public List<FareDTO> getAllFaresForVendor(long vendorId) {
		
		List<Fare> vendorFares = fareRepository.findByVendorIdOrderByEffectiveFromDesc(vendorId);
		
		List<FareDTO> vendorFareDtos = vendorFares.stream().map(FareConverter::mapFareToDTO).collect(Collectors.toList());
		
		return vendorFareDtos;
	}

}
