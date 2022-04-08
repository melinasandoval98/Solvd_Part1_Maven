package com.solvd.Maven_Project.onlineShopping.transaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.Maven_Project.exceptionHandling.PayWithPaymentMethod;
import com.solvd.Maven_Project.exceptionHandling.ReadNumericOptionsFromUser;
import com.solvd.Maven_Project.olineShopping.shopping.Cart;

public class Transaction implements ISell {
	public static final Logger LOGGER = LogManager.getLogger(Transaction.class);

	Cart cart = new Cart();
	ReadNumericOptionsFromUser read = new ReadNumericOptionsFromUser();

	public void buy(int choosePaymentMethod) {
		PayWithPaymentMethod pay = new PayWithPaymentMethod();
		switch (choosePaymentMethod) {
		case (1):
			pay.payWithCreditCard();
			sellItem();
			break;
		case (2):
			pay.payByBankTransfer();
			sellItem();
			break;
		case (3):
			pay.applyDiscountCode();
			pay.payWithCreditCard();
			sellItem();
			break;
		}
	}

	@Override
	public void sellItem() {
		for (Object product : cart.getProductsInTheCart()) {
			cart.getProductsInTheCart().remove(product);
		}

	}

}
