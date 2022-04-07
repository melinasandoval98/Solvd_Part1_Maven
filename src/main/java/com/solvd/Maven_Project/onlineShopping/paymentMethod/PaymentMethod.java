package com.solvd.Maven_Project.onlineShopping.paymentMethod;

import com.solvd.Maven_Project.onlineShopping.person.Person;

public abstract class PaymentMethod {
	private String holderName;
	private String holderSurname;
	private double availableBalance;

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getHolderSurname() {
		return holderSurname;
	}

	public void setHolderSurname(String holderSurname) {
		this.holderSurname = holderSurname;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public void setPaymentMethodHolder() {
		setHolderName(Person.getName());
		setHolderSurname(Person.getSurname());

	}
}
