package com.solvd.maven_project_ok.online_shopping.cart;

import org.apache.logging.log4j.Logger;

import com.solvd.maven_project_ok.online_shopping.catalog.Computer;
import com.solvd.maven_project_ok.online_shopping.catalog.SmartPhone;
import com.solvd.maven_project_ok.online_shopping.catalog.SmartTV;

import java.util.List;

import org.apache.logging.log4j.LogManager;

public class Cart {
	public static final Logger LOGGER = LogManager.getLogger(Cart.class);
	private CustomLinkedList<Computer> ComputersInTheCart = new CustomLinkedList<Computer>();
	private CustomLinkedList<SmartPhone> SmartPhonesInTheCart = new CustomLinkedList<SmartPhone>();
	private CustomLinkedList<SmartTV> SmartTVsInTheCart = new CustomLinkedList<SmartTV>();

	public CustomLinkedList<Computer> getComputersInTheCart() {
		return ComputersInTheCart;
	}

	public void setComputersInTheCart(CustomLinkedList<Computer> computersInTheCart) {
		ComputersInTheCart = computersInTheCart;
	}

	public CustomLinkedList<SmartPhone> getSmartPhonesInTheCart() {
		return SmartPhonesInTheCart;
	}

	public void setSmartPhonesInTheCart(CustomLinkedList<SmartPhone> smartPhonesInTheCart) {
		SmartPhonesInTheCart = smartPhonesInTheCart;
	}

	public CustomLinkedList<SmartTV> getSmartTVsInTheCart() {
		return SmartTVsInTheCart;
	}

	public void setSmartTVsInTheCart(CustomLinkedList<SmartTV> smartTVsInTheCart) {
		SmartTVsInTheCart = smartTVsInTheCart;
	}
	
	public void showProductsInTheCart() {
		LOGGER.info(ComputersInTheCart);
		LOGGER.info(SmartPhonesInTheCart);
		LOGGER.info(SmartTVsInTheCart);
	}

	@Override
	public String toString() {
		return "Cart [ComputersInTheCart=" + ComputersInTheCart + ", SmartPhonesInTheCart=" + SmartPhonesInTheCart
				+ ", SmartTVsInTheCart=" + SmartTVsInTheCart + "]";
	}

}
