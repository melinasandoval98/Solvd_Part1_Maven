package com.solvd.mavenprojectok.onlineshopping.paymentmethod;

import com.solvd.mavenprojectok.onlineshopping.person.Person;

public class BankAccount extends PaymentMethod {
	private long accountNumber;

	public BankAccount(Person holder, double availableBalance, long accountNumber) {
		super(holder, availableBalance);
		this.accountNumber = accountNumber;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + "]";
	}

}
