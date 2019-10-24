package com.pramati.crs.service;

import com.pramati.crs.dto.UserDTO;

/**
 * Interface for customer services
 * 
 * @author manikanth
 */
public interface CustomerService {

	public abstract void createCustomer(UserDTO user) throws Exception;

}
