package com.solvd.mavenprojectok.onlineshopping.person;

import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;

import com.solvd.mavenprojectok.onlineshopping.paymentmethod.PaymentMethod;

public abstract class Person {
	protected String name;
	protected String surname;
	protected int iD;
	protected String nationality;
	protected Adress adress;
	protected Date dateOfBirth;
	protected Gender gender;
	protected PhoneNumber phoneNumber;

	public Person() {

	}

	public Person(String name, String surname, int iD, Adress adress, Date dateOfBirth, Gender gender,
			PhoneNumber phoneNumber) {
		this.name = name;
		this.surname = surname;
		this.iD = iD;
		this.setAdress(adress);
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getID() {
		return iD;
	}

	public void setID(int iD) {
		this.iD = iD;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(int day, int month, int year) {
		DateUtils.setDays(dateOfBirth, day);
		DateUtils.setMonths(dateOfBirth, month);
		DateUtils.setYears(dateOfBirth, year);
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public abstract void createWallet(PaymentMethod pMethod);

	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", iD=" + iD + ", nationality=" + nationality
				+ ", adress=" + adress + ", dateOfBirth=" + DateUtils.toCalendar(dateOfBirth) + ", gender=" + gender
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}
