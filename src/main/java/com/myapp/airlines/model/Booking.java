//package com.myapp.airlines.model;
//import java.util.List;
//import java.util.Objects;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.validation.constraints.NotNull;
//
//
//@Entity(name="Booking")
//public class Booking {
//	
//	
//	@Column(name = "first_name")
//	@NotNull
//	private String first_name;
//	
//	@Column(name = "FLIGHT_NAME")
//	@NotNull
//	private String flightName;
//	
//	@Column(name = "ARRIVAL_DATE")
//	@NotNull
//	private String arrivalDate;
//	
//	@Column(name = "ARRIVAL_TIME")
//	@NotNull
//	private String arrivalTime;
//
//	@Column(name = "ARRIVAL_LOCATION")
//	@NotNull
//	private String arrivalLocation;
//
//	public Booking() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Booking(@NotNull String first_name, @NotNull String flightName, @NotNull String arrivalDate,
//			@NotNull String arrivalTime, @NotNull String arrivalLocation) {
//		this.first_name = first_name;
//		this.flightName = flightName;
//		this.arrivalDate = arrivalDate;
//		this.arrivalTime = arrivalTime;
//		this.arrivalLocation = arrivalLocation;
//	}
//
//	public String getFirst_name() {
//		return first_name;
//	}
//
//	public void setFirst_name(String first_name) {
//		this.first_name = first_name;
//	}
//
//	public String getFlightName() {
//		return flightName;
//	}
//
//	public void setFlightName(String flightName) {
//		this.flightName = flightName;
//	}
//
//	public String getArrivalDate() {
//		return arrivalDate;
//	}
//
//	public void setArrivalDate(String arrivalDate) {
//		this.arrivalDate = arrivalDate;
//	}
//
//	public String getArrivalTime() {
//		return arrivalTime;
//	}
//
//	public void setArrivalTime(String arrivalTime) {
//		this.arrivalTime = arrivalTime;
//	}
//
//	public String getArrivalLocation() {
//		return arrivalLocation;
//	}
//
//	public void setArrivalLocation(String arrivalLocation) {
//		this.arrivalLocation = arrivalLocation;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(arrivalDate, arrivalLocation, arrivalTime, first_name, flightName);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (!(obj instanceof Booking))
//			return false;
//		Booking other = (Booking) obj;
//		return Objects.equals(arrivalDate, other.arrivalDate) && Objects.equals(arrivalLocation, other.arrivalLocation)
//				&& Objects.equals(arrivalTime, other.arrivalTime) && Objects.equals(first_name, other.first_name)
//				&& Objects.equals(flightName, other.flightName);
//	}
//
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Booking [first_name=");
//		builder.append(first_name);
//		builder.append(", flightName=");
//		builder.append(flightName);
//		builder.append(", arrivalDate=");
//		builder.append(arrivalDate);
//		builder.append(", arrivalTime=");
//		builder.append(arrivalTime);
//		builder.append(", arrivalLocation=");
//		builder.append(arrivalLocation);
//		builder.append("]");
//		return builder.toString();
//	}
//
//	
//	
//	
//	
//	
//}
