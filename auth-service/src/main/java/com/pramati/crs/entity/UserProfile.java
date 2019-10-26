package com.pramati.crs.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

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

}
