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

import com.myapp.airlines.model.Booking;
import com.myapp.airlines.repository.BookingList;



@SpringBootTest


@AutoConfigureMockMvc(addFilters = false)
public class BookingAPITest {


@MockBean
private BookingList repository;


@Autowired
private MockMvc mockMvc;


@Test
@DisplayName("Test Booking by FirstName - GET /api/v1/bookingdetails")
public void testfindByfindByFirstName() throws Exception {


// Prepare Mock Flight
	Booking Booking1 = new Booking("0286", "Yash", "singh", "INDIGO", "QW16H", "KERALA", "2021-08-31", "JAIPUR", "2021-08-31"  );
	Booking Booking2 = new Booking("0296", "Hari", "singh", "INDIGO", "QW16H", "KERALA", "2021-08-31", "JAIPUR", "2021-08-31"  );
	
	List<Booking> Booking = new ArrayList<>();
	Booking.add(Booking1);
	Booking.add(Booking2);
	String firstName = "Yash";
	
System.out.println(Booking.get(0));

// Prepare Mock Service Method


	doReturn(Optional.of(Booking)).when(repository).findByFirstName(firstName);

// Perform GET Request


	mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/bookingdetails/passenger/{firstName}", "Yash"))
// Validate Status should be 200 OK and JSON response received
.andExpect(status().isOk())
.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))


// Validate Response Body


.andExpect(jsonPath("$[0].bookingId", is("0286")))
.andExpect(jsonPath("$[0].firstName", is("Yash")))
.andExpect(jsonPath("$[0].lastName", is("singh")))
.andExpect(jsonPath("$[0].flightId", is("QW16H")))
.andExpect(jsonPath("$[0].flightName", is("INDIGO")))
.andExpect(jsonPath("$[0].departureLocation", is("KERALA")))
.andExpect(jsonPath("$[0].departureDate", is("2021-08-31")))
.andExpect(jsonPath("$[0].arrivalLocation", is("JAIPUR")))
.andExpect(jsonPath("$[0].arrivalDate", is("2021-08-31")));

}


}
