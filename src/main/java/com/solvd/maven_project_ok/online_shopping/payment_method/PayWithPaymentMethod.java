package com.solvd.maven_project_ok.online_shopping.payment_method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.maven_project_ok.exception.InsufficientBalanceException;
import com.solvd.maven_project_ok.online_shopping.cart.Cart;
import com.solvd.maven_project_ok.online_shopping.catalog.Computer;
import com.solvd.maven_project_ok.online_shopping.transaction.IBuy;

public class PayWithPaymentMethod implements IBuy {
	public static final Logger LOGGER = LogManager.getLogger(PayWithPaymentMethod.class);
	Cart cart = new Cart();
	CreditCard creditCard = new CreditCard();

	@Override
	public double calculateTotalCost() {
		double totalPrice = 0;
		for (Computer computer : cart.getComputersInTheCart()) {
			totalPrice = totalPrice + computer.getPriceInUSD();
		}
		for (Computer computer : cart.getComputersInTheCart()) {
			totalPrice = totalPrice + computer.getPriceInUSD();
		}
		for (Computer computer : cart.getComputersInTheCart()) {
			totalPrice = totalPrice + computer.getPriceInUSD();
		}

		return totalPrice;
	}

	public void creditCardbalance() throws InsufficientBalanceException {
		if (creditCard.getAvailableBalance() < calculateTotalCost()) {
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
	}

	BankAccount bankAccount = new BankAccount();

	public void bankAccountBalance() throws InsufficientBalanceException {
		if (bankAccount.getAvailableBalance() < calculateTotalCost()) {
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
		bankAccount.setAvailableBalance(bankAccount.getAvailableBalance() - calculateTotalCost());
	}

	@Override
	public void applyDiscountCode() {
		@SuppressWarnings("unused")
		DiscountCoupon discountCoupon = new DiscountCoupon();

	}

}
