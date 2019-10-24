package com.pramati.crs.fare.util;

import org.springframework.stereotype.Component;

import com.pramati.crs.fare.dto.FareDTO;
import com.pramati.crs.fare.entity.Fare;

/**
 * Converter class for fare object conversions
 * 
 * @author ashishr
 *
 */
@Component
public class FareConverter {

	/**
	 * static menthod to convert fare object to fate dto object
	 * 
	 * @param fare The fare object
	 * @return The fate dto object
	 */
	public static FareDTO mapFareToDTO(Fare fare) {

		FareDTO fareDTO = new FareDTO();

		fareDTO.setFareId(fare.getFareId());
		fareDTO.setCarCategory(fare.getCarCategory());
		fareDTO.setCarType(fare.getCarType());
		fareDTO.setEffeciveFrom(fare.getEffectiveFrom());
		fareDTO.setEffectiveUpto(fare.getEffectiveUpto());
		fareDTO.setFare(fare.getPricePerDay());
		fareDTO.setVendorId(fare.getVendorId());
		fareDTO.setActive(fare.isActive());

		return fareDTO;
	}
}
