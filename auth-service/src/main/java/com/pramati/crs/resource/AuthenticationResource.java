
package com.pramati.crs.resource;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.CheckTokenEndpoint;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.service.AuthService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Rest Controller class for Login, Logout the user and Validate and refresh the
 * Token
 * 
 * @author manikanth
 *
 */
@RestController
@RequestMapping(value = "/user")
public class AuthenticationResource {

	@Autowired
	private TokenEndpoint tokenEndpoint;

	@Autowired
	private CheckTokenEndpoint checkTokenEndpoint;

	@Autowired
	private AuthService authService;

	/**
	 * @param principal  The Basic user principal used for HTTP authentication
	 * 
	 * @param parameters User details (username, password) and grant_type in case of
	 *                   getting token User details like refresh_token and
	 *                   grant_type for getting access token from refresh token
	 *
	 * @return OAuth2AccessToken
	 *
	 * @throws HttpRequestMethodNotSupportedException if the method is not specified
	 *                                                correctly
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/token")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Login successfull."),
			@ApiResponse(code = 401, message = "Unauthorized access.") })
	@ApiOperation(value = "Common Login for Customer, Vendor and Admin")
	public ResponseEntity<OAuth2AccessToken> postAccessToken(Principal principal,
			@RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
		return tokenEndpoint.postAccessToken(principal, parameters);
	}

	/**
	 * @param request
	 * 
	 * @return String with the logout status
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/logout")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Logout successfull."),
			@ApiResponse(code = 400, message = "Logout Unsuccessfull.") })
	@ApiOperation(value = "Common Logout for Customer, Vendor and Admin")
	public ResponseEntity<String> logout(HttpServletRequest request) {
		boolean revokeStatus = authService.userLogout(request);
		if (revokeStatus) {
			return new ResponseEntity<String>("Logged out user successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Logout is not successfull", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * @param accessToken
	 * 
	 * @return Map JSON with the token details
	 */
	@RequestMapping(value = "/validateToken", method = RequestMethod.GET)
	@ApiOperation(value = "Validate the token")
	public Map<String, ?> validateToken(@RequestParam String accessToken) {
		return checkTokenEndpoint.checkToken(accessToken);
	}
}
