package com.pramati.crs.util;

import org.springframework.stereotype.Component;

import com.pramati.crs.dto.FareDTO;
import com.pramati.crs.entity.Fare;

@Component
public class FareConverter {

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
