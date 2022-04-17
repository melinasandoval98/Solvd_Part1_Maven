package com.solvd.mavenprojectok.onlineshopping.cart;

import org.apache.logging.log4j.Logger;

import com.solvd.mavenprojectok.onlineshopping.catalog.Computer;
import com.solvd.mavenprojectok.onlineshopping.catalog.SmartPhone;
import com.solvd.mavenprojectok.onlineshopping.catalog.SmartTV;

import java.util.LinkedList;

import org.apache.logging.log4j.LogManager;

public class Cart {
	public static final Logger LOGGER = LogManager.getLogger(Cart.class);
	private LinkedList<Computer> ComputersInTheCart = new LinkedList<Computer>();
	private LinkedList<SmartPhone> SmartPhonesInTheCart = new LinkedList<SmartPhone>();
	private LinkedList<SmartTV> SmartTVsInTheCart = new LinkedList<SmartTV>();

	public void showProductsInTheCart() {
		LOGGER.info(ComputersInTheCart);
		LOGGER.info(SmartPhonesInTheCart);
		LOGGER.info(SmartTVsInTheCart);
	}

	public LinkedList<Computer> getComputersInTheCart() {
		return ComputersInTheCart;
	}

	public void setComputersInTheCart(LinkedList<Computer> computersInTheCart) {
		ComputersInTheCart = computersInTheCart;
	}

	public LinkedList<SmartPhone> getSmartPhonesInTheCart() {
		return SmartPhonesInTheCart;
	}

	public void setSmartPhonesInTheCart(LinkedList<SmartPhone> smartPhonesInTheCart) {
		SmartPhonesInTheCart = smartPhonesInTheCart;
	}

	public LinkedList<SmartTV> getSmartTVsInTheCart() {
		return SmartTVsInTheCart;
	}

	public void setSmartTVsInTheCart(LinkedList<SmartTV> smartTVsInTheCart) {
		SmartTVsInTheCart = smartTVsInTheCart;
	}

	@Override
	public String toString() {
		return "Cart [ComputersInTheCart=" + ComputersInTheCart + ", SmartPhonesInTheCart=" + SmartPhonesInTheCart
				+ ", SmartTVsInTheCart=" + SmartTVsInTheCart + "]";
	}

}
