package com.pramati.crs.service;

import com.pramati.crs.dto.UserDTO;

/**
 * Interface for admin services
 * 
 * @author manikanth
 */
public interface AdminService {

	public abstract void createAdmin(UserDTO user) throws Exception;
}
