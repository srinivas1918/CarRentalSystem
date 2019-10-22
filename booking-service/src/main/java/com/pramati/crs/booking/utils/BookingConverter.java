package com.pramati.crs.booking.utils;

import org.springframework.stereotype.Component;

import com.pramati.crs.booking.dto.BookingDTO;
import com.pramati.crs.booking.entity.Booking;

@Component
public class BookingConverter {

	public static BookingDTO mapBookingToDTO(Booking booking) {
		
		BookingDTO bookingDTO = new BookingDTO();
		
		bookingDTO.setBookingId(booking.getBookingId());
		bookingDTO.setUserId(booking.getUserId());
		bookingDTO.setCarId(booking.getCarId());
		bookingDTO.setLocationId(booking.getLocationId());
		bookingDTO.setFromDate(booking.getFromDate());
		bookingDTO.setToDate(booking.getToDate());
		bookingDTO.setEstimatedFare(booking.getEstimatedFare());
		bookingDTO.setFinalFare(booking.getFinalFare());
		bookingDTO.setBookingStatus(booking.getBookingStatus());
		bookingDTO.setBookedOn(booking.getBookedOn());
		
		return bookingDTO;
	}
}
