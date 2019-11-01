package com.pramati.crs.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;


/**
 * Entity class to represent UserProfiles table
 * 
 * @author manikanth
 *
 */
@Entity
@Table(name = "UserProfiles")
public class UserProfile {

	@Id
	private String username;
	private String password;
	@ElementCollection(targetClass = GrantedAuthority.class, fetch = FetchType.EAGER)
	private List<String> authorities;

	public UserProfile() {
		super();
	}

	public UserProfile(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public List<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProfile other = (UserProfile) obj;
		if (authorities == null) {
			if (other.authorities != null)
				return false;
		} else if (!authorities.equals(other.authorities))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
