package com.solvd.maven_project_ok.online_shopping.person;

import java.util.Date;

public abstract class Person {
	public static String name;
	public static String surname;
	private int iD;
	private String adress;
	private Date dateOfBirth = new Date();
	private String personGender;

	public String getPersonGender(Gender gender) {
		switch (gender) {
		case FEMALE:
			personGender = "Female";
		case MALE:
			personGender = "Male";
		default:
			break;
		}
		return personGender;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Person.name = name;
	}

	public static String getSurname() {
		return surname;
	}

	public static void setSurname(String surname) {
		Person.surname = surname;
	}

	public int getID() {
		return iD;
	}

	public void setID(int iD) {
		this.iD = iD;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Date getDateOfBirth(int day, int month, int year) {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public abstract void createWallet();
}
