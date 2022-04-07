package com.solvd.Maven_Project.olineShopping.shopping;

import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;

public class Cart {
	public static final Logger LOGGER = LogManager.getLogger(Cart.class);
	private List<Object> productsInTheCart = new ArrayList<Object>();
	private List<Double> productPrice = new ArrayList<Double>();
	private Double acumulatedPrice;

	// Getters and Setters
	public List<Double> getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(List<Double> productPrice) {
		this.productPrice = productPrice;
	}

	public List<Object> getProductsInTheCart() {
		return productsInTheCart;
	}

	public void setProductsInTheCart(List<Object> productsInTheCart) {
		this.productsInTheCart = productsInTheCart;
	}

	public Double getAcumulatedPrice() {
		return acumulatedPrice;
	}

	public void setAcumulatedPrice(Double acumulatedPrice) {
		this.acumulatedPrice = acumulatedPrice;
	}
}
