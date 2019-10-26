package com.pramati.crs.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.profiles.dto.CarDTO;
/**
 * 
 * @author srinivas nalla
 * @version 1.0.0
 * 
 * Exposes the API to perform the CRUD operations
 *
 */
@RestController
@RequestMapping("v1/vendors")
public class VendorCarsRelationshipController {

	/**
	 * Save/update the Car of Vendor
	 * 
	 * @param userId : Vendor id
	 * @param carDTO : Car object to be persisted/update
	 */
	@PostMapping("/{userId}/cars")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void save(@PathVariable Long userId, @RequestBody CarDTO carDTO) {
		// TODO 
		
	}
	
	/**
	 * returns list of cars of a Vendor
	 * 
	 * @param userId 
	 * @return: <code>List<CarDTO> </code>
	 */
	@GetMapping("/{userId}/cars")
	@ResponseStatus(code = HttpStatus.OK)
	public List<CarDTO> list(@PathVariable Long userId) {
		// TODO 
		return null;
	}

	/**
	 * returns the <code>CarDTO</code>
	 * 
	 * @param userId 
	 * @param carId
	 * @return <CarDTO>
	 */
	@GetMapping("/{userId}/cars/{carId}")
	@ResponseStatus(code = HttpStatus.OK)
	public CarDTO getCarDetails(@PathVariable Long userId,@PathVariable Long carId) {
		// TODO 
		return null;
	}

}
