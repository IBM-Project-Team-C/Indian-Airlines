package com.myapp.airlines.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.airlines.model.Booking;

@Repository
<<<<<<< HEAD
public interface BookingList extends JpaRepository<Booking, String>{
	
=======
public interface BookingList extends JpaRepository<Booking, String> {

>>>>>>> origin/final-branch
	Optional<List<Booking>> findByFirstName(String name);

}