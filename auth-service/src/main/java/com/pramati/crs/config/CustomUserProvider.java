package com.pramati.crs.config;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedUserException;
import org.springframework.stereotype.Component;

import com.pramati.crs.entity.UserProfile;
import com.pramati.crs.repository.UserProfilesRepository;

/**
 * Class to authenticate the user details 
 * 
 * @author manikanth
 *
 */
@Component
public class CustomUserProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private UserProfilesRepository repository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	/**
	 * @param username       The username to retrieve
	 * @param authentication The authentication request, to perform a binding-based
	 *                       retrieval of the <code>UserDetails</code>
	 *
	 * @return the user information
	 *
	 * @throws AuthenticationException if the credentials could not be validated
	 */
	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		Optional<UserProfile> userProfile = repository.findById(username);
		if (userProfile.isPresent()) {
			UserProfile user = userProfile.get();
			if (encoder.matches(authentication.getCredentials().toString(), user.getPassword())) {
				List<GrantedAuthority> authorities = AuthorityUtils
						.createAuthorityList(user.getAuthorities().toArray(new String[user.getAuthorities().size()]));
				return new User(username, authentication.getCredentials().toString(), authorities);
			}

		}
		throw new UnauthorizedUserException("User Authentication failed.");
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub

	}

}
