package com.myapp.airlines.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.airlines.model.Passenger;
import com.myapp.airlines.repository.BookingList;
import com.myapp.airlines.repository.PassengerList;

@Service
public class AirlineBookingServiceImpl implements AirlineBookingService {

	
	 @Autowired
	    private BookingList repository;

	    @Override
	    public List<Passenger> findAllBookings(String booking) {

	        List<Passenger> cities = (List<Passenger>) repository.findAllBookings(booking);
	        return cities;
	    }	
	

}
