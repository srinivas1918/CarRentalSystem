package com.pramati.crs.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.dto.FareDTO;
import com.pramati.crs.dto.NewFareDTO;
import com.pramati.crs.service.FareService;

@RestController
@RequestMapping("/fares")
@EnableHypermediaSupport(type = HypermediaType.HAL)
public class FareController {

	private FareService fareService;

	public FareController(FareService fareService) {
		this.fareService = fareService;
	}

	@GetMapping(produces = "application/hal+json")
	public FareDTO getActiveFare(@RequestParam String carCategory, @RequestParam String carType,
			@RequestParam long vendorId) {
		
		FareDTO activeFare = fareService.getActiveFare(carCategory, carType, vendorId);
		
		Link link = linkTo(methodOn(FareController.class).getActiveFare(carCategory, carType, vendorId)).withSelfRel();
		activeFare.add(link);
		
		return activeFare;
	}
	
	@PostMapping(produces = "application/hal+json")
	public FareDTO addNewFare(@RequestBody NewFareDTO newFareDto) {
		
		FareDTO newFare = fareService.addNewFare(newFareDto);
		
		Link link = linkTo(methodOn(FareController.class).addNewFare(newFareDto)).withSelfRel();
		newFare.add(link);
		
		return newFare;
	}
	
	@GetMapping(value = "/vendors/{vendorId}", produces = "application/hal+json")
	public Resources<FareDTO> getAllFaresForVendor(@PathVariable long vendorId) {
		
		List<FareDTO> vendorFares = fareService.getAllFaresForVendor(vendorId);
		
		for (FareDTO fareDTO : vendorFares) {
			Link selfLink = linkTo(methodOn(FareController.class).getActiveFare(fareDTO.getCarCategory(), fareDTO.getCarType(), fareDTO.getVendorId()))
					.withSelfRel();
			fareDTO.add(selfLink);
		}
		
		Link link = linkTo(methodOn(FareController.class).getAllFaresForVendor(vendorId)).withSelfRel();

		Resources<FareDTO> fares = new Resources<>(vendorFares, link);
		return fares;
	}
}