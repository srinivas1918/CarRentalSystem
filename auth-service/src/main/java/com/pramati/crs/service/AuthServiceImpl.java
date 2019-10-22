package com.pramati.crs.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private DefaultTokenServices tokenServices;

	@Override
	public boolean userLogout(HttpServletRequest request) {
		String authorization = request.getHeader("Authorization");
		boolean revokeStatus = false;
		if (authorization != null && authorization.contains("Bearer")) {
			String tokenId = authorization.substring("Bearer".length() + 1);
			revokeStatus = tokenServices.revokeToken(tokenId);
		}
		return revokeStatus;
	}

}
