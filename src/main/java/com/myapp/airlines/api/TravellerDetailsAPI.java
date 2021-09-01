package com.myapp.airlines.api;

import java.util.ArrayList;
import java.util.List;

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
public class TravellerDetailsAPI {
	
	@Autowired
	private PassengerList repository;


	@PostMapping
	public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger) {
		
//		List<Passenger> pass = new ArrayList<Passenger>();
//        pass.add(passenger);
//        System.out.println(pass.get(0).getFirst_name());
		
		return new ResponseEntity<>(repository.save(passenger), HttpStatus.CREATED);
	}
	
}
