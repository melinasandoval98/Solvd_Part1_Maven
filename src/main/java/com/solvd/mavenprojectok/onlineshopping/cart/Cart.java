package com.solvd.mavenprojectok.onlineshopping.cart;

import org.apache.logging.log4j.Logger;

import com.solvd.mavenprojectok.onlineshopping.catalog.Computer;
import com.solvd.mavenprojectok.onlineshopping.catalog.SmartPhone;
import com.solvd.mavenprojectok.onlineshopping.catalog.SmartTV;
import com.solvd.mavenprojectok.onlineshopping.exception.ProductNotAvilableException;

import org.apache.logging.log4j.LogManager;

public class Cart {
	public static final Logger LOGGER = LogManager.getLogger(Cart.class);
	private CustomLinkedList<Computer> computersInTheCart = new CustomLinkedList<Computer>();
	private CustomLinkedList<SmartPhone> smartPhonesInTheCart = new CustomLinkedList<SmartPhone>();
	private CustomLinkedList<SmartTV> smartTVsInTheCart = new CustomLinkedList<SmartTV>();
	private double accumulatedPrice = 0;

	public CustomLinkedList<Computer> getComputersInTheCart() {
		return computersInTheCart;
	}

	public CustomLinkedList<SmartPhone> getSmartPhonesInTheCart() {
		return smartPhonesInTheCart;
	}

	public CustomLinkedList<SmartTV> getSmartTVsInTheCart() {
		return smartTVsInTheCart;
	}

	public double getAccumulatedPrice() {
		return accumulatedPrice;
	}

	public void addComputerToTheCart(Computer computer) throws ProductNotAvilableException {
		if (computer.availiability > 0) {
			computersInTheCart.insert(computer);
			accumulatedPrice += computer.priceInUSD;
		} else {
			throw new ProductNotAvilableException();
		}
	}

	public void addProductToCart(Computer computer) {
		try {
			addComputerToTheCart(computer);
		} catch (ProductNotAvilableException e) {
			LOGGER.error("This computer is not available due to lack of stock, sorry for the inconvenience", e);
		}
	}

	public void addSmartPhoneToTheCart(SmartPhone smartPhone) throws ProductNotAvilableException {
		if (smartPhone.availiability > 0) {
			smartPhonesInTheCart.insert(smartPhone);
			accumulatedPrice += smartPhone.priceInUSD;
		} else {
			throw new ProductNotAvilableException();
		}
	}

	public void addProductToCart(SmartPhone smartPhone) {
		try {
			addSmartPhoneToTheCart(smartPhone);
		} catch (ProductNotAvilableException e) {
			LOGGER.error("This smart phone is not available due to lack of stock, sorry for the inconvenience", e);
		}
	}

	public void addSmartTVToTheCart(SmartTV smartTV) throws ProductNotAvilableException {
		if (smartTV.availiability > 0) {
			smartTVsInTheCart.insert(smartTV);
			accumulatedPrice += smartTV.priceInUSD;
		} else {
			throw new ProductNotAvilableException();
		}
	}

	public void addProductToCart(SmartTV smartTV) {
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
		computersInTheCart.stream().forEach(computer -> LOGGER.info(computer.getData().getBrand() + "\t"
				+ computer.getData().getModel() + "\t" + computer.getData().getPriceInUSD()));
		smartPhonesInTheCart.stream().forEach(smartPhone -> LOGGER.info(smartPhone.getData().getBrand() + "\t"
				+ smartPhone.getData().getModel() + "\t" + smartPhone.getData().getPriceInUSD()));
		smartTVsInTheCart.stream().forEach(smartTV -> LOGGER.info(smartTV.getData().getBrand() + "\t"
				+ smartTV.getData().getModel() + "\t" + smartTV.getData().getPriceInUSD()));
		LOGGER.info("--------------------------------------");
		LOGGER.info("Accumulated Price: " + accumulatedPrice + " USD\n");
	}

}
