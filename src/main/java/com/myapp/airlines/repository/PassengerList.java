package com.myapp.airlines.repository;

import com.myapp.airlines.model.Passenger;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PassengerList extends JpaRepository<Passenger, String>{

	 
	
}
