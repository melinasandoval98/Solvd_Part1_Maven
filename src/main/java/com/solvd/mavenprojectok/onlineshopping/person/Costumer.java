package com.solvd.mavenprojectok.onlineshopping.person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.mavenprojectok.onlineshopping.catalog.Catalog;
import com.solvd.mavenprojectok.onlineshopping.catalog.ISearchable;
import com.solvd.mavenprojectok.onlineshopping.catalog.Products;
import com.solvd.mavenprojectok.onlineshopping.exception.ProductNotFoundException;
import com.solvd.mavenprojectok.onlineshopping.paymentmethod.PaymentMethod;

public class Costumer extends Person {
	public static final Logger LOGGER = LogManager.getLogger(Catalog.class);
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

	private Object searchProductTypeByKeyword(ISearchable searchable, Object[][] fullCatalog, String pattern)
			throws ProductNotFoundException {
		Integer row = null;
		for (Products product : Products.values()) {
			if (searchable.search(product.getKeywords(), pattern.toLowerCase())) {
				row = ArrayUtils.indexOf(fullCatalog[0], product);
				break;
			} else {
				throw new ProductNotFoundException();
			}
		}
		return fullCatalog[1][row];
	}

	public Object findProductTypeByKeyword(ISearchable searchable, Object[][] fullCatalog, String pattern) {
		while (true) {
			try {
				return searchProductTypeByKeyword(searchable, fullCatalog, pattern);
			} catch (ProductNotFoundException e) {
				LOGGER.error("No products have been found with that name", e);
				continue;
			}
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
