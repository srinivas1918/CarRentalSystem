package com.pramati.crs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.crs.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

	public List<Booking> findByUserId(long userId);
}
