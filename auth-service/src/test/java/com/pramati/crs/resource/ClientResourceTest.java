package com.pramati.crs.resource;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import com.pramati.crs.entity.ClientDetails;
import com.pramati.crs.service.ClientDetailsService;

/**
 * 
 * @author manikanth
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ClientResourceTest {

	@InjectMocks
	private ClientDetailsResource resource;

	@Mock
	private ClientDetailsService service;

	private MockMvc mockMvc;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(resource).build();
	}

	@Test
	public void testCreateClient() throws Exception {
		ClientDetails details = new ClientDetails();
		when(service.createClient(any(ClientDetails.class))).thenReturn(details);
		byte[] byteData = new ObjectMapper().writeValueAsBytes(details);

		MvcResult result = mockMvc
				.perform(post("/clients/").contentType(MediaType.APPLICATION_JSON_UTF8).content(byteData)).andReturn();

		String response = result.getResponse().getContentAsString();
		assertEquals("Client added Successfully", response);
		verify(service).createClient(details);
	}
}
