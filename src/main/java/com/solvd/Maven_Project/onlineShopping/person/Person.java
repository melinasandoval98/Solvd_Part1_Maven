package com.solvd.Maven_Project.onlineShopping.person;

import java.util.Date;

import com.solvd.Maven_Project.onlineShopping.paymentMethod.BankAccount;
import com.solvd.Maven_Project.onlineShopping.paymentMethod.CreditCard;
import com.solvd.Maven_Project.onlineShopping.paymentMethod.DiscountCoupon;

public abstract class Person {
	public static String name;
	public static String surname;
	private int iD;
	private String adress;
	private Date dateOfBirth = new Date();

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

	public void personsWallet() {
		BankAccount bankAccount = new BankAccount((Math.round((Math.random() + 1) * Math.pow(10, 17))),
				Math.random() * Math.pow(10, 5 * Math.random()));
		bankAccount.setPaymentMethodHolder();
		CreditCard creditCard = new CreditCard((Math.round((Math.random() + 1) * Math.pow(10, 15))),
				(int) Math.round(Math.random() * 999), Math.random() * Math.pow(10, 5 * Math.random()));
		creditCard.setPaymentMethodHolder();
		DiscountCoupon discountCoupon = new DiscountCoupon((Math.round((Math.random() + 1) * 10000)),
				(int) Math.round((Math.random() + 1) * 10), Math.random() * Math.pow(10, 5 * Math.random()));
		discountCoupon.setPaymentMethodHolder();
	}
}
