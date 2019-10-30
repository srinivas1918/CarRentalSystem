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
import com.pramati.crs.service.CustomerService;

/**
 * 
 * @author manikanth
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerResourceTest {

	@InjectMocks
	private CustomerResource resource;

	@Mock
	private CustomerService service;

	private MockMvc mockMvc;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(resource).build();
	}

	@Test
	public void testCreateCustomer() throws Exception {
		UserDTO user = new UserDTO("username", "password");
		doNothing().when(service).createCustomer(user);
		byte[] byteData = new ObjectMapper().writeValueAsBytes(user);

		MvcResult result = mockMvc
				.perform(post("/customers/").contentType(MediaType.APPLICATION_JSON_UTF8).content(byteData))
				.andReturn();

		String response = result.getResponse().getContentAsString();
		assertEquals("Customer added Successfully", response);
		verify(service).createCustomer(user);
	}
}
