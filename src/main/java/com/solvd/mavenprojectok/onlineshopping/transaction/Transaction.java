package com.solvd.mavenprojectok.onlineshopping.transaction;

import java.util.LinkedList;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.mavenprojectok.onlineshopping.cart.Cart;
import com.solvd.mavenprojectok.onlineshopping.catalog.Computer;
import com.solvd.mavenprojectok.onlineshopping.catalog.SmartPhone;
import com.solvd.mavenprojectok.onlineshopping.catalog.SmartTV;
import com.solvd.mavenprojectok.onlineshopping.exception.InsufficientBalanceException;
import com.solvd.mavenprojectok.onlineshopping.exception.NoProductsInTheCartException;
import com.solvd.mavenprojectok.onlineshopping.paymentmethod.PaymentMethod;

public class Transaction<T extends PaymentMethod> {
	public static final Logger LOGGER = LogManager.getLogger(Transaction.class);
	private double totalAmountOfMoney;
	private T chosenPaymentMethod;

	public Transaction(double totalAmountOfMoney, T chosenPaymentMethod) {
		this.totalAmountOfMoney = totalAmountOfMoney;
		this.chosenPaymentMethod = chosenPaymentMethod;
	}

	private void payWithPM(BiPredicate<Double, Double> sufficientBalance, IBuy<T> payWithpM)
			throws InsufficientBalanceException {
		if (sufficientBalance.test(totalAmountOfMoney, chosenPaymentMethod.getAvailableBalance())) {
			payWithpM.pay(totalAmountOfMoney, chosenPaymentMethod);
		} else {
			throw new InsufficientBalanceException();
		}
	}

	public void pay(BiPredicate<Double, Double> sufficientBalance, IBuy<T> payWithpM) {
		try {
			payWithPM(sufficientBalance, payWithpM);
		} catch (InsufficientBalanceException e) {
			LOGGER.error("insufficient balance", e);
		}
	}

	private void sell(Cart cart, Consumer<LinkedList<Computer>> sellComputers,
			Consumer<LinkedList<SmartPhone>> sellSmartPhones, Consumer<LinkedList<SmartTV>> sellSmartTVs)
			throws NoProductsInTheCartException {
		if (cart.getComputersInTheCart().isEmpty() && cart.getSmartPhonesInTheCart().isEmpty()
				&& cart.getSmartTVsInTheCart().isEmpty()) {
			throw new NoProductsInTheCartException();
		} else {
			sellComputers.accept(cart.getComputersInTheCart());
			cart.getComputersInTheCart().clear();
			sellSmartPhones.accept(cart.getSmartPhonesInTheCart());
			cart.getSmartPhonesInTheCart().clear();
			sellSmartTVs.accept(cart.getSmartTVsInTheCart());
			cart.getSmartTVsInTheCart().clear();
		}
	}

	public void sellProducts(Cart cart, Consumer<LinkedList<Computer>> sellComputers,
			Consumer<LinkedList<SmartPhone>> sellSmartPhones, Consumer<LinkedList<SmartTV>> sellSmartTVs) {
		try {
			sell(cart, sellComputers, sellSmartPhones, sellSmartTVs);
		} catch (NoProductsInTheCartException e) {
			LOGGER.info("Your cart is empty! add some products to be able to continue shopping", e);
		}
	}

	public void getTransactionTicket() {
		LOGGER.info("---------------------------------");
		LOGGER.info("THANK YOU FOR BUYING OUR PRODUCTS");
		LOGGER.info("---------------------------------");
		LOGGER.info("_______Transaction details_______");
		LOGGER.info("Total: " + totalAmountOfMoney);
		LOGGER.info(
				"Costumer: " + chosenPaymentMethod.holder.getName() + " " + chosenPaymentMethod.holder.getSurname());
		LOGGER.info("Paid with " + chosenPaymentMethod);
		LOGGER.info("_________________________________");
	}

}
