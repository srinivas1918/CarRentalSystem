package com.pramati.crs.service;

import java.util.List;

import com.pramati.crs.dto.BookingDTO;
import com.pramati.crs.dto.NewBookingDTO;

public interface BookingService {

	public List<BookingDTO> findAllBookings();

	public BookingDTO getBookingDetailsById(long bookingId);

	public List<BookingDTO> getAllBookingsForUser(long userId);

	public BookingDTO createNewBooking(NewBookingDTO newBookingDto);

	public BookingDTO updateBooking(long bookingId, String bookingStatus);
}
