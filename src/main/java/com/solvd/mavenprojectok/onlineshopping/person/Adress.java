package com.solvd.mavenprojectok.onlineshopping.person;

public class Adress {
	private int streetNumber;
	private String streetName;
	private String city;
	private String Country;

	public Adress(int streetNumber, String streetName, String city, String country) {
		super();
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		Country = country;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}
}
