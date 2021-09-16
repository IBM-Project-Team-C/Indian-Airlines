package com.myapp.airlines.integration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
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

@AutoConfigureMockMvc(addFilters = false)
public class BookingIntegrationTest {

	@Autowired
	private BookingList repository;

	@Autowired
	private MockMvc mockMvc;

	private static File DATA_JSON = Paths.get("src", "test", "resources", "BookingInteg.json").toFile();

	@BeforeEach
	public void setUp() throws JsonParseException, JsonMappingException, IOException {

		Booking bookings[] = new ObjectMapper().readValue(DATA_JSON, Booking[].class);

		Arrays.stream(bookings).forEach(repository::save);

	}

	@AfterEach
	public void cleanUp() {
		repository.deleteAll();

	}

	@Test
	@DisplayName("Test Booking by firstName - GET /api/v1/Bookingdetails/passenger/{firstName}")
	public void testGetBookingByFirstName() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/bookingdetails/passenger/{firstName}", "Yashika"))
				// Validate Status should be 200 OK and JSON response received

				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

				.andExpect(jsonPath("$[0].bookingId", is("01EFR")))
				.andExpect(jsonPath("$[0].firstName", is("Yashika")))
				.andExpect(jsonPath("$[0].lastName", is("Awasthi")))
				.andExpect(jsonPath("$[0].flightName", is("INDIGO")))
				.andExpect(jsonPath("$[0].flightId", is("AI16H")))
				.andExpect(jsonPath("$[0].departureLocation", is("MUMBAI")))
				.andExpect(jsonPath("$[0].departureDate", is("2021-08-30")))
				.andExpect(jsonPath("$[0].arrivalLocation", is("JODHPUR")))
				.andExpect(jsonPath("$[0].arrivalDate", is("2021-08-30")));
	}

}
