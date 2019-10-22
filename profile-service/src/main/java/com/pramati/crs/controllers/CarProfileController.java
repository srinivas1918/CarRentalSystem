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

@RestController
@RequestMapping("v1/vendors/{userId}")
public class CarProfileController {

	@PostMapping("/cars")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void save(@PathVariable Long userId, @RequestBody CarDTO carDTO) {
		// TODO 
		
	}
	
	@GetMapping("/cars")
	@ResponseStatus(code = HttpStatus.OK)
	public List<CarDTO> list(@PathVariable Long userId) {
		// TODO 
		return null;
	}

	@GetMapping("/cars/{carId}")
	@ResponseStatus(code = HttpStatus.OK)
	public CarDTO getCarDetails(@PathVariable Long userId,@PathVariable Long carId) {
		// TODO 
		return null;
	}

}
