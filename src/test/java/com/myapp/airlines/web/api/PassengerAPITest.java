package com.myapp.airlines.web.api;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.airlines.model.Passenger;
import com.myapp.airlines.repository.PassengerList;

@SpringBootTest

@AutoConfigureMockMvc(addFilters = false)
public class PassengerAPITest {

	@MockBean
	private PassengerList repository;

	@Autowired
	private MockMvc mockMvc;

	private Object newPassenger;

	@Test
	@DisplayName("Test Add New Passenger")
	public void testAddNewPassenger() throws Exception {

// Prepare Mock Flight
		Passenger passenger = new Passenger(13, "Yash", "singh", "awasthiyash02@gmail.com", "7610165654", 22, "Female");
		Passenger mockPassenger = new Passenger(13, "Yash", "singh", "awasthiyash02@gmail.com", "7610165654", 22, "Female");

// Prepare Mock Service Method

		doReturn(mockPassenger).when(repository).save(ArgumentMatchers.any());

// Perform GET Request

		mockMvc.perform(post("/api/v1/passengerdetails")
// Validate Status should be 200 OK and JSON response received

				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(passenger)))

// Validate Response Body

				.andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

				.andExpect(jsonPath("$.passenger_id", is(13)))
				.andExpect(jsonPath("$.first_name", is("Yash")))
				.andExpect(jsonPath("$.last_name", is("singh")))
				.andExpect(jsonPath("$.email", is("awasthiyash02@gmail.com")))
				.andExpect(jsonPath("$.phone", is("7610165654")))
				.andExpect(jsonPath("$.age", is(22)))
				.andExpect(jsonPath("$.gender", is("Female")));

	}

}