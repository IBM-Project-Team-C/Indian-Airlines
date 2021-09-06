package com.myapp.airlines.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.airlines.model.Booking;
import com.myapp.airlines.model.Flight;
import com.myapp.airlines.model.Passenger;
import com.myapp.airlines.repository.PassengerList;



@SpringBootTest
public class PassengerTestRepositry {
	
	@Autowired
	private PassengerList repository;
	
	private static File DATA_JSON= Paths.get("src","test","resources","Passenger.json").toFile();
	
	@BeforeEach
	public void setUp() throws JsonParseException, JsonMappingException, IOException {
		
	Passenger Passenger[]=new ObjectMapper().readValue(DATA_JSON, Passenger[].class);
	
	// save each product to database
	Arrays.stream(Passenger).forEach(repository::save);	

}
	@AfterEach
	public void cleanUp() {
		repository.deleteAll();
		
	} 
	@Test
	@DisplayName("Test Passenger not found for a non existing name")
	public void testPassengerNotFoundForNonExistingName() {

		// given three products in the database
		
		
		// when we retrieve a product using non existing id
		Passenger Passenger=repository.findById(100).orElseGet(()-> new Passenger());
		
		// Then perform Assert Conditions To validate
		Assertions.assertNull(Passenger.getPassenger_id(), 
				"Passenger With Id 100 should not exist");
	}
	
	@Test
	@DisplayName("Test Passenger updated sucessfully")
	public void testPassengertUpdatedSucessfully() {
		
		// given a mock product
		Passenger Passenger =  new Passenger(13, "Yash", "singh", "awasthiyash02@gmail.com",  "7610165654", 22, "Female" );
		Passenger.setPassenger_id(12);
		
		// when we retrieve a product using non existing id
		Passenger updatedPassenger=repository.save(Passenger);
		
		
		Assertions.assertEquals(Passenger.getPassenger_id(), 
				updatedPassenger.getPassenger_id());
		
		
		}
	@Test
	@DisplayName("Test Passenger saved sucessfully")
	public void testPassengerSavedSucessfully() {
		
		// given a mock product
		Passenger Passenger = new Passenger(18, "Yash", "singh", "awasthiyash02@gmail.com",  "7610165654", 22, "Female" );
	    Passenger.setPassenger_id(13);
		
		// when we retrieve a product using non existing id
		Passenger savedPassenger=repository.save(Passenger);
		
		// Then perform Assert Conditions To validate
		Assertions.assertNotNull(savedPassenger, 
				"New Flight should be saved");
		
		Assertions.assertNotNull(savedPassenger.getPassenger_id(), 
				"New Flight should have id");
		Assertions.assertEquals(Passenger.getFirst_name(), 
				savedPassenger.getFirst_name());
		
		
		}
}
//done
