package com.pramati.crs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pramati.crs.entity.UserProfile;
import com.pramati.crs.repository.UserProfilesRepository;
import com.pramati.crs.vo.UserVo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private UserProfilesRepository userProfileRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public void createCustomer(UserVo user) throws Exception {
		Optional<UserProfile> existingUser = userProfileRepository.findById(user.getUsername());
		if (existingUser.isPresent()) {
			throw new Exception("User with username" + user.getUsername() + " already exists");
		}
		UserProfile userProfile = generateUserProfile(user);
		userProfileRepository.save(userProfile);
	}

	private UserProfile generateUserProfile(UserVo user) {
		UserProfile userProfile = new UserProfile(user.getUsername(), encoder.encode(user.getPassword()));
		List<String> authorities = new ArrayList<>();
		authorities.add("ROLE_CUST");
		userProfile.setAuthorities(authorities);
		return userProfile;
	}
}
