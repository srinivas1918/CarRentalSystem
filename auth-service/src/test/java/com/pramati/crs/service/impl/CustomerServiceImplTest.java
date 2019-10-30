package com.pramati.crs.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pramati.crs.dto.UserDTO;
import com.pramati.crs.entity.UserProfile;
import com.pramati.crs.repository.UserProfilesRepository;

/**
 * 
 * @author manikanth
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceImplTest {

	@InjectMocks
	private CustomerServiceImpl service;

	@Mock
	private UserProfilesRepository repository;

	@Mock
	private BCryptPasswordEncoder encoder;

	@Test
	public void testCreateCustomer() throws Exception {
		UserDTO user = new UserDTO("username", "password");
		UserProfile userProfile = new UserProfile("username", "encodedPassword");
		List<String> authorities = new ArrayList<>();
		authorities.add("ROLE_CUST");
		userProfile.setAuthorities(authorities);
		when(repository.findById("username")).thenReturn(Optional.empty());
		when(repository.save(userProfile)).thenReturn(userProfile);
		when(encoder.encode("password")).thenReturn("encodedPassword");
		service.createCustomer(user);
		verify(repository).findById("username");
		verify(repository).save(userProfile);
		verify(encoder).encode("password");
	}

	@Test(expected = Exception.class)
	public void testCreateException() throws Exception {
		UserDTO user = new UserDTO("username", "password");
		UserProfile userProfile = new UserProfile("username", "encodedPassword");
		List<String> authorities = new ArrayList<>();
		authorities.add("ROLE_CUST");
		userProfile.setAuthorities(authorities);
		when(repository.findById("username")).thenReturn(Optional.of(userProfile));
		service.createCustomer(user);
		verify(repository).findById("username");
	}

}
