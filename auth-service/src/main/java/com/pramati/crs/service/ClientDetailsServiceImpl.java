package com.pramati.crs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pramati.crs.config.entity.ClientDetails;
import com.pramati.crs.repository.ClientDetailsRepository;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

	@Autowired
	private ClientDetailsRepository cientDetailsRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public ClientDetails createClient(ClientDetails clientDetails) throws Exception {
		Optional<ClientDetails> existingClientDetails = cientDetailsRepository.findById(clientDetails.getClientId());
		if (existingClientDetails.isPresent()) {
			throw new Exception("Client with clientId " + clientDetails.getClientId() + " already exisis.");
		}
		clientDetails.setClientSecret(encoder.encode(clientDetails.getClientSecret()));
		return cientDetailsRepository.save(clientDetails);
	}

}
