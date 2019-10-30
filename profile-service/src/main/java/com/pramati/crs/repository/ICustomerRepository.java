package com.pramati.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.crs.entities.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long>{

}
