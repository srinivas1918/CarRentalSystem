package com.pramati.crs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.profiles.dto.CityDTO;
import com.pramati.crs.service.ICityService;

/**
 * 
 * @author srinivas nalla
 * @version 1.0.0
 *
 * Exposes the API related to the Cities
 */
@RestController
@RequestMapping("v1/cities")
public class CityMasterDataController extends AbstractDataConroller<CityDTO, Integer>{

	@Autowired
	public CityMasterDataController(ICityService cityService) {
		super(cityService);
	}

}
