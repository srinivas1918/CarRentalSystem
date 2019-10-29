package com.pramati.crs.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author manikanth
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthServiceImplTest {

	@InjectMocks
	private AuthServiceImpl service;

	@Mock
	private DefaultTokenServices tokenServices;

	@Test
	public void testUserLogout() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getHeader("Authorization")).thenReturn("Bearer accessToken");
		when(tokenServices.revokeToken("accessToken")).thenReturn(true);

		assertEquals(true, service.userLogout(request));
	}

	@Test
	public void testUserLogoutFalse() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getHeader("Authorization")).thenReturn(null);

		assertEquals(false, service.userLogout(request));
	}

	@Test
	public void testUserLogoutFalseNoBearer() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getHeader("Authorization")).thenReturn("accessToken");

		assertEquals(false, service.userLogout(request));
	}

}
