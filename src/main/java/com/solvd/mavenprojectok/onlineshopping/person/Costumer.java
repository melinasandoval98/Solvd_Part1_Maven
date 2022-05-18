package com.solvd.mavenprojectok.onlineshopping.person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.mavenprojectok.onlineshopping.paymentmethod.PaymentMethod;

public class Costumer extends Person {
	public static final Logger LOGGER = LogManager.getLogger(Costumer.class);
	private UserAccount userAccount;
	private List<PaymentMethod> wallet = new ArrayList<PaymentMethod>();

	public Costumer() {
		super();
	}

	public Costumer(String name, String surname, int iD, Adress adress, Date dateOfBirth, Gender gender,
			PhoneNumber phoneNumber, UserAccount userAccount) {
		super(name, surname, iD, adress, dateOfBirth, gender, phoneNumber);
		this.setUserAccount(userAccount);
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public List<PaymentMethod> getWallet() {
		return wallet;
	}

	@Override
	public void createWallet(PaymentMethod pMethod) {
		wallet.add(pMethod);
	}

	@Override
	public String toString() {
		return "Costumer [userAccount=" + userAccount + ", name=" + name + ", surname=" + surname + ", iD=" + iD
				+ ", nationality=" + nationality + ", adress=" + adress + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", phoneNumber=" + phoneNumber + "]";
	}

}
