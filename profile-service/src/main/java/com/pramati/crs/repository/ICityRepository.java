package com.pramati.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.crs.entities.City;

@Repository
public interface ICityRepository extends JpaRepository<City, Integer>{

}
