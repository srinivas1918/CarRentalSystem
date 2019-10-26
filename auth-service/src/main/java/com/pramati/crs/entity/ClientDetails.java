package com.pramati.crs.entity;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ClientDetails")
@Entity
public class ClientDetails {

	@Id
	private String clientId;

	private String clientSecret;

	@ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
	private Set<String> scopes;

	@ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
	private Set<String> authorizedGrantTypes;

	private boolean autoApproveScopes;

	private Integer accessTokenValiditySeconds;

	private Integer refreshTokenValiditySeconds;

	public String getClientId() {
		return clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public Set<String> getScopes() {
		return scopes;
	}

	public void setScopes(Set<String> scopes) {
		this.scopes = scopes;
	}

	public Set<String> getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	public void setAuthorizedGrantTypes(Set<String> authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}

	public boolean isAutoApproveScopes() {
		return autoApproveScopes;
	}

	public void setAutoApproveScopes(boolean autoApproveScopes) {
		this.autoApproveScopes = autoApproveScopes;
	}

	public Integer getAccessTokenValiditySeconds() {
		return accessTokenValiditySeconds;
	}

	public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
		this.accessTokenValiditySeconds = accessTokenValiditySeconds;
	}

	public Integer getRefreshTokenValiditySeconds() {
		return refreshTokenValiditySeconds;
	}

	public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
		this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

}
