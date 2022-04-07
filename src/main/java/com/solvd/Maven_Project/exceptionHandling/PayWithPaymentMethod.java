package com.solvd.Maven_Project.exceptionHandling;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.Maven_Project.exception.InsufficientBalanceException;
import com.solvd.Maven_Project.olineShopping.shopping.Cart;
import com.solvd.Maven_Project.onlineShopping.paymentMethod.BankAccount;
import com.solvd.Maven_Project.onlineShopping.paymentMethod.CreditCard;
import com.solvd.Maven_Project.onlineShopping.paymentMethod.DiscountCoupon;
import com.solvd.Maven_Project.onlineShopping.transaction.IBuy;

public class PayWithPaymentMethod implements IBuy {
	public static final Logger LOGGER = LogManager.getLogger(PayWithPaymentMethod.class);
	Cart cart = new Cart();
	CreditCard creditCard = new CreditCard();

	@Override
	public void calculateTotalCost() {
		double pricePerProduct = 0;
		for (int i = 0; i < cart.getProductPrice().size(); i++) {
			pricePerProduct = pricePerProduct + cart.getProductPrice().get(i);
		}
		cart.setAcumulatedPrice(pricePerProduct);
	}

	public void creditCardbalance() throws InsufficientBalanceException {
		if (creditCard.getAvailableBalance() < cart.getAcumulatedPrice()) {
			throw new InsufficientBalanceException();
		}
	}

	public void logErrorInsufficientBalanceException(Exception e) {
		LOGGER.error(e);
		LOGGER.info("Insufficient Balance in the chosen payment method");
	}

	@Override
	public void payWithCreditCard() {
		try {
			creditCardbalance();
		} catch (InsufficientBalanceException e) {
			logErrorInsufficientBalanceException(e);
		}
		creditCard.setAvailableBalance(creditCard.getAvailableBalance() - cart.getAcumulatedPrice());
		cart.setAcumulatedPrice(0.0);
	}

	BankAccount bankAccount = new BankAccount();

	public void bankAccountBalance() throws InsufficientBalanceException {
		if (bankAccount.getAvailableBalance() < cart.getAcumulatedPrice()) {
			throw new InsufficientBalanceException();
		}
	}

	@Override
	public void payByBankTransfer() {
		try {
			bankAccountBalance();
		} catch (InsufficientBalanceException e) {
			logErrorInsufficientBalanceException(e);
		}
		bankAccount.setAvailableBalance(bankAccount.getAvailableBalance() - cart.getAcumulatedPrice());
		cart.setAcumulatedPrice(0.0);
	}

	@Override
	public void applyDiscountCode() {
		DiscountCoupon discountCoupon = new DiscountCoupon();
		Cart cart2 = new Cart();
		cart2.setAcumulatedPrice(cart.getAcumulatedPrice() * (1 - (discountCoupon.getDiscountRate() / 100)));

	}

}
