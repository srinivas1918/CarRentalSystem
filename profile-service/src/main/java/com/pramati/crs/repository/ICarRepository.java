package com.pramati.crs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.crs.entities.Car;

@Repository
public interface ICarRepository extends JpaRepository<Car, Long>{

	List<Car> findByVendorId(Long vendorId);

}
