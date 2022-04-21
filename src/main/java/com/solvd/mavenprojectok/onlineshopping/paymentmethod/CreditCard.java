package com.solvd.mavenprojectok.onlineshopping.paymentmethod;

import com.solvd.mavenprojectok.onlineshopping.person.Person;

public class CreditCard extends PaymentMethod {
	private long creditCardNumber;
	private int cvv;

	public CreditCard(Person holder, double availableBalance, long creditCardNumber, int cvv) {
		super(holder, availableBalance);
		this.creditCardNumber = creditCardNumber;
		this.cvv = cvv;
	}

	public long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(int creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "CreditCard [creditCardNumber=" + creditCardNumber + "]";
	}

}
