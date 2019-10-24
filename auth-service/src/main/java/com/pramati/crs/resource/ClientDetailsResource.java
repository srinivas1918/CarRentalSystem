package com.pramati.crs.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.entity.ClientDetails;
import com.pramati.crs.service.ClientDetailsService;

/**
 * Rest Controller class for Clients related operation
 * 
 * @author manikanth
 *
 */
@RestController
@RequestMapping(value = "/clients")
public class ClientDetailsResource {

	@Autowired
	private ClientDetailsService clientDetailsService;

	/**
	 * @param clientDetails The client details to save
	 *
	 * @return the String with success message
	 *
	 * @throws Exception if the client with given clientId already exists
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/")
	public String createClient(@RequestBody ClientDetails clientDetails) throws Exception {
		clientDetailsService.createClient(clientDetails);
		return "Client added Successfully";
	}
}
