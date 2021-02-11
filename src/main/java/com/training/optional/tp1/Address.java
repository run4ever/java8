package com.training.optional.tp1;

import java.util.Optional;

public class Address {
	private Optional<String> street;
	private String city;

	public Address(String street, String city) {
		this.street = Optional.ofNullable(street);
		this.city = city;
	}

	public Optional<String> getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}
}
