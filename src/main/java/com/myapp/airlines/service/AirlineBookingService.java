package com.myapp.airlines.service;

import java.util.List;

import com.myapp.airlines.model.Passenger;

public interface AirlineBookingService {

	List<Passenger> findAllBookings(String booking);
}
