package com.solvd.Maven_Project.onlineShopping.person;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.Maven_Project.exceptionHandling.ReadNumericOptionsFromUser;
import com.solvd.Maven_Project.onlineShopping.catalog.Catalog;
import com.solvd.Maven_Project.onlineShopping.catalog.Computer;
import com.solvd.Maven_Project.onlineShopping.catalog.Product;
import com.solvd.Maven_Project.onlineShopping.catalog.SmartPhone;
import com.solvd.Maven_Project.onlineShopping.catalog.SmartTV;

public class Administrator {
	public static final Logger LOGGER = LogManager.getLogger(Catalog.class);
	private Integer adminRemoveProductOption;
	private Integer adminItemRemoveOption;

	Catalog catalog = new Catalog();
	ReadNumericOptionsFromUser read = new ReadNumericOptionsFromUser();

	public void removeProductFromCatalog(Integer productToRemove) {
		switch (adminRemoveProductOption) {
		case (1):
			catalog.showComputersForSale();
			read.optionFromUser(adminItemRemoveOption, catalog.getListOfComputersForSale().size());
			catalog.removeProductFromTheListOfItemsForSale(
					(Product) catalog.getListOfComputersForSale().toArray()[adminItemRemoveOption]);
			break;
		case (2):
			read.optionFromUser(adminItemRemoveOption, catalog.getListOfSmartPhonesForSale().size());
			catalog.removeProductFromTheListOfItemsForSale(
					(Product) catalog.getListOfSmartPhonesForSale().toArray()[adminItemRemoveOption]);
			break;
		case (3):
			read.optionFromUser(adminItemRemoveOption, catalog.getListOfSmartsTVsForSale().size());
			catalog.removeProductFromTheListOfItemsForSale(
					(Product) catalog.getListOfSmartsTVsForSale().toArray()[adminItemRemoveOption]);
			break;
		}
	}

	public void addProductToTheCatalog(Integer adminAddProductOption) {
		switch (adminAddProductOption) {
		case (1):
			Computer newComputer = new Computer();
			catalog.addProductToTheListOfItemsForSale(newComputer);
			break;
		case (2):
			SmartPhone newSmartPhone = new SmartPhone();
			catalog.addProductToTheListOfItemsForSale(newSmartPhone);
			break;
		case (3):
			SmartTV newSmartTV = new SmartTV();
			catalog.addProductToTheListOfItemsForSale(newSmartTV);
			break;
		}
	}
}
