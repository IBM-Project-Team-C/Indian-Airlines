package com.myapp.airlines.repository;

import com.myapp.airlines.model.Passenger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerList extends JpaRepository<Passenger, Integer> {

}
