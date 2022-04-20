package com.solvd.mavenprojectok.onlineshopping.person;

public class PhoneNumber {
	private int countryCode;
	private Integer number;
	private long phoneNumber;

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PhoneNumber(int countryCode, Integer number, long phoneNumber) {
		super();
		this.countryCode = countryCode;
		this.number = number;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "(" + countryCode + ") " + number + " " + phoneNumber;
	}

}
