package com.pramati.crs.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.service.CustomerService;
import com.pramati.crs.vo.UserVo;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

	@Autowired
	private CustomerService userProfileService;

	@RequestMapping(method = RequestMethod.POST, value = "/")
	public String createCustomer(@RequestBody UserVo user) throws Exception {
		userProfileService.createCustomer(user);
		return "Customer added Successfully";
	}
}
