package com.pramati.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.crs.entity.UserProfile;

/**
 * Repository interface for UserProfile related operations
 * 
 * @author manikanth
 *
 */
@Repository
public interface UserProfilesRepository extends JpaRepository<UserProfile, String> {

}
