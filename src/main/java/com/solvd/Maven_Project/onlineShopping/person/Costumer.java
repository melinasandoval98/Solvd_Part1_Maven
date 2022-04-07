package com.solvd.Maven_Project.onlineShopping.person;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.Maven_Project.exceptionHandling.ReadNumericOptionsFromUser;
import com.solvd.Maven_Project.onlineShopping.catalog.Catalog;
import com.solvd.Maven_Project.onlineShopping.catalog.Product;
import com.solvd.Maven_Project.olineShopping.shopping.Cart;

public class Costumer extends Person implements IConsume {
	public static final Logger LOGGER = LogManager.getLogger(Catalog.class);
	private String userName;
	private String password;
	private Integer productIndex;
	ReadNumericOptionsFromUser read = new ReadNumericOptionsFromUser();
	Catalog catalog = new Catalog();
	Cart cart = new Cart();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void addProductToCart(Integer productCategry) {
		switch (productCategry) {
		case (1):
			read.optionFromUser(productIndex, catalog.getListOfComputersForSale().size());
			cart.getProductsInTheCart()
					.add(((Product) catalog.getListOfComputersForSale().toArray()[productIndex]).getModel());
			cart.getProductPrice()
					.add(((Product) catalog.getListOfComputersForSale().toArray()[productIndex]).getPriceInUSD());

			break;
		case (2):
			cart.getProductsInTheCart()
					.add(((Product) catalog.getListOfSmartPhonesForSale().toArray()[productIndex]).getModel());
			cart.getProductPrice()
					.add(((Product) catalog.getListOfSmartPhonesForSale().toArray()[productIndex]).getPriceInUSD());
			break;
		case (3):
			cart.getProductsInTheCart()
					.add(((Product) catalog.getListOfSmartsTVsForSale().toArray()[productIndex]).getModel());
			cart.getProductPrice()
					.add(((Product) catalog.getListOfSmartsTVsForSale().toArray()[productIndex]).getPriceInUSD());

			break;
		}
	}

	@Override
	public void removeProductFromCart(Integer productCategry, Integer productIndex) {
		switch (productCategry) {
		case (1):
			read.optionFromUser(productIndex, catalog.getListOfComputersForSale().size());
			cart.getProductsInTheCart().remove(catalog.getListOfSmartsTVsForSale().toArray()[productIndex]);
			break;
		case (2):
			read.optionFromUser(productIndex, catalog.getListOfSmartPhonesForSale().size());
			cart.getProductsInTheCart().remove(catalog.getListOfSmartsTVsForSale().toArray()[productIndex]);
			break;
		case (3):
			read.optionFromUser(productIndex, catalog.getListOfSmartsTVsForSale().size());
			cart.getProductsInTheCart().remove(catalog.getListOfSmartsTVsForSale().toArray()[productIndex]);
			break;
		}
	}
}
