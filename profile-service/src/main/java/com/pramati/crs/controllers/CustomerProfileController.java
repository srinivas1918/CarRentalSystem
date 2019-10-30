package com.pramati.crs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.profiles.dto.CustomerDTO;
import com.pramati.crs.service.ICustomerService;

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
	
	@Autowired
	public CustomerProfileController(ICustomerService customerService) {
		super(customerService);
	}
}
