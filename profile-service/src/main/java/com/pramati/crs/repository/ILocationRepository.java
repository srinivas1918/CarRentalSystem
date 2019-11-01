package com.pramati.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.crs.entities.Location;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Integer>{

}
