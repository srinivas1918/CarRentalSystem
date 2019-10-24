package com.pramati.crs.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.dto.UserDTO;
import com.pramati.crs.service.AdminService;

/**
 * Rest Controller class for Admin related operation
 * 
 * @author manikanth
 *
 */
@RestController
@RequestMapping("/admins")
public class AdminResource {

	@Autowired
	private AdminService userProfileService;

	/**
	 * @param user The admin details to register
	 *
	 * @return the String with success message
	 *
	 * @throws Exception if the admin with given username already exists
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/")
	public String createAdmin(@RequestBody UserDTO user) throws Exception {
		userProfileService.createAdmin(user);
		return "Admin added Successfully";
	}
}
