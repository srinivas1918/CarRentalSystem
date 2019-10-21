package com.pramati.crs.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pramati.crs.dto.BookingDTO;
import com.pramati.crs.dto.NewBookingDTO;
import com.pramati.crs.entity.Booking;
import com.pramati.crs.exception.APIException;
import com.pramati.crs.repository.BookingRepository;
import com.pramati.crs.service.BookingService;
import com.pramati.crs.utils.BookingConverter;

@Service
public class BookingServiceImpl implements BookingService {
	
	private BookingRepository bookingRepository;
	
	public BookingServiceImpl(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	@Override
	public List<BookingDTO> findAllBookings() {
		
		List<Booking> allBookings = bookingRepository.findAll();
		
		List<BookingDTO> allBookingDtos = allBookings.stream().map(BookingConverter::mapBookingToDTO).collect(Collectors.toList());
		
		return allBookingDtos;
	}

	@Override
	public BookingDTO getBookingDetailsById(long bookingId) {
		
		Optional<Booking> booking = bookingRepository.findById(bookingId);
		
		if(booking.isPresent()) {
			return BookingConverter.mapBookingToDTO(booking.get());
		} else {
			throw new APIException("No booking found with the given booking id", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<BookingDTO> getAllBookingsForUser(long userId) {
		
		List<Booking> userBookings = bookingRepository.findByUserId(userId);
		
		List<BookingDTO> allUserBookingDtos = userBookings.stream().map(BookingConverter::mapBookingToDTO).collect(Collectors.toList());
		return allUserBookingDtos;
	}

	@Override
	public BookingDTO createNewBooking(NewBookingDTO newBookingDto) {

		Booking booking = new Booking();
		
		booking.setUserId(newBookingDto.getUserId());
		booking.setCarId(newBookingDto.getCarId());
		booking.setLocationId(newBookingDto.getLocationId());
		booking.setFromDate(newBookingDto.getFromDate());
		booking.setToDate(newBookingDto.getToDate());
		booking.setBookingStatus("BOOKED");
		booking.setEstimatedFare(100);
		booking.setBookedOn(new Date(System.currentTimeMillis()));
		
		booking =  bookingRepository.save(booking);
		
		return BookingConverter.mapBookingToDTO(booking);
	}

	@Override
	public BookingDTO updateBooking(long bookingId, String bookingStatus) {
		
		Optional<Booking> booking = bookingRepository.findById(bookingId);
		if(!booking.isPresent()) {
			throw new APIException("No booking available with given id", HttpStatus.NOT_FOUND);
		}
		
		Booking existingBooking = booking.get();
		
		existingBooking.setBookingStatus(bookingStatus);
		
		existingBooking = bookingRepository.save(existingBooking);
		
		return BookingConverter.mapBookingToDTO(existingBooking);
	}

}
