package com.pramati.crs.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.profiles.dto.CustomerDTO;

@RestController
@RequestMapping("v1/customers")
public class CustomerProfileController extends AbstractDataConroller<CustomerDTO, Long>{
}
