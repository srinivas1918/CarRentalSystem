package com.pramati.crs.service;

import com.pramati.crs.dto.UserDTO;

/**
 * Interface for vendor services
 * 
 * @author manikanth
 */
public interface VendorService {

	public abstract void createVendor(UserDTO user) throws Exception;
}
