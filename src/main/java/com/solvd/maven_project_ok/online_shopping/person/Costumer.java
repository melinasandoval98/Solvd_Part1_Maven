package com.solvd.maven_project_ok.online_shopping.person;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.maven_project_ok.online_shopping.cart.Cart;
import com.solvd.maven_project_ok.online_shopping.catalog.Catalog;
import com.solvd.maven_project_ok.online_shopping.catalog.Computer;
import com.solvd.maven_project_ok.online_shopping.catalog.ReadNumericOptionsFromUser;
import com.solvd.maven_project_ok.online_shopping.catalog.SmartPhone;
import com.solvd.maven_project_ok.online_shopping.catalog.SmartTV;
import com.solvd.maven_project_ok.online_shopping.payment_method.BankAccount;
import com.solvd.maven_project_ok.online_shopping.payment_method.CreditCard;
import com.solvd.maven_project_ok.online_shopping.payment_method.DiscountCoupon;

public class Costumer extends Person implements IConsume {
	public static final Logger LOGGER = LogManager.getLogger(Catalog.class);
	private String userName;
	private String password;
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
	public void createWallet() {
		BankAccount bankAccount = new BankAccount((Math.round((Math.random() + 1) * Math.pow(10, 17))),
				Math.random() * Math.pow(10, 5 * Math.random()));
		bankAccount.setPaymentMethodHolder();
		CreditCard creditCard = new CreditCard((Math.round((Math.random() + 1) * Math.pow(10, 15))),
				(int) Math.round(Math.random() * 999), Math.random() * Math.pow(10, 5 * Math.random()));
		creditCard.setPaymentMethodHolder();
		DiscountCoupon discountCoupon = new DiscountCoupon((Math.round((Math.random() + 1) * 10000)),
				(int) Math.round((Math.random() + 1) * 10), Math.random() * Math.pow(10, 5 * Math.random()));
		discountCoupon.setPaymentMethodHolder();

	}

	@Override
	public void addComputerToTheCart(Computer computer) {
		cart.getComputersInTheCart().insert(computer);
		LOGGER.info("Computer added to the cart");

	}

	@Override
	public void addSmartPhoneToTheCart(SmartPhone smartPhone) {
		cart.getSmartPhonesInTheCart().insert(smartPhone);
		LOGGER.info("Smart Phone added to the cart");

	}

	@Override
	public void addSmartTVToTheCart(SmartTV smartTV) {
		cart.getSmartTVsInTheCart().insert(smartTV);
		LOGGER.info("Smart TV added to the cart");

	}

	@Override
	public void removeComputerFromTheCart(int removeOption) {
		cart.getComputersInTheCart().delete(read.optionFromUser(cart.getComputersInTheCart().getSize()));
		LOGGER.info("Computer removed from the cart");

	}

	@Override
	public void removeSmartPhoneFromTheCart(int removeOption) {
		cart.getSmartPhonesInTheCart().delete(read.optionFromUser(cart.getSmartPhonesInTheCart().getSize()));
		LOGGER.info("Smart Phone removed from the cart");

	}

	@Override
	public void removeSmartTVFromTheTheCart(int removeOption) {
		cart.getSmartTVsInTheCart().delete(read.optionFromUser(cart.getSmartTVsInTheCart().getSize()));
		LOGGER.info("Smart TV removed from the cart");

	}
}
