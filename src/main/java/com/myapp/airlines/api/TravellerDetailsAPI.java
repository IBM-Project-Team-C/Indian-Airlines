package com.myapp.airlines.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.airlines.model.Passenger;
import com.myapp.airlines.repository.BookingList;
import com.myapp.airlines.repository.PassengerList;

@RestController
@RequestMapping("/api/v1/passengerdetails")
public class TravellerDetailsAPI extends FlightAPI {
	public static String firstName, lastName;
	public static int passengerId;

	@Autowired
	private PassengerList repository;
	
	@Autowired
	private BookingList booking;
	
	@Autowired
	private JdbcTemplate template;

	@PostMapping
	public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger) {

		firstName = passenger.getFirst_name();
		lastName = passenger.getLast_name();
		passengerId = passenger.getPassenger_id();
		System.out.println(firstName + lastName);
		
		String bookingId = passengerId + flightId;
		System.out.println(bookingId + firstName + lastName + flightName + flightId + departureLoc + departureD
				+ arrivalLoc + arrivalD);
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines", "root", "root");
		String query = "INSERT INTO booking(BOOKING_ID, FIRST_NAME, LAST_NAME,FLIGHT_NAME, FLIGHT_ID, DEPARTURE_LOCATION, DEPARTURE_DATE, ARRIVAL_LOCATION, ARRIVAL_DATE) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";

		template.update(query, bookingId,firstName,lastName,flightName,flightId,departureLoc,departureD,arrivalLoc,arrivalD);

		return new ResponseEntity<>(repository.save(passenger), HttpStatus.CREATED);
	}

}
