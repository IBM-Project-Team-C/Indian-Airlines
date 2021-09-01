package com.myapp.airlines.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.airlines.model.Passenger;
import com.myapp.airlines.repository.PassengerList;

@RestController
@RequestMapping("/api/v1/passengerdetails")
public class TravellerDetailsAPI extends FlightAPI {
	public static String firstName, lastName;
	public static int passengerId;

	@Autowired
	private PassengerList repository;

	@PostMapping
	public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger) {

		firstName = passenger.getFirst_name();
		lastName = passenger.getLast_name();
		passengerId = passenger.getPassenger_id();
		System.out.println(firstName + lastName);

		return new ResponseEntity<>(repository.save(passenger), HttpStatus.CREATED);
	}

}
