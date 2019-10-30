package com.pramati.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.crs.entities.Vendor;

@Repository
public interface IVendorRepository extends JpaRepository<Vendor, Long> {

}
