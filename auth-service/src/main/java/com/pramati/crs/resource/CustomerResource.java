package com.pramati.crs.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.dto.UserDTO;
import com.pramati.crs.service.CustomerService;

/**
 * Rest Controller class for Customers related operation
 * 
 * @author manikanth
 *
 */
@RestController
@RequestMapping("/customers")
public class CustomerResource {

	@Autowired
	private CustomerService userProfileService;

	/**
	 * @param user The customer details to register
	 *
	 * @return the String with success message
	 *
	 * @throws Exception if the customer with given username already exists
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/")
	public String createCustomer(@RequestBody UserDTO user) throws Exception {
		userProfileService.createCustomer(user);
		return "Customer added Successfully";
	}
}
