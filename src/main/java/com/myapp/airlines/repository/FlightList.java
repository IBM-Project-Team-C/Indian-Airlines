package com.myapp.airlines.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.airlines.model.Flight;

@Repository
public interface FlightList extends JpaRepository<Flight, Integer>{
	
//	Optional<List<Flight>> findByPriceGreaterThanEqual(Double price);
	Optional<List<Flight>> findByFlightName(String flightName);
//	Optional<List<Flight>> findByFlightId(Integer flightId);
//	Optional<List<Flight>> findByProductNameOrPrice(String productName, Double price);
	

}
