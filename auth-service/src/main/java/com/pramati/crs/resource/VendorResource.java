package com.pramati.crs.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.service.VendorService;
import com.pramati.crs.vo.UserVo;

@RestController
@RequestMapping("/vendors")
public class VendorResource {

	@Autowired
	private VendorService vendorService;

	@RequestMapping(method = RequestMethod.POST, value = "/")
	public String createVendor(@RequestBody UserVo user) throws Exception {
		vendorService.createVendor(user);
		return "Vendor added Successfully";
	}

}
