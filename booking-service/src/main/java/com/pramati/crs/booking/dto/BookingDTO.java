package com.pramati.crs.booking.dto;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import com.pramati.crs.booking.entity.Booking.BookingStatus;

public class BookingDTO extends ResourceSupport{

	private long bookingId;

	private long userId;

	private long carId;

	private long locationId;

	private double estimatedFare;

	private double finalFare;

	private Date fromDate;

	private Date toDate;

	private BookingStatus bookingStatus;
	
	private Date bookedOn;

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public double getEstimatedFare() {
		return estimatedFare;
	}

	public void setEstimatedFare(double estimatedFare) {
		this.estimatedFare = estimatedFare;
	}

	public double getFinalFare() {
		return finalFare;
	}

	public void setFinalFare(double finalFare) {
		this.finalFare = finalFare;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Date getBookedOn() {
		return bookedOn;
	}

	public void setBookedOn(Date bookedOn) {
		this.bookedOn = bookedOn;
	}
	
}
