package com.pramati.crs.resource;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.provider.endpoint.CheckTokenEndpoint;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pramati.crs.service.AuthService;

/**
 * 
 * @author manikanth
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthenticationResourceTest {

	@InjectMocks
	private AuthenticationResource resource;

	@Mock
	private AuthService service;

	@Mock
	private TokenEndpoint tokenEndpoint;

	@Mock
	private CheckTokenEndpoint checkTokenEndpoint;

	private MockMvc mockMvc;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(resource).build();
	}

	@Test
	public void testPostAccessToken() throws Exception {
		
	}

	@Test
	public void testLogout() throws Exception {
		when(service.userLogout(any(HttpServletRequest.class))).thenReturn(true);

		mockMvc.perform(delete("/user/logout").contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk());
		verify(service).userLogout(any(HttpServletRequest.class));
	}

	@Test
	public void testLogout400() throws Exception {
		when(service.userLogout(any(HttpServletRequest.class))).thenReturn(false);

		mockMvc.perform(delete("/user/logout").contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().is(400));
		verify(service).userLogout(any(HttpServletRequest.class));
	}

	@Test
	public void testValidateToken() throws Exception {
		when(checkTokenEndpoint.checkToken("token")).thenReturn(new HashMap<>());
		MvcResult result = mockMvc.perform(
				get("/user/validateToken").contentType(MediaType.APPLICATION_JSON_UTF8).param("accessToken", "token"))
				.andReturn();
		Map<String, ?> map = new ObjectMapper().readValue(result.getResponse().getContentAsString(),
				new TypeReference<Map<String, ?>>() {
				});
		assertEquals(new HashMap<>(), map);
		verify(checkTokenEndpoint).checkToken("token");
	}

}
