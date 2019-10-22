package com.pramati.crs.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.profiles.dto.CustomerDTO;

/**
 * 
 * @author srinivas nalla
 * @version 1.0.0
 * 
 * Exposes the API for CRUD operations for Customers
 */
@RestController
@RequestMapping("v1/customers")
public class CustomerProfileController extends AbstractDataConroller<CustomerDTO, Long>{
}
