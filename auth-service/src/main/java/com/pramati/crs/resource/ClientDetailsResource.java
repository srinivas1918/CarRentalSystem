package com.pramati.crs.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.config.entity.ClientDetails;
import com.pramati.crs.service.ClientDetailsService;

@RestController
@RequestMapping(value = "/clients")
public class ClientDetailsResource {

	@Autowired
	private ClientDetailsService clientDetailsService;

	@RequestMapping(method = RequestMethod.POST, value = "/")
	public String createClient(@RequestBody ClientDetails clientDetails) throws Exception {
		clientDetailsService.createClient(clientDetails);
		return "Client added Successfully";
	}
}
