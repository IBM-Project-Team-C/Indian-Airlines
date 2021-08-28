package com.myapp.airlines.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.airlines.model.Flight;
import com.myapp.airlines.repository.FlightList;

@RestController
@RequestMapping("/api/v1/flight")
public class FlightAPI {
	
	@Autowired
	private FlightList flights;
	
	@GetMapping
	public ResponseEntity<List<Flight>> findAll(){
		return new ResponseEntity<List<Flight>>(flights.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("search/{flightName}")
	public ResponseEntity<List<Flight>> findByFlightName(@PathVariable("flightName")String flightName){
		return new ResponseEntity<List<Flight>>(flights.findByFlightName(flightName).get(), HttpStatus.OK);
	}
	
}
