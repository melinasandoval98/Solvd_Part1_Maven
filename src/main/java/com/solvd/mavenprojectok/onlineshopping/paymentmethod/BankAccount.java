package com.solvd.mavenprojectok.onlineshopping.paymentmethod;

public class BankAccount extends PaymentMethod {
	private long accountNumber;
	
	public BankAccount() {
		super();
	}
	
	public BankAccount(long accountNumber, double availableBalance) {
		this.accountNumber = accountNumber;
		this.setAvailableBalance(availableBalance);
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
}
