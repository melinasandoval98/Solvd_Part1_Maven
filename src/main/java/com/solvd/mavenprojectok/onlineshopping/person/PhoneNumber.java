package com.solvd.mavenprojectok.onlineshopping.person;

public class PhoneNumber {
	private int countryCode;
	private Integer middleNumber;
	private long phoneNumber;

	public int getCountryCode() {
		return countryCode;
	}

	public PhoneNumber(int countryCode, Integer number, long phoneNumber) {
		super();
		this.countryCode = countryCode;
		this.middleNumber = number;
		this.phoneNumber = phoneNumber;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	public Integer getNumber() {
		return middleNumber;
	}

	public void setNumber(Integer number) {
		this.middleNumber = number;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return middleNumber != null ? "(" + countryCode + ") " + middleNumber + " " + phoneNumber
				: "(" + countryCode + ") " + " " + phoneNumber;
	}

}
