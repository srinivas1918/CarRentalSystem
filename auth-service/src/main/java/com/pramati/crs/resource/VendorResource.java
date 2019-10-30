package com.pramati.crs.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.dto.UserDTO;
import com.pramati.crs.service.VendorService;

/**
 * Rest Controller class for Vendors related operation
 * 
 * @author manikanth
 *
 */
@RestController
@RequestMapping("/vendors")
public class VendorResource {

	@Autowired
	private VendorService vendorService;

	/**
	 * @param user The Vendor details to register
	 *
	 * @return the String with success message
	 *
	 * @throws Exception if the vendor with given username already exists
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/")
	public String createVendor(@RequestBody UserDTO user) throws Exception {
		vendorService.createVendor(user);
		return "Vendor added Successfully";
	}

}
