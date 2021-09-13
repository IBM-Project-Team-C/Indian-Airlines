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
	
	@Autowired
	private JdbcTemplate template;

	@GetMapping("passenger/{firstName}")
	public ResponseEntity<List<Booking>> findByFirstName(@PathVariable("firstName") String name) {



			String bookingId = passengerId + flightId;
			System.out.println(bookingId + firstName + lastName + flightName + flightId + departureLoc + departureD
					+ arrivalLoc + arrivalD);
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines", "root", "root");
			String query = "REPLACE INTO booking(BOOKING_ID, FIRST_NAME, LAST_NAME,FLIGHT_NAME, FLIGHT_ID, DEPARTURE_LOCATION, DEPARTURE_DATE, ARRIVAL_LOCATION, ARRIVAL_DATE) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";

			template.update(query, bookingId,firstName,lastName,flightName,flightId,departureLoc,departureD,arrivalLoc,arrivalD);
			//PreparedStatement myInsert = con.prepareStatement(query);
//			myInsert.setString(1, bookingId);
//			myInsert.setString(2, firstName);
//			myInsert.setString(3, lastName);
//			myInsert.setString(4, flightName);
//			myInsert.setString(5, flightId);
//			myInsert.setString(6, departureLoc);
//			myInsert.setString(7, departureD);
//			myInsert.setString(8, arrivalLoc);
//			myInsert.setString(9, arrivalD);
//			myInsert.executeUpdate();

		
		return new ResponseEntity<List<Booking>>(booking.findByFirstName(name).get(), HttpStatus.OK);
	}

}
