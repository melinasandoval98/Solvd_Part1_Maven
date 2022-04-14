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
		cart.getComputersInTheCart().add(computer);
	}

	@Override
	public void addSmartPhoneToTheCart(SmartPhone smartPhone) {
		cart.getSmartPhonesInTheCart().add(smartPhone);
	}

	@Override
	public void addSmartTVToTheCart(SmartTV smartTV) {
		cart.getSmartTVsInTheCart().add(smartTV);
	}

	@Override
	public void removeComputerFromTheCart(Computer computer) {
		cart.getComputersInTheCart().remove(computer);
		LOGGER.info("Computer removed from the cart");

	}

	@Override
	public void removeSmartPhoneFromTheCart(SmartPhone smartPhone) {
		cart.getSmartPhonesInTheCart().remove(smartPhone);
		LOGGER.info("Smart Phone removed from the cart");

	}

	@Override
	public void removeSmartTVFromTheTheCart(SmartTV smartTV) {
		cart.getSmartTVsInTheCart().remove(smartTV);
	}
}
