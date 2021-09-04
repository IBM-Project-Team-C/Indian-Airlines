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
import com.myapp.airlines.model.Flight;
import com.myapp.airlines.repository.FlightList;




@SpringBootTest
public class AirlineRepositoryTest {
	
	@Autowired
	private FlightList repository;
	
	private static File DATA_JSON= Paths.get("src","test","resources","airline.json").toFile();
	
	@BeforeEach
	public void setUp() throws JsonParseException, JsonMappingException, IOException {
		
	Flight airline[]=new ObjectMapper().readValue(DATA_JSON, Flight[].class);
	
	// save each product to database
	Arrays.stream(airline).forEach(repository::save);	

}
	@AfterEach
	public void cleanUp() {
		repository.deleteAll();
		
	}

@Test
@DisplayName("Test Booking not found for a non existing name")
public void testProductNotFoundForNonExistingName() {

	// given three products in the database
	
	
	// when we retrieve a product using non existing id
	Flight airline=repository.findById("100").orElseGet(()-> new Flight());
	
	// Then perform Assert Conditions To validate
	Assertions.assertNull(airline.getFlightName(), 
			"Product With Id 100 should not exist");
}

@Test
@DisplayName("Test product saved sucessfully")
public void testProductSavedSucessfully() {
	
	// given a mock product
	Flight airline = new Flight("AB18J", "SPICE", "2021-08-27", "2021-08-27", "13:55", "13:30", "Banglore", "KOLKATA", 6575, 10 );
	airline.setFlightId("IT25H");
	
	// when we retrieve a product using non existing id
	Flight savedFlight=repository.save(airline);
	
	// Then perform Assert Conditions To validate
	Assertions.assertNotNull(savedFlight, 
			"New Flight should be saved");
	
	Assertions.assertNotNull(savedFlight.getFlightId(), 
			"New Flight should have id");
	Assertions.assertEquals(airline.getFlightName(), 
			savedFlight.getFlightName());
	
	
	}

@Test
@DisplayName("Test airline updated sucessfully")
public void testFlightUpdatedSucessfully() {
	
	// given a mock product
	Flight airline = new Flight("AB15H", "SPICE",  "2021-08-29", "2021-08-29", "13:55", "15:30", "DELHI", "JAIPUR", 6575, 9);
	airline.setFlightId("AI16H");
	
	// when we retrieve a product using non existing id
	Flight updatedFlight=repository.save(airline);
	
	
	Assertions.assertEquals(airline.getFlightName(), 
			updatedFlight.getFlightName());
	
	
	}

}