package com.solvd.mavenprojectok.onlineshopping.paymentmethod;

public class CreditCard extends PaymentMethod {
	private long creditCardNumber;
	private int cvv;
	
	public CreditCard() {
		super();
	}
	
	public CreditCard(long creditCardNumber, int cvv, double availableBalance) {
		this.creditCardNumber = creditCardNumber;
		this.cvv = cvv;
		this.setAvailableBalance(availableBalance);
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
	
}
