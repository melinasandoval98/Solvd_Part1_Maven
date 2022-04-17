package com.solvd.mavenprojectok.onlineshopping.transaction;

//This interface determines the behavior of the consumer's funds during 
//the purchase of the products added to the cart
public interface IBuy {

	double calculateTotalCost();

	void payWithCreditCard();

	void payWithBankTransfer();

	void applyDiscountCupon();
}
