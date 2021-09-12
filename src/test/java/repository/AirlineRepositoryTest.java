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
	Flight product=repository.findById("100").orElseGet(()-> new Flight());
	
	// Then perform Assert Conditions To validate
	Assertions.assertNull(product.getFlightName(), 
			"Product With Id 100 should not exist");
}
}