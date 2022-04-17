package com.solvd.mavenprojectok.onlineshopping.person;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.mavenprojectok.onlineshopping.catalog.Catalog;
import com.solvd.mavenprojectok.onlineshopping.catalog.Computer;
import com.solvd.mavenprojectok.onlineshopping.catalog.IAdministrable;
import com.solvd.mavenprojectok.onlineshopping.catalog.ReadNumericOptionsFromUser;
import com.solvd.mavenprojectok.onlineshopping.catalog.SmartPhone;
import com.solvd.mavenprojectok.onlineshopping.catalog.SmartTV;

public class Administrator implements IAdministrable {
	public static final Logger LOGGER = LogManager.getLogger(Catalog.class);
	private HashMap<String, Integer> mapOfUserNamesAndPasswords = new HashMap<String, Integer>();

	public HashMap<String, Integer> getMapOfUserNamesAndPasswords() {
		return mapOfUserNamesAndPasswords;
	}

	public void setMapOfUserNamesAndPasswords(HashMap<String, Integer> mapOfUserNamesAndPasswords) {
		this.mapOfUserNamesAndPasswords = mapOfUserNamesAndPasswords;
	}

	Catalog catalog = new Catalog();
	ReadNumericOptionsFromUser read = new ReadNumericOptionsFromUser();

	@Override
	public void addComputerToTheListOfItemsForSale(Computer computer) {
		catalog.getListOfComputersForSale().add(computer);
		LOGGER.info("New computer added to the catalog");
	}

	@Override
	public void addSmartPhoneToTheListOfItemsForSale(SmartPhone smartPhone) {
		catalog.getListOfSmartPhonesForSale().add(smartPhone);
		LOGGER.info("New smart phone added to the catalog");
	}

	@Override
	public void addSmartTVToTheListOfItemsForSale(SmartTV smartTV) {
		catalog.getListOfSmartsTVsForSale().add(smartTV);
		LOGGER.info("New smart TV added to the catalog");
	}

	@Override
	public void removeComputerFromTheListOfItemsForSale(Computer computer) {
		catalog.getListOfComputersForSale().remove(computer);
		LOGGER.info("Computer removed from the catalog");
	}

	@Override
	public void removeSmartPhoneFromTheListOfItemsForSale(SmartPhone smartPhone) {
		catalog.getListOfSmartPhonesForSale().remove(smartPhone);
		LOGGER.info("Smart Phone removed from the catalog");
	}

	@Override
	public void removeSmartTVFromTheListOfItemsForSale(SmartTV smartTV) {
		catalog.getListOfSmartsTVsForSale().remove(smartTV);
		LOGGER.info("Smart TV removed from the catalog");
	}

	public void createMapOfUserAccounts(UserAccount userAccount) {
		mapOfUserNamesAndPasswords.put(userAccount.getUserName(), userAccount.getPassword().hashCode());
	}

}
