package com.pramati.crs.fare.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pramati.crs.fare.dto.FareDTO;
import com.pramati.crs.fare.dto.NewFareDTO;
import com.pramati.crs.fare.entity.Fare;
import com.pramati.crs.fare.exception.APIException;
import com.pramati.crs.fare.repository.FareRepository;
import com.pramati.crs.fare.service.FareService;
import com.pramati.crs.fare.util.FareConverter;

/**
 * Service implementation for fare related business logics
 * 
 * @author ashishr
 *
 */
@Service
public class FareServiceImpl implements FareService {

	private FareRepository fareRepository;

	public FareServiceImpl(FareRepository fareRepository) {
		this.fareRepository = fareRepository;
	}

	/**
	 * Fetch active fare for a vendor for a car type
	 */
	@Override
	public FareDTO getActiveFare(String carCategory, String carType, long vendorId) {
		Fare fare = fareRepository.findByCarCategoryAndCarTypeAndVendorIdAndIsActive(carCategory, carType, vendorId,
				true);

		if (null == fare) {
			throw new APIException("No result found", HttpStatus.NOT_FOUND);
		}
		return FareConverter.mapFareToDTO(fare);
	}

	/**
	 * Add new fare for a car type for a vendor
	 */
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

	/**
	 * Fetch all the fares of a vendor
	 */
	@Override
	public List<FareDTO> getAllFaresForVendor(long vendorId) {

		List<Fare> vendorFares = fareRepository.findByVendorIdOrderByEffectiveFromDesc(vendorId);

		List<FareDTO> vendorFareDtos = vendorFares.stream().map(FareConverter::mapFareToDTO)
				.collect(Collectors.toList());

		return vendorFareDtos;
	}

}
