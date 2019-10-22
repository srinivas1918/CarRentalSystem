package com.pramati.crs.service;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {

	public abstract boolean userLogout(HttpServletRequest request);
}
