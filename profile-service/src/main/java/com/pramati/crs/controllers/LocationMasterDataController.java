package com.pramati.crs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.profiles.dto.LocationDTO;
import com.pramati.crs.service.ILocationService;

/**
 * 
 * @author srinivas nalla
 * @version 1.0.0
 * 
 * Exposes the api related to locations
 *
 */
@RestController
@RequestMapping("/v1/locations")
public class LocationMasterDataController extends AbstractDataConroller<LocationDTO, Integer >{

	@Autowired
	public LocationMasterDataController(ILocationService locationService) {
		super(locationService);
	}

}
