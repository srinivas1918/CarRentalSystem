package com.pramati.crs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.dto.NewFareDTO;
import com.pramati.crs.dto.FareDTO;
import com.pramati.crs.dto.MessageDTO;
import com.pramati.crs.service.FareService;

@RestController
@RequestMapping("/fares")
public class FareController {

	private FareService fareService;

	public FareController(FareService fareService) {
		this.fareService = fareService;
	}

	@GetMapping
	public FareDTO getFare(@RequestParam String vehicleCategory, @RequestParam String vehicleType,
			@RequestParam long vendorId) {
		return fareService.getFare(vehicleCategory, vehicleType, vendorId);
	}
	
	@PostMapping
	public MessageDTO addNewFare(@RequestBody NewFareDTO newFareDto) {
		return fareService.addNewFare(newFareDto);
	}
}