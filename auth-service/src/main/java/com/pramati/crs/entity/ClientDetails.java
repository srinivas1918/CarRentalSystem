package com.pramati.crs.entity;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class to represent ClientDetails table
 * 
 * @author manikanth
 *
 */

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientDetails other = (ClientDetails) obj;
		if (accessTokenValiditySeconds == null) {
			if (other.accessTokenValiditySeconds != null)
				return false;
		} else if (!accessTokenValiditySeconds.equals(other.accessTokenValiditySeconds))
			return false;
		if (authorizedGrantTypes == null) {
			if (other.authorizedGrantTypes != null)
				return false;
		} else if (!authorizedGrantTypes.equals(other.authorizedGrantTypes))
			return false;
		if (autoApproveScopes != other.autoApproveScopes)
			return false;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (clientSecret == null) {
			if (other.clientSecret != null)
				return false;
		} else if (!clientSecret.equals(other.clientSecret))
			return false;
		if (refreshTokenValiditySeconds == null) {
			if (other.refreshTokenValiditySeconds != null)
				return false;
		} else if (!refreshTokenValiditySeconds.equals(other.refreshTokenValiditySeconds))
			return false;
		if (scopes == null) {
			if (other.scopes != null)
				return false;
		} else if (!scopes.equals(other.scopes))
			return false;
		return true;
	}

}
