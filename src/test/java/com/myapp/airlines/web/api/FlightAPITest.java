package com.myapp.airlines.web.api;


import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.myapp.airlines.model.Flight;
import com.myapp.airlines.repository.FlightList;


@SpringBootTest


@AutoConfigureMockMvc(addFilters = false)
public class FlightAPITest {


@MockBean
private FlightList repository;


@Autowired
private MockMvc mockMvc;


@Test
@DisplayName("Test Booking by Id - GET /api/v1/flight/")
public void testfindByFlightName() throws Exception {


// Prepare Mock Flight
	Flight airline1 = new Flight("AI16H", "INDIGO", "2021-08-30", "2021-08-30", "14:55", "16:30", "JODHPUR",
			"MUMBAI", 8757, 1);


			List<Flight> airlines = new ArrayList<>();
			airlines.add(airline1);
			String flightName = "INDIGO";

// Prepare Mock Service Method


	doReturn(Optional.of(airlines)).when(repository).findByFlightName(flightName);


// Perform GET Request


mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/flight/search/{flightname}", "INDIGO"))
// Validate Status should be 200 OK and JSON response received
.andExpect(status().isOk())
.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))


// Validate Response Body


.andExpect(jsonPath("$[0].flightId", is("AI16H")))
.andExpect(jsonPath("$[0].flightName", is("INDIGO")))
.andExpect(jsonPath("$[0].arrivalDate", is("2021-08-30")))
.andExpect(jsonPath("$[0].departureDate", is("2021-08-30")))
.andExpect(jsonPath("$[0].arrivalTime", is("14:55")))
.andExpect(jsonPath("$[0].departureTime", is("16:30")))
.andExpect(jsonPath("$[0].arrivalLocation", is("JODHPUR")))
.andExpect(jsonPath("$[0].departureLocation", is("MUMBAI")))
.andExpect(jsonPath("$[0].flightFare", is(8757)))
.andExpect(jsonPath("$[0].availableSeats", is(1)));


}


@Test
@DisplayName("Test All Flights /api/v1/flight/")
public void testGetAllFlights() throws Exception {


// Prepare Mock Flight
Flight airline1 = new Flight("AI16H", "INDIGO", "2021-08-30", "2021-08-30", "14:55", "16:30", "JODHPUR",
"MUMBAI", 8757, 1);
// airline1.setFlightId("AI16H");

System.out.println(airline1);

List<Flight> airlines = new ArrayList<>();
airlines.add(airline1);
// airlines.add(airline2);


// Prepare Mock Service Method


doReturn(airlines).when(repository).findAll();


// Perform GET Request


mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/flight"))
// Validate Status should be 200 OK and JSON response received
.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))


// Validate Response Body


.andExpect(jsonPath("$[0].flightId", is("AI16H")))
.andExpect(jsonPath("$[0].flightName", is("INDIGO")))
.andExpect(jsonPath("$[0].arrivalDate", is("2021-08-30")))
.andExpect(jsonPath("$[0].departureDate", is("2021-08-30")))
.andExpect(jsonPath("$[0].arrivalTime", is("14:55")))
.andExpect(jsonPath("$[0].departureTime", is("16:30")))
.andExpect(jsonPath("$[0].arrivalLocation", is("JODHPUR")))
.andExpect(jsonPath("$[0].departureLocation", is("MUMBAI")))
.andExpect(jsonPath("$[0].flightFare", is(8757)))
.andExpect(jsonPath("$[0].availableSeats", is(1)));

}


@Test
@DisplayName("Test All Flights By Price /api/v1/flight?name=&price")
public void testGetAllFlightsByNameOrPrice() throws Exception {

// Prepare Mock Flight
Flight airline1 = new Flight("RF12E", "SPICEJET",  "2021-09-20", "2021-09-20", "17:40", "20:05", "KOLKATA", "CHINA", 2966, 7);

Flight airline2 = new Flight("HP24E", "VISTARA",  "2021-09-14", "2021-09-14", "07:20", "09:05", "GOA", "HYDERABAD", 6781, 15);

List<Flight> airlines = new ArrayList<>();
airlines.add(airline1);
airlines.add(airline2);


// Prepare Mock Service Method
String departureDate="2021-09-20";
String departureLocation = "CHINA";
String arrivalLocation = "KOLKATA";

doReturn(Optional.of(airlines)).when(repository)
.findByDepartureDateAndDepartureLocationAndArrivalLocation(departureDate, departureLocation, arrivalLocation);


// Perform GET Request


mockMvc.perform(MockMvcRequestBuilders
.get("/api/v1/flight//search/departureDate={departureDate}/departureLocation={departureLocation}/arrivalLocation={arrivalLocation}", 
		 departureDate, departureLocation, arrivalLocation))

// Validate Status should be 200 OK and JSON response received
.andExpect(status().isOk())
.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

// Validate Response Body

.andExpect(jsonPath("$[0].flightId", is("RF12E")))
.andExpect(jsonPath("$[0].flightName", is("SPICEJET")))
.andExpect(jsonPath("$[0].arrivalDate", is("2021-09-20")))
.andExpect(jsonPath("$[0].departureDate", is("2021-09-20")))
.andExpect(jsonPath("$[0].arrivalTime", is("17:40")))
.andExpect(jsonPath("$[0].departureTime", is("20:05")))
.andExpect(jsonPath("$[0].arrivalLocation", is("KOLKATA")))
.andExpect(jsonPath("$[0].departureLocation", is("CHINA")))
.andExpect(jsonPath("$[0].flightFare", is(2966)))
.andExpect(jsonPath("$[0].availableSeats", is(7)));


    }


}