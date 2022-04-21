package com.solvd.mavenprojectok.onlineshopping.transaction;

import com.solvd.mavenprojectok.onlineshopping.paymentmethod.PaymentMethod;

@FunctionalInterface
public interface IBuy<T extends PaymentMethod> {
	void pay(double totalToPay, T pMethod);
}
