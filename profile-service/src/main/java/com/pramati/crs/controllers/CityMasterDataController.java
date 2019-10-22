package com.pramati.crs.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.profiles.dto.CityDTO;

@RestController
@RequestMapping("v1/cities")
public class CityMasterDataController extends AbstractDataConroller<CityDTO, Integer>{

}
