package com.pramati.crs.service;

import com.pramati.crs.config.entity.ClientDetails;

public interface ClientDetailsService {

	public abstract ClientDetails createClient(ClientDetails clientDetails) throws Exception;
}
