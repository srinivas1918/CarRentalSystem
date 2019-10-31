package com.pramati.crs.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author manikanth
 * 
 * interface for feign client calls for auth service token validation
 */

@FeignClient(name = "auth-service", url = "${auth.url}")
public interface AuthServiceTokenValidation {

	@RequestMapping(method = RequestMethod.GET, value = "/user/validateToken")
	public Map<String, ?> validateToken(@RequestHeader("Authorization") String authHeader,
			@RequestParam("accessToken") String accessToken);
}
