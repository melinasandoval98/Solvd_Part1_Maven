package com.solvd.maven_project_ok.online_shopping.transaction;

//This interface determines the behavior of the consumer's funds during 
//the purchase of the products added to the cart

public interface IBuy {
	
	public abstract double calculateTotalCost();

	public abstract  void payWithCreditCard();
	
	public abstract  void payByBankTransfer();
	
	public abstract  void applyDiscountCode();

}
