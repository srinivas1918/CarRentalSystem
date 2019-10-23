package com.pramati.crs.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.service.AdminService;
import com.pramati.crs.vo.UserVo;

@RestController
@RequestMapping("/admins")
public class AdminResource {

	@Autowired
	private AdminService userProfileService;

	@RequestMapping(method = RequestMethod.POST, value = "/")
	public String createAdmin(@RequestBody UserVo user) throws Exception {
		userProfileService.createAdmin(user);
		return "Admin added Successfully";
	}
}
