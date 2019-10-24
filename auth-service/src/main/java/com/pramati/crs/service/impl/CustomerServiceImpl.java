package com.pramati.crs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pramati.crs.dto.UserDTO;
import com.pramati.crs.entity.UserProfile;
import com.pramati.crs.repository.UserProfilesRepository;
import com.pramati.crs.service.CustomerService;

/**
 * Service class for customer related services
 * 
 * @author manikanth
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private UserProfilesRepository userProfileRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	/**
	 * @param user The customer details to register
	 *
	 * @throws Exception if the customer with given username already exists
	 */
	public void createCustomer(UserDTO user) throws Exception {
		Optional<UserProfile> existingUser = userProfileRepository.findById(user.getUsername());
		if (existingUser.isPresent()) {
			throw new Exception("User with username" + user.getUsername() + " already exists");
		}
		UserProfile userProfile = generateUserProfile(user);
		userProfileRepository.save(userProfile);
	}

	/**
	 * @param user The customer details to register
	 *
	 * @return UserProfile user profile details obtained from userVo
	 */
	private UserProfile generateUserProfile(UserDTO user) {
		UserProfile userProfile = new UserProfile(user.getUsername(), encoder.encode(user.getPassword()));
		List<String> authorities = new ArrayList<>();
		authorities.add("ROLE_CUST");
		userProfile.setAuthorities(authorities);
		return userProfile;
	}
}
