package com.myapp.airlines.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "flight")
public class Flight {

	@Id
	@Column(name = "FLIGHT_ID")
	public String flightId;

	@Column(name = "FLIGHT_NAME")
	@NotNull
	private String flightName;

	@Column(name = "ARRIVAL_DATE")
	@NotNull
	private String arrivalDate;

	@Column(name = "DEPARTURE_DATE")
	@NotNull
	private String departureDate;

	@Column(name = "ARRIVAL_TIME")
	@NotNull
	private String arrivalTime;

	@Column(name = "DEPARTURE_TIME")
	@NotNull
	private String departureTime;

	@Column(name = "ARRIVAL_LOCATION")
	@NotNull
	private String arrivalLocation;

	@Column(name = "DEPARTURE_LOCATION")
	@NotNull
	private String departureLocation;

	@Column(name = "FLIGHT_FARE")
	@NotNull
	private Integer flightFare;

	@Column(name = "AVAILABLE_SEATS")
	@NotNull
	private Integer availableSeats;

	public Flight() {
		// TODO Auto-generated constructor stub
	}

	

	public Flight(String flightId, @NotNull String flightName, @NotNull String arrivalDate,
			@NotNull String departureDate, @NotNull String arrivalTime, @NotNull String departureTime,
			@NotNull String arrivalLocation, @NotNull String departureLocation, @NotNull Integer flightFare,
			@NotNull Integer availableSeats) {
		this.flightId = flightId;
		this.flightName = flightName;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.arrivalLocation = arrivalLocation;
		this.departureLocation = departureLocation;
		this.flightFare = flightFare;
		this.availableSeats = availableSeats;
	}



	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public Integer getFlightFare() {
		return flightFare;
	}

	public void setFlightFare(Integer flightFare) {
		this.flightFare = flightFare;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrivalDate, arrivalLocation, arrivalTime, availableSeats, departureDate, departureLocation,
				departureTime, flightFare, flightId, flightName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Flight))
			return false;
		Flight other = (Flight) obj;
		return Objects.equals(arrivalDate, other.arrivalDate) && Objects.equals(arrivalLocation, other.arrivalLocation)
				&& Objects.equals(arrivalTime, other.arrivalTime)
				&& Objects.equals(availableSeats, other.availableSeats)
				&& Objects.equals(departureDate, other.departureDate)
				&& Objects.equals(departureLocation, other.departureLocation)
				&& Objects.equals(departureTime, other.departureTime) && Objects.equals(flightFare, other.flightFare)
				&& Objects.equals(flightId, other.flightId) && Objects.equals(flightName, other.flightName);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Flight [flightId=");
		builder.append(flightId);
		builder.append(", flightName=");
		builder.append(flightName);
		builder.append(", arrivalDate=");
		builder.append(arrivalDate);
		builder.append(", departureDate=");
		builder.append(departureDate);
		builder.append(", arrivalTime=");
		builder.append(arrivalTime);
		builder.append(", departureTime=");
		builder.append(departureTime);
		builder.append(", arrivalLocation=");
		builder.append(arrivalLocation);
		builder.append(", departureLocation=");
		builder.append(departureLocation);
		builder.append(", flightFare=");
		builder.append(flightFare);
		builder.append(", availableSeats=");
		builder.append(availableSeats);
		builder.append("]");
		return builder.toString();
	}
}
