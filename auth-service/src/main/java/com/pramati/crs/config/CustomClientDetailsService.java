package com.pramati.crs.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import com.pramati.crs.repository.ClientDetailsRepository;

@Configuration
public class CustomClientDetailsService implements ClientDetailsService {

	@Autowired
	private ClientDetailsRepository cientDetailsRepository;

	@Override
	public ClientDetails loadClientByClientId(String clientId) {
		Optional<com.pramati.crs.config.entity.ClientDetails> userProfile = cientDetailsRepository
				.findById(clientId);

		if (userProfile.isPresent()) {
			com.pramati.crs.config.entity.ClientDetails details = userProfile.get();
			BaseClientDetails clientDetails = new BaseClientDetails();
			clientDetails.setClientId(details.getClientId());
			clientDetails.setAuthorizedGrantTypes(details.getAuthorizedGrantTypes());
			clientDetails.setAccessTokenValiditySeconds(details.getAccessTokenValiditySeconds());
			clientDetails.setRefreshTokenValiditySeconds(details.getRefreshTokenValiditySeconds());
			clientDetails.setClientSecret(details.getClientSecret());
			clientDetails.setScope(details.getScopes());
			if (details.isAutoApproveScopes()) {
				clientDetails.setAutoApproveScopes(details.getScopes());
			}
			return clientDetails;
		} else {
			throw new NoSuchClientException("No client with requested clientId: " + clientId);
		}
	}
}
