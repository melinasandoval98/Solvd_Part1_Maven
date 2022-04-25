package com.solvd.mavenprojectok.onlineshopping.person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.mavenprojectok.onlineshopping.catalog.ISearchable;
import com.solvd.mavenprojectok.onlineshopping.catalog.Products;
import com.solvd.mavenprojectok.onlineshopping.exception.ProductNotFoundException;
import com.solvd.mavenprojectok.onlineshopping.paymentmethod.PaymentMethod;

public class Costumer extends Person {
	public static final Logger LOGGER = LogManager.getLogger(Costumer.class);
	private UserAccount userAccount;
	private List<PaymentMethod> wallet = new ArrayList<PaymentMethod>();

	public Costumer() {
		super();
	}

	public Costumer(String name, String surname, int iD, Adress adress, Date dateOfBirth, Gender gender,
			UserAccount userAccount) {
		super(name, surname, iD, adress, dateOfBirth, gender);
		this.setUserAccount(userAccount);
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public List<PaymentMethod> getWallet() {
		return wallet;
	}

	private void searchProductTypeByKeyword(ISearchable searchable, Object[][] fullCatalog, String pattern)
			throws ProductNotFoundException {
		Integer row = null;
		for (Products product : Products.values()) {
			if (searchable.search(product.getKeywords(), pattern.toLowerCase())) {
				row = ArrayUtils.indexOf(fullCatalog[0], product);
				LOGGER.info("Search results for '" + pattern + "'\n" + fullCatalog[1][row] + "\n");
				break;
			}
		}
		if (row == null) {
			throw new ProductNotFoundException();
		}
	}

	public void findProductTypeByKeyword(ISearchable searchable, Object[][] fullCatalog, String pattern) {
		try {
			searchProductTypeByKeyword(searchable, fullCatalog, pattern);
		} catch (ProductNotFoundException e) {
			LOGGER.error("No products have been found for the keyword '" + pattern + "'", e);
		}
	}

	@Override
	public void createWallet(PaymentMethod pMethod) {
		wallet.add(pMethod);
	}

	@Override
	public String toString() {
		return "Costumer [userAccount=" + userAccount + ", name=" + name + ", surname=" + surname + ", iD=" + iD
				+ ", nationality=" + nationality + ", adress=" + adress + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", phoneNumber=" + phoneNumber + "]";
	}

}
