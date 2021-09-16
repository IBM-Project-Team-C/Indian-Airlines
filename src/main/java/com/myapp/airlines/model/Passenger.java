package com.myapp.airlines.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "passangerdetails")
public class Passenger {

	@Id
	@Column(name = "passenger_id")
	private Integer passenger_id;

	@Column(name = "first_name")
	@NotNull
	private String first_name;

	@Column(name = "last_name")
	@NotNull
	private String last_name;

	@Column(name = "email")
	@NotNull
	private String email;

	@Column(name = "phone")
	@NotNull
	private String phone;

	@Column(name = "age")
	@NotNull
	private Integer age;

	@Column(name = "gender")
	@NotNull
	private String gender;


	public Passenger() {
		// TODO Auto-generated constructor stub
	}


	public Passenger(Integer passenger_id, @NotNull String first_name, @NotNull String last_name, @NotNull String email,
			@NotNull String phone, @NotNull Integer age, @NotNull String gender) {
		this.passenger_id = passenger_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
	}

	public Integer getPassenger_id() {
		return passenger_id;
	}

	public void setPassenger_id(Integer passenger_id) {
		this.passenger_id = passenger_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, email, first_name, gender, last_name, passenger_id, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Passenger))
			return false;
		Passenger other = (Passenger) obj;
		return Objects.equals(age, other.age) && Objects.equals(email, other.email)
				&& Objects.equals(first_name, other.first_name) && Objects.equals(gender, other.gender)
				&& Objects.equals(last_name, other.last_name) && Objects.equals(passenger_id, other.passenger_id)
				&& Objects.equals(phone, other.phone);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Passenger [passenger_id=");
		builder.append(passenger_id);
		builder.append(", first_name=");
		builder.append(first_name);
		builder.append(", last_name=");
		builder.append(last_name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", age=");
		builder.append(age);
		builder.append(", gender=");
		builder.append(gender);
		builder.append("]");
		return builder.toString();
	}

	
}