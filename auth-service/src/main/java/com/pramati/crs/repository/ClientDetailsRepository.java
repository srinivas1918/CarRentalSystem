package com.pramati.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.crs.entity.ClientDetails;

/**
 * Repository interface for ClientDetails related operations
 * 
 * @author manikanth
 *
 */
@Repository
public interface ClientDetailsRepository extends JpaRepository<ClientDetails, String> {

}
