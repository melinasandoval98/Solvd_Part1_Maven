package com.solvd.mavenprojectok.onlineshopping.transaction;
//Agregar la opción de registrar venta!!!!!!!!!!!!!!!!!!!!1 Incluso puedo usar un queue para registrar las compras de distintos usuarios.
//Cuando registe las ventas debo registrar los datos del usuario comprador, sus datos del método de pago, número de transacción.
//Debo crear un método para crear un número de operación!! Puedo ver si puedo usar Lambda Expresions para eso.
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.mavenprojectok.onlineshopping.cart.Cart;
import com.solvd.mavenprojectok.onlineshopping.catalog.Catalog;
import com.solvd.mavenprojectok.onlineshopping.catalog.ReadNumericOptionsFromUser;
import com.solvd.mavenprojectok.onlineshopping.exception.NoProductsInTheCartException;
import com.solvd.mavenprojectok.onlineshopping.paymentmethod.PayWithPaymentMethod;
import com.solvd.mavenprojectok.onlineshopping.paymentmethod.PaymentMethods;

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
