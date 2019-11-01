package com.pramati.crs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.profiles.dto.CarDTO;

import com.pramati.crs.service.ICarService;


/**
 * This Class provides all CURD operations on the Car entity.
 * Administrator can list out all the cars and he can add a car to any vendor. 
 * 
 * 
 * @author srinivasn
 *
 */

@RestController
@RequestMapping("v1/cars")
public class CarProfileController extends AbstractDataConroller<CarDTO, Long>{


	ICarService carService;
	
	@Autowired
	public CarProfileController(ICarService carService) {
		super(carService);
		this.carService = carService;
	}
	
	@GetMapping("/vendors/{vendorId}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<CarDTO> getCarsList(@PathVariable Long vendorId) {
		return carService.getCarsList(vendorId);
	}

}

