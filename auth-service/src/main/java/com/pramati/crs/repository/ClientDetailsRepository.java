package com.pramati.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.crs.config.entity.ClientDetails;

@Repository
public interface ClientDetailsRepository extends JpaRepository<ClientDetails, String> {

}
