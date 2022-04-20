package com.solvd.mavenprojectok.onlineshopping.cart;

import org.apache.logging.log4j.Logger;

import com.solvd.mavenprojectok.onlineshopping.catalog.Computer;
import com.solvd.mavenprojectok.onlineshopping.catalog.SmartPhone;
import com.solvd.mavenprojectok.onlineshopping.catalog.SmartTV;
import com.solvd.mavenprojectok.onlineshopping.exception.ProductNotAvilableException;

import java.util.LinkedList;

import org.apache.logging.log4j.LogManager;

public class Cart {
	public static final Logger LOGGER = LogManager.getLogger(Cart.class);
	private LinkedList<Computer> computersInTheCart = new LinkedList<Computer>();
	private LinkedList<SmartPhone> smartPhonesInTheCart = new LinkedList<SmartPhone>();
	private LinkedList<SmartTV> smartTVsInTheCart = new LinkedList<SmartTV>();
	private double accumulatedPrice = 0;

	public LinkedList<Computer> getComputersInTheCart() {
		return computersInTheCart;
	}

	public LinkedList<SmartPhone> getSmartPhonesInTheCart() {
		return smartPhonesInTheCart;
	}

	public LinkedList<SmartTV> getSmartTVsInTheCart() {
		return smartTVsInTheCart;
	}

	public double getAccumulatedPrice() {
		return accumulatedPrice;
	}

	public void addComputerToTheCart(Computer computer) throws ProductNotAvilableException {
		if (computer.availiability > 0) {
			computersInTheCart.add(computer);
			accumulatedPrice += computer.priceInUSD;
		} else {
			throw new ProductNotAvilableException();
		}
	}

	public void addComputer(Computer computer) {
		try {
			addComputerToTheCart(computer);
		} catch (ProductNotAvilableException e) {
			LOGGER.error("This computer is not available due to lack of stock, sorry for the inconvenience", e);
		}
	}

	public void addSmartPhoneToTheCart(SmartPhone smartPhone) throws ProductNotAvilableException {
		if (smartPhone.availiability > 0) {
			smartPhonesInTheCart.add(smartPhone);
			accumulatedPrice += smartPhone.priceInUSD;
		} else {
			throw new ProductNotAvilableException();
		}
	}

	public void addSmartPhone(SmartPhone smartPhone) {
		try {
			addSmartPhoneToTheCart(smartPhone);
		} catch (ProductNotAvilableException e) {
			LOGGER.error("This smart phone is not available due to lack of stock, sorry for the inconvenience", e);
		}
	}

	public void addSmartTVToTheCart(SmartTV smartTV) throws ProductNotAvilableException {
		if (smartTV.availiability > 0) {
			smartTVsInTheCart.add(smartTV);
			accumulatedPrice += smartTV.priceInUSD;
		} else {
			throw new ProductNotAvilableException();
		}
	}

	public void addSmartTV(SmartTV smartTV) {
		try {
			addSmartTVToTheCart(smartTV);
		} catch (ProductNotAvilableException e) {
			LOGGER.error("This smart TV is not available due to lack of stock, sorry for the inconvenience", e);
		}
	}

	public void showProductsInTheCart() {
		LOGGER.info("Products in the Cart:");
		LOGGER.info("--------------------------------------");
		LOGGER.info("BRAND\tMODEL\t\tPRICE(USD)");
		LOGGER.info("--------------------------------------");
		computersInTheCart.stream().forEach(computer -> LOGGER
				.info(computer.getBrand() + "\t" + computer.getModel() + "\t" + computer.getPriceInUSD()));
		smartPhonesInTheCart.stream().forEach(smartPhone -> LOGGER
				.info(smartPhone.getBrand() + "\t" + smartPhone.getModel() + "\t" + smartPhone.getPriceInUSD()));
		smartTVsInTheCart.stream().forEach(smartTV -> LOGGER
				.info(smartTV.getBrand() + "\t" + smartTV.getModel() + "\t" + smartTV.getPriceInUSD()));
		LOGGER.info("--------------------------------------");
		LOGGER.info("Accumulated Price: " + accumulatedPrice + " USD\n");
	}

}
