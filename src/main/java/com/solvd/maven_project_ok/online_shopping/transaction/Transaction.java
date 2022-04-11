package com.solvd.maven_project_ok.online_shopping.transaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.maven_project_ok.online_shopping.cart.Cart;
import com.solvd.maven_project_ok.online_shopping.catalog.Catalog;
import com.solvd.maven_project_ok.online_shopping.catalog.Computer;
import com.solvd.maven_project_ok.online_shopping.catalog.Product;
import com.solvd.maven_project_ok.online_shopping.catalog.ReadNumericOptionsFromUser;
import com.solvd.maven_project_ok.online_shopping.catalog.SmartPhone;
import com.solvd.maven_project_ok.online_shopping.catalog.SmartTV;
import com.solvd.maven_project_ok.online_shopping.payment_method.PayWithPaymentMethod;
import com.solvd.maven_project_ok.online_shopping.payment_method.PaymentMethods;

public class Transaction implements ISell {
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
			pay.payByBankTransfer();
			break;
		case DISCOUNT_COUPON:
			pay.applyDiscountCode();
			pay.payWithCreditCard();
			break;
		}
	}

	@Override
	public void sellComputer(Computer c) {
		c.setAvailiability(c.getAvailiability() - 1);
		cart.setComputersInTheCart(null);
	}

	@Override
	public void sellSmartPhone(SmartPhone sm) {
		sm.setAvailiability(sm.getAvailiability() - 1);
		cart.setSmartPhonesInTheCart(null);

	}

	@Override
	public void sellSmartTV(SmartTV st) {
		st.setAvailiability(st.getAvailiability() - 1);
		cart.setSmartTVsInTheCart(null);

	}

}
