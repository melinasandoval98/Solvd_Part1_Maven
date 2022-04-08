package com.solvd.Maven_Project.onlineShopping.transaction;

//This interface determines the behavior of the consumer's funds during 
//the purchase of the products added to the cart

public interface IBuy {
	
	public abstract void calculateTotalCost();

	public abstract  void payWithCreditCard();
	
	public abstract  void payByBankTransfer();
	
	public abstract  void applyDiscountCode();

}
