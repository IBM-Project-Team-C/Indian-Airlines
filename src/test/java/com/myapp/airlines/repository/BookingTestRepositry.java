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
import com.myapp.airlines.repository.BookingList;



@SpringBootTest
public class BookingTestRepositry {
	
	@Autowired
	private BookingList repository;
	
	private static File DATA_JSON= Paths.get("src","test","resources","Booking.json").toFile();
	
	@BeforeEach
	public void setUp() throws JsonParseException, JsonMappingException, IOException {
		
	Booking Booking[]=new ObjectMapper().readValue(DATA_JSON, Booking[].class);
	
	// save each product to database
	Arrays.stream(Booking).forEach(repository::save);	

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
		Booking Booking=repository.findById("100").orElseGet(()-> new Booking());
		
		// Then perform Assert Conditions To validate
		Assertions.assertNull(Booking.getFlightName(), 
				"Product With Id 100 should not exist");
	}
	@Test
	@DisplayName("Test product saved sucessfully")
	public void testProductSavedSucessfully() {
		
		// given a mock product
		Booking Booking = new Booking("0276", "Yashika", "Awasthi", "INDIGO", "AI16H", "MUMBAI", "2021-08-30", "JODHPUR", "2021-08-30"  );
	    Booking.setFlightId("AI16H");
		
		// when we retrieve a product using non existing id
		Booking savedFlight=repository.save(Booking);
		
		// Then perform Assert Conditions To validate
		Assertions.assertNotNull(savedFlight, 
				"New Flight should be saved");
		
		Assertions.assertNotNull(savedFlight.getFlightId(), 
				"New Flight should have id");
		Assertions.assertEquals(Booking.getFlightName(), 
				savedFlight.getFlightName());
		
		
		}
	@Test
	@DisplayName("Test airline updated sucessfully")
	public void testBookingtUpdatedSucessfully() {
		
		// given a mock product
		Booking Booking = new Booking("0286", "Yash", "singh", "INDIGO", "QW16H", "KERLA", "2021-08-31", "JAIPUR", "2021-08-31"  );
		Booking.setBookingId("IT25H");
		
		// when we retrieve a product using non existing id
		Booking updatedBooking=repository.save(Booking);
		
		
		Assertions.assertEquals(Booking.getFlightId(), 
				updatedBooking.getFlightId());
		
		
		}
	


}
