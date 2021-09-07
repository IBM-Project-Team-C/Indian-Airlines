package com.myapp.airlines.api;

import java.util.List;
import java.util.Optional;

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
	public static String flightName, flightId, departureLoc, departureD, arrivalLoc, arrivalD;

	@Autowired
	private FlightList flights;

	@GetMapping
	public ResponseEntity<List<Flight>> findAll() {
		return new ResponseEntity<List<Flight>>(flights.findAll(), HttpStatus.OK);
	}

	@GetMapping("search/{flightName}")
	public ResponseEntity<List<Flight>> findByFlightName(@PathVariable("flightName") String flightName) {
		return new ResponseEntity<List<Flight>>(flights.findByFlightName(flightName).get(), HttpStatus.OK);
	}

	@GetMapping("/search/departureDate={departureDate}/departureLocation={departureLocation}/arrivalLocation={arrivalLocation}")
	public ResponseEntity<List<Flight>> findByDepartureDateAndDepartureLocationAndArrivalLocation(
			@PathVariable("departureDate") Optional<String> departureDate,
			@PathVariable("departureLocation") Optional<String> departureLocation,
			@PathVariable("arrivalLocation") Optional<String> arrivalLocation) {

		ResponseEntity<List<Flight>> flight = new ResponseEntity<List<Flight>>(
				flights.findByDepartureDateAndDepartureLocationAndArrivalLocation(departureDate.orElse(""),
						departureLocation.orElse(""), arrivalLocation.orElse("")).get(),
				HttpStatus.OK);

		flightName = flight.getBody().get(0).getFlightName();
		flightId = flight.getBody().get(0).getFlightId();
		departureLoc = flight.getBody().get(0).getDepartureLocation();
		departureD = flight.getBody().get(0).getDepartureDate();
		arrivalLoc = flight.getBody().get(0).getArrivalLocation();
		arrivalD = flight.getBody().get(0).getArrivalDate();
		System.out.println(flightName + flightId + departureLoc + departureD + arrivalLoc + arrivalD);

		return new ResponseEntity<List<Flight>>(
				flights.findByDepartureDateAndDepartureLocationAndArrivalLocation(departureDate.orElse(""),
						departureLocation.orElse(""), arrivalLocation.orElse("")).get(),
				HttpStatus.OK);
	}

}
