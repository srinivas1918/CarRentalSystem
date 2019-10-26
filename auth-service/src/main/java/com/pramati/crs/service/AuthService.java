package com.pramati.crs.service;

import javax.servlet.http.HttpServletRequest;

/**
 * Interface for auth related services 
 * 
 * @author manikanth
 */
public interface AuthService {

	public abstract boolean userLogout(HttpServletRequest request);
}
