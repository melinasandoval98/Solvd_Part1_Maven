package com.solvd.Maven_Project.onlineShopping.entryPoint;

import org.apache.logging.log4j.Logger;

import com.solvd.Maven_Project.exceptionHandling.PayWithPaymentMethod;
import com.solvd.Maven_Project.olineShopping.shopping.Cart;
import com.solvd.Maven_Project.onlineShopping.catalog.Catalog;
import com.solvd.Maven_Project.onlineShopping.person.Costumer;
import com.solvd.Maven_Project.onlineShopping.transaction.Transaction;

import org.apache.logging.log4j.LogManager;

public class MainMenu {
	public static final Logger LOGGER = LogManager.getLogger(Catalog.class);
	private int choosePaymentMethod;
	
	void menu() {
		Catalog catalog = new Catalog();
		catalog.createListOfItemsForSale();
		catalog.showCatalogOfItemsForSale();
		Cart cart = new Cart();
		Costumer costumer = new Costumer();
		costumer.addProductToCart(3);
		costumer.addProductToCart(3);
		costumer.addProductToCart(2);
		costumer.addProductToCart(1);
		cart.getProductsInTheCart();
		costumer.removeProductFromCart(1, 1);
		cart.getProductsInTheCart();
		PayWithPaymentMethod pay = new PayWithPaymentMethod();
		pay.calculateTotalCost();
		Transaction transaction = new Transaction();
		transaction.buy(choosePaymentMethod);
	}
}
