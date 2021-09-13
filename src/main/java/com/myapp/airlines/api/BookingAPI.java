package com.myapp.airlines.api;

import java.sql.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.airlines.model.Booking;
import com.myapp.airlines.repository.BookingList;

@RestController
@RequestMapping("/api/v1/bookingdetails")
public class BookingAPI extends TravellerDetailsAPI {

	@Autowired
	private BookingList booking;

	@GetMapping("passenger/{firstName}")
	public ResponseEntity<List<Booking>> findByFirstName(@PathVariable("firstName") String name) {
		
		return new ResponseEntity<List<Booking>>(booking.findByFirstName(name).get(), HttpStatus.OK);
	}

}
