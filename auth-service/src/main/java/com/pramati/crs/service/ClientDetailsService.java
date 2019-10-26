package com.pramati.crs.service;

import com.pramati.crs.entity.ClientDetails;

/**
 * Interface for client related services 
 * 
 * @author manikanth
 */
public interface ClientDetailsService {

	public abstract ClientDetails createClient(ClientDetails clientDetails) throws Exception;
}
