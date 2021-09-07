package com.myapp.airlines.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@Column(name = "BOOKING_ID")
	public String bookingId;

	@Column(name = "FIRST_NAME")
	public String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "FLIGHT_NAME")
	private String flightName;

	@Column(name = "FLIGHT_ID")
	private String flightId;

	@Column(name = "DEPARTURE_LOCATION")
//	@NotNull
	private String departureLocation;

	@Column(name = "DEPARTURE_DATE")
//	@NotNull
	private String departureDate;

	@Column(name = "ARRIVAL_LOCATION")
	private String arrivalLocation;

	@Column(name = "ARRIVAL_DATE")
	private String arrivalDate;

	public Booking() {
		// TODO Auto-generated constructor stub
	}

	
	public Booking(String bookingId, String firstName,String lastName,  String flightName,
			 String flightId,  String departureLocation,  String departureDate,
			 String arrivalLocation,  String arrivalDate) {
		this.bookingId = bookingId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.flightName = flightName;
		this.flightId = flightId;
		this.departureLocation = departureLocation;
		this.departureDate = departureDate;
		this.arrivalLocation = arrivalLocation;
		this.arrivalDate = arrivalDate;
	}







	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrivalDate, arrivalLocation, bookingId, departureDate, departureLocation, firstName,
				flightId, flightName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Booking))
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(arrivalDate, other.arrivalDate) && Objects.equals(arrivalLocation, other.arrivalLocation)
				&& Objects.equals(bookingId, other.bookingId) && Objects.equals(departureDate, other.departureDate)
				&& Objects.equals(departureLocation, other.departureLocation)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(flightId, other.flightId)
				&& Objects.equals(flightName, other.flightName) && Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Booking [bookingId=");
		builder.append(bookingId);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", flightName=");
		builder.append(flightName);
		builder.append(", flightId=");
		builder.append(flightId);
		builder.append(", departureLocation=");
		builder.append(departureLocation);
		builder.append(", departureDate=");
		builder.append(departureDate);
		builder.append(", arrivalLocation=");
		builder.append(arrivalLocation);
		builder.append(", arrivalDate=");
		builder.append(arrivalDate);
		builder.append("]");
		return builder.toString();
	}
}
