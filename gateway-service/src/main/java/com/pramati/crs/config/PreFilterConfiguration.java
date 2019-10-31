package com.pramati.crs.config;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.pramati.crs.feign.AuthServiceTokenValidation;
import com.pramati.crs.response.ErrorResponse;

/**
 * @author manikanth
 * 
 *         class for intercepting the calls and validating the token
 */

@Component
public class PreFilterConfiguration extends ZuulFilter {

	@Autowired
	private AuthServiceTokenValidation tokenValidation;

	@Value("${auth.client}")
	private String clientId;

	@Value("${auth.secret}")
	private String clientSecret;

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String reqUri = request.getRequestURI();
		String token = request.getHeader("Authorization");
		boolean validUser = false;
		if (reqUri.startsWith("/search-service") || reqUri.startsWith("/fare-service")) {
			return null;
		} else if (reqUri.startsWith("/auth-service")) {
			validUser = authServiceChecks(token, reqUri);
		} else if (reqUri.startsWith("/booking-service")) {
			validUser = bookingServiceChecks(token, reqUri);
		} else if (reqUri.startsWith("/reporting-service")) {
			validUser = reportingServiceChecks(token, reqUri);
		} else if (reqUri.startsWith("/profile-service")) {
			validUser = profileServiceChecks(token, reqUri);
		}

		System.err.println(request.getRequestURL());

		if (!validUser) {
			ctx.setSendZuulResponse(false); // This makes request not forwarding to micro services
			ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
			ErrorResponse validationResponse = new ErrorResponse();
			validationResponse.setSuccess(false);
			validationResponse.setMessage("Invalid Access");
			ObjectMapper mapper = new ObjectMapper();
			String responseBody;
			try {
				responseBody = mapper.writeValueAsString(validationResponse);
			} catch (JsonProcessingException e) {
				responseBody = "Invalid Access";
			}
			ctx.setResponseBody(responseBody);
			ctx.getResponse().setContentType("application/json");
		}

		return null;

	}

	private boolean profileServiceChecks(String token, String reqUri) {
		if (reqUri.contains("/locations") || reqUri.contains("/cities")) {
			return checkRole("ROLE_ADMIN", getAuthorities(token));
		} else if (reqUri.contains("/customers")) {
			return checkRole("ROLE_CUST", getAuthorities(token));
		} else if (reqUri.contains("/cars") || reqUri.contains("/vendors")) {
			List<String> authorities = getAuthorities(token);
			return (checkRole("ROLE_ADMIN", authorities) || checkRole("ROLE_VENDOR", authorities));
		} else {
			return true;
		}
	}

	private boolean reportingServiceChecks(String token, String reqUri) {
		List<String> authorities = getAuthorities(token);
		return (checkRole("ROLE_ADMIN", authorities) || checkRole("ROLE_VENDOR", authorities));
	}

	private boolean bookingServiceChecks(String token, String reqUri) {
		List<String> authorities = getAuthorities(token);
		return (checkRole("ROLE_ADMIN", authorities) || checkRole("ROLE_CUST", authorities));
	}

	private boolean authServiceChecks(String token, String reqUri) {
		if (reqUri.contains("/admins") || reqUri.contains("/vendors") || reqUri.contains("/clients")) {
			return checkRole("ROLE_ADMIN", getAuthorities(token));
		} else {
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	private List<String> getAuthorities(String token) {
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return new ArrayList<>();
		} else {
			token = token.replace("Bearer ", "");
		}
		Map<String, ?> claims = null;
		try {
			claims = tokenValidation.validateToken(prepareAuthHeader(), token);
		} catch (Exception e) {
			return new ArrayList<>();
		}
		return (List<String>) claims.get("authorities");
	}

	private String prepareAuthHeader() {
		String authHeader = clientId + ":" + clientSecret;
		String encodedHeader = Base64.getEncoder().encodeToString(authHeader.getBytes());
		return "Basic " + encodedHeader;
	}

	private boolean checkRole(String role, List<String> authorities) {
		if (authorities.contains(role)) {
			return true;
		} else {
			return false;
		}
	}

}
