package com.solvd.mavenprojectok.onlineshopping.paymentmethod;

import com.solvd.mavenprojectok.onlineshopping.person.Person;

public abstract class PaymentMethod {
	public Person holder;
	public double availableBalance;
	public static int numberOfPMethodsCreated;

	public PaymentMethod(Person holder, double availableBalance) {
		this.holder = holder;
		this.availableBalance = availableBalance;
		numberOfPMethodsCreated++;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public Person getHolder() {
		return holder;
	}

	public void setHolder(Person holder) {
		this.holder = holder;
	}
}
