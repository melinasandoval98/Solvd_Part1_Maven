package com.solvd.mavenprojectok.onlineshopping.person;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.mavenprojectok.onlineshopping.catalog.Catalog;
import com.solvd.mavenprojectok.onlineshopping.paymentmethod.BankAccount;
import com.solvd.mavenprojectok.onlineshopping.paymentmethod.CreditCard;
import com.solvd.mavenprojectok.onlineshopping.paymentmethod.DiscountCoupon;

public class Costumer extends Person {
	public static final Logger LOGGER = LogManager.getLogger(Catalog.class);
	private UserAccount userAccount;

	public Costumer() {
		super();
	}

	public Costumer(String name, String surname, int iD, Adress adress, Date dateOfBirth, Gender gender,
			UserAccount userAccount) {
		super(name, surname, iD, adress, dateOfBirth, gender);
		this.setUserAccount(userAccount);
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	@Override
	public void createWallet() {
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

	@Override
	public String toString() {
		return "Costumer [userAccount=" + userAccount + ", name=" + name + ", surname=" + surname + ", iD=" + iD
				+ ", nationality=" + nationality + ", adress=" + adress + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", phoneNumber=" + phoneNumber + "]";
	}

}
