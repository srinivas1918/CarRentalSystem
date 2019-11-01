package com.pramati.crs.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pramati.crs.entity.ClientDetails;
import com.pramati.crs.repository.ClientDetailsRepository;

/**
 * 
 * @author manikanth
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ClientDetailsServiceImplTest {

	@InjectMocks
	private ClientDetailsServiceImpl service;

	@Mock
	private ClientDetailsRepository repository;

	@Mock
	private BCryptPasswordEncoder encoder;

	@Test
	public void testCreateClient() throws Exception {
		ClientDetails details = new ClientDetails();
		ClientDetails details1 = new ClientDetails();
		details1.setClientId("clientId");
		details.setClientId("clientId");
		details.setClientSecret("clientSecret");
		details1.setClientSecret("encodedSecret");
		when(repository.findById("clientId")).thenReturn(Optional.empty());
		when(repository.save(details1)).thenReturn(details1);
		when(encoder.encode("clientSecret")).thenReturn("encodedSecret");

		service.createClient(details);

		verify(repository).findById("clientId");
		verify(repository).save(details);
		verify(encoder).encode("clientSecret");
	}

	@Test(expected = Exception.class)
	public void testCreateException() throws Exception {
		ClientDetails details = new ClientDetails();
		details.setClientId("clientId");
		details.setClientSecret("clientSecret");
		when(repository.findById("clientId")).thenReturn(Optional.of(details));

		service.createClient(details);

		verify(repository).findById("clientId");
	}

}
