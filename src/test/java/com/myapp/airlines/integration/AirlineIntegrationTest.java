package com.myapp.airlines.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.airlines.model.Booking;
import com.myapp.airlines.model.Flight;
import com.myapp.airlines.model.Passenger;
import com.myapp.airlines.repository.BookingList;
import com.myapp.airlines.repository.FlightList;
import com.myapp.airlines.repository.PassengerList;



@SpringBootTest


@AutoConfigureMockMvc
public class AirlineIntegrationTest {
	
	@Autowired
	private FlightList repository;
	
	@Autowired
	private MockMvc mockMvc;
	
	private static File DATA_JSON= Paths.get("src","test","resources","airline.json").toFile();
	
	@BeforeEach
	public void setUp() throws JsonParseException, JsonMappingException, IOException {
		
	Flight airlines[]=new ObjectMapper().readValue(DATA_JSON, Flight[].class);
	
	Arrays.stream(airlines).forEach(repository::save);	
	
	
	}
	
	
	
	
	@AfterEach
	public void cleanUp() {
		repository.deleteAll();
		
	}
	
	@Test
	@DisplayName("Test Booking by Id - GET /api/v1/Flight")
	public void testGetBookingById() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/flight/{FlightName}","INDIGO"))
		// Validate Status should be 200 OK and JSON response received
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		
		.andExpect(jsonPath("$.flightId", is("AI16H")))
		.andExpect(jsonPath("$.flightName", is("Indigo")))
		.andExpect(jsonPath("$.arrivalDate", is("2021-08-30")))
		.andExpect(jsonPath("$.departureDate", is("2021-08-30")))
		.andExpect(jsonPath("$.arrivaltime", is("14:55")))
		.andExpect(jsonPath("$.departureTime", is("14:20")))
		.andExpect(jsonPath("$.arrivalLocation", is("JODHPUR")))
		.andExpect(jsonPath("$.departureLocation", is("MUMBAI")))
		.andExpect(jsonPath("$.FlightFare", is(8757)))
		.andExpect(jsonPath("$.availableSeats", is(1)));
		
		
	}
	
//	@Test
//	@DisplayName("Test All Booking /api/v1/bookingdetails/")
//	public void testGetAllBookingList() throws Exception {
//		
//		// Perform GET Request
//		
//				mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/bookingdetails"))
//				// Validate Status should be 200 OK and JSON response received
//				.andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//				
//				// Validate Response Body
//				
//				.andExpect(jsonPath("$[0].bookingId", is(1)))
//				.andExpect(jsonPath("$[0].firstName", is("Yash")))
//				.andExpect(jsonPath("$[0].lastName", is("Awasthi")))
//				.andExpect(jsonPath("$[0].flightId", is("AI16H")))
//				.andExpect(jsonPath("$[0].flightName", is("Indigo")))
//				.andExpect(jsonPath("$[0].departureLocation", is("JODHPUR")))
//				.andExpect(jsonPath("$[0].departureDate", is("2021-08-30")))
//				.andExpect(jsonPath("$[0].arrivalLocation", is("MUMBAI")))
//				.andExpect(jsonPath("$[0].arrivalDate", is("2021-08-30")));
//				
//				
				
//				.andExpect(jsonPath("$[1].bookingId", is(2)))
//				.andExpect(jsonPath("$[1].firstName", is("shruthi")))
//				.andExpect(jsonPath("$[1].lastName", is("kulkarni")))
//				.andExpect(jsonPath("$[1].flightId", is("IT25H")))
//				.andExpect(jsonPath("$[1].flightName", is("AIR INDIA")))
//				.andExpect(jsonPath("$[1].departureLocation", is("mumbai")))
//				.andExpect(jsonPath("$[1].departureDate", is("2021-08-31")))
//				.andExpect(jsonPath("$[1].arrivalLocation", is("jodhpur")))
//				.andExpect(jsonPath("$[1].arrivalDate", is("2021-08-31")));
//}




	
	}

