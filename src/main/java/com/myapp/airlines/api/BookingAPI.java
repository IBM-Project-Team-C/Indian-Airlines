package com.myapp.airlines.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.airlines.model.Passenger;
import com.myapp.airlines.service.AirlineBookingService;

@Controller
public class BookingAPI {

	 @Autowired
	    AirlineBookingService bookingService;
	 
	 @GetMapping("/showBookings")
	    public String findAllBookings(Model model, @RequestParam String booking) {

		 List<Passenger> passengerBookings = (List<Passenger>) bookingService.findAllBookings(booking);

	        model.addAttribute("booking", passengerBookings);

	        return "showBookings";
	    }
}
