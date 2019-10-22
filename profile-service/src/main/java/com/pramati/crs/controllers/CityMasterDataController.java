package com.pramati.crs.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.profiles.dto.CityDTO;

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

}
