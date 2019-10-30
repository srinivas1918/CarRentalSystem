package com.pramati.crs.booking.service;

import java.util.List;

import com.pramati.crs.booking.dto.BookingDTO;
import com.pramati.crs.booking.dto.NewBookingDTO;

public interface BookingService {

	public List<BookingDTO> findAllBookings();

	public BookingDTO getBookingDetailsById(long bookingId);

	public List<BookingDTO> getAllBookingsForUser(long userId);

	public BookingDTO createNewBooking(NewBookingDTO newBookingDto);

	public BookingDTO updateBooking(long bookingId, String bookingStatus);
}
