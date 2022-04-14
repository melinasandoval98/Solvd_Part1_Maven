package com.solvd.maven_project_ok.online_shopping.transaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.maven_project_ok.exception.NoProductsInTheCartException;
import com.solvd.maven_project_ok.online_shopping.cart.Cart;
import com.solvd.maven_project_ok.online_shopping.catalog.Catalog;
import com.solvd.maven_project_ok.online_shopping.catalog.ReadNumericOptionsFromUser;
import com.solvd.maven_project_ok.online_shopping.payment_method.PayWithPaymentMethod;
import com.solvd.maven_project_ok.online_shopping.payment_method.PaymentMethods;

public class Transaction {
	public static final Logger LOGGER = LogManager.getLogger(Transaction.class);

	Catalog catalog = new Catalog();
	Cart cart = new Cart();
	ReadNumericOptionsFromUser read = new ReadNumericOptionsFromUser();

	public void pay(PaymentMethods paymentMethod) {
		PayWithPaymentMethod pay = new PayWithPaymentMethod();
		switch (paymentMethod) {
		case CREDIT_CARD:
			pay.payWithCreditCard();
			break;
		case BANK_TRANSFER:
			pay.payWithBankTransfer();
			break;
		case DISCOUNT_COUPON:
			pay.applyDiscountCupon();
			pay.payWithCreditCard();
			break;
		}
	}

	public void sellProductsInTheCart() throws NoProductsInTheCartException {
		ISell sellComputers = () -> cart.getComputersInTheCart().stream()
				.forEach((computer) -> computer.setAvailiability(computer.getAvailiability() - 1));
		cart.getComputersInTheCart().clear();
		ISell sellSmartPhones = () -> cart.getSmartPhonesInTheCart().stream()
				.forEach((smartPhone) -> smartPhone.setAvailiability(smartPhone.getAvailiability() - 1));
		cart.getSmartPhonesInTheCart().clear();
		ISell sellSmartTVs = () -> cart.getSmartTVsInTheCart().stream()
				.forEach((smartTV) -> smartTV.setAvailiability(smartTV.getAvailiability() - 1));
		cart.getSmartTVsInTheCart().clear();
		if (cart.getComputersInTheCart().size() + cart.getSmartPhonesInTheCart().size()
				+ cart.getSmartTVsInTheCart().size() == 0) {
			throw new NoProductsInTheCartException();
		} else {
			sellComputers.sell();
			sellSmartPhones.sell();
			sellSmartTVs.sell();
		}
	}
}
