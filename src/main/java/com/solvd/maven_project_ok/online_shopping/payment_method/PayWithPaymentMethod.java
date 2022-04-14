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
	BankAccount bankAccount = new BankAccount();
	DiscountCoupon discountCoupon = new DiscountCoupon();

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
		} else {
			creditCard.setAvailableBalance(creditCard.getAvailableBalance() - calculateTotalCost());
		}
	}

	@Override
	public void payWithCreditCard() {
		try {
			creditCardbalance();
		} catch (InsufficientBalanceException e) {
			LOGGER.info("Insufficient Balance in your Credit Card", e);
		}
	}

	public void bankAccountBalance() throws InsufficientBalanceException {
		if (bankAccount.getAvailableBalance() < calculateTotalCost()) {
			throw new InsufficientBalanceException();
		} else {
			bankAccount.setAvailableBalance(bankAccount.getAvailableBalance() - calculateTotalCost());
		}
	}

	@Override
	public void payWithBankTransfer() {
		try {
			bankAccountBalance();
		} catch (InsufficientBalanceException e) {
			LOGGER.info("Insufficient Balance in your Bank Account", e);
		}
	}

	@Override
	public void applyDiscountCupon() {
		try {
			creditCardbalance();
			creditCard.setAvailableBalance(
					creditCard.getAvailableBalance() + calculateTotalCost() * (1 - discountCoupon.getDiscountRate()));
		} catch (InsufficientBalanceException e) {
			LOGGER.info("Insufficient Balance in your Credit Card", e);
		}
	}

}
