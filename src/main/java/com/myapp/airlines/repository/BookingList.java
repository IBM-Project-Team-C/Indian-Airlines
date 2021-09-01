package com.myapp.airlines.repository;

import java.util.List;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myapp.airlines.model.Passenger;

@Repository
public interface BookingList extends CrudRepository<Passenger, String> {

//	 @Query("SELECT Passenger.first_name, Passenger.last_name,flight.FLIGHT_NAME,flight.DEPARTURE_DATE,flight.ARRIVAL_TIME,flight.ARRIVAL_LOCATION FROM Passenger INNER JOIN flight ON Passenger.flight_id= flight.flight_id")
//	    List<Passenger> findAllBookings(String booking);

	
	 @Query("select p from Passenger p")
	    List<Passenger> findAllBookings(String booking);
	 
	 
}

