package com.pramati.crs.resource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pramati.crs.dto.UserDTO;
import com.pramati.crs.service.AdminService;

/**
 * 
 * @author manikanth
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminResourceTest {

	@InjectMocks
	private AdminResource resource;

	@Mock
	private AdminService service;

	private MockMvc mockMvc;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(resource).build();
	}

	@Test
	public void testCreateAdmin() throws Exception {
		UserDTO user = new UserDTO("username", "password");
		doNothing().when(service).createAdmin(user);
		byte[] byteData = new ObjectMapper().writeValueAsBytes(user);

		MvcResult result = mockMvc
				.perform(post("/admins/").contentType(MediaType.APPLICATION_JSON_UTF8).content(byteData)).andReturn();

		String response = result.getResponse().getContentAsString();
		assertEquals("Admin added Successfully", response);
		verify(service).createAdmin(user);
	}
}
