package com.pramati.crs.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.profiles.dto.LocationDTO;

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

}
