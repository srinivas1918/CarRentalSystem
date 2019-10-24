package com.pramati.crs.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.profiles.dto.CarDTO;

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

}
