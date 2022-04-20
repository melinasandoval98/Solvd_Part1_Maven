package com.solvd.mavenprojectok.onlineshopping.runner;

import org.apache.logging.log4j.Logger;

import com.solvd.mavenprojectok.onlineshopping.cart.Cart;
import com.solvd.mavenprojectok.onlineshopping.catalog.Catalog;
import com.solvd.mavenprojectok.onlineshopping.catalog.Computer;
import com.solvd.mavenprojectok.onlineshopping.catalog.ISearchable;
import com.solvd.mavenprojectok.onlineshopping.catalog.SmartPhone;
import com.solvd.mavenprojectok.onlineshopping.catalog.SmartTV;
import com.solvd.mavenprojectok.onlineshopping.catalog.enums.ComputerBrands;
import com.solvd.mavenprojectok.onlineshopping.catalog.enums.SmartPhoneBrands;
import com.solvd.mavenprojectok.onlineshopping.catalog.enums.SmartTVBrands;
import com.solvd.mavenprojectok.onlineshopping.person.Adress;
import com.solvd.mavenprojectok.onlineshopping.person.Costumer;
import com.solvd.mavenprojectok.onlineshopping.person.UserAccount;

import java.util.Arrays;
import java.util.Date;

import org.apache.logging.log4j.LogManager;

public class OnlineStoreRunner {
	public static final Logger LOGGER = LogManager.getLogger(OnlineStoreRunner.class);

	public enum Actions {
		SEE_FULL_CATALOG, SEARCH_PRODUCT_BY_KEYWORD;
	}

	public enum FilterProductResults {
		ADD_PRODUCT_TO_CART, FILTER_RESULTS_BY_BRAND, FILTER_RESULTS_BY_PRICE_RANGE;
	}

	public static void main(String[] args) {
		ISearchable searchable = (stringArray, string) -> Arrays.asList(stringArray).contains(string);

//		Product catalog generation
		Catalog catalog = new Catalog();
		Computer computerLenovoIdeaPad = new Computer(ComputerBrands.LENOVO, "IdeaPad\t", 4500.99, 100, 14, 4,
				"Intel� Core� i5-1035G1", "SSD", "250 GB");
		Computer computerLenovoYogaSlim = new Computer(ComputerBrands.LENOVO, "YogaSlim", 7500.99, 100, 14, 8,
				"Intel� Core� i5-1135G7", "SSD", "512 GB");
		Computer computerMacBookAirPro = new Computer(ComputerBrands.MAC, "MacBookAirPro", 9500.00, 100, 13.3, 16,
				"8 cores", "SSD", "2 TB");
		Computer computerAcerSwift = new Computer(ComputerBrands.ACER, "Swift 7\t", 12000.00, 100, 16, 16,
				"Intel� Core� i7-1165G7", "SSD", "2 TB");
		Computer computerAcerSpin = new Computer(ComputerBrands.ACER, "Spin 3\t", 4000.00, 100, 16, 16,
				"Intel� Core� i3-1035G1", "SSD", "1 TB");
		catalog.getListOfComputersForSale().add(computerLenovoIdeaPad);
		catalog.getListOfComputersForSale().add(computerLenovoYogaSlim);
		catalog.getListOfComputersForSale().add(computerMacBookAirPro);
		catalog.getListOfComputersForSale().add(computerAcerSwift);
		catalog.getListOfComputersForSale().add(computerAcerSpin);

		SmartPhone smartPhoneIPhone13 = new SmartPhone(SmartPhoneBrands.I_PHONE, "13 Pro\t", 2000, 100, 6.1, 2, 25, "Red",
				true);
		SmartPhone smartPhoneIphone13Pro = new SmartPhone(SmartPhoneBrands.I_PHONE, "13 Pro Max", 2500, 100, 6.7, 2, 28,
				"Black", true);
		SmartPhone smartPhoneSamsungGalaxys22 = new SmartPhone(SmartPhoneBrands.SAMSUNG, "Galaxy S22", 2300, 100, 7.1,
				2, 23, "Pink", true);
		SmartPhone smartPhonesamsungNote20 = new SmartPhone(SmartPhoneBrands.SAMSUNG, "Galaxy Note 20", 3500, 100, 6.9,
				6, 17, "Gold Pink", true);
		catalog.getListOfSmartPhonesForSale().add(smartPhoneIPhone13);
		catalog.getListOfSmartPhonesForSale().add(smartPhoneIphone13Pro);
		catalog.getListOfSmartPhonesForSale().add(smartPhoneSamsungGalaxys22);
		catalog.getListOfSmartPhonesForSale().add(smartPhonesamsungNote20);

		SmartTV smartTVNoblex = new SmartTV(SmartTVBrands.NOBLEX, "DK32X5000", 2000.33, 100, 40);
		SmartTV smartTVHitachi = new SmartTV(SmartTVBrands.HITACHI, "LE32SMART19", 3000.50, 100, 40);
		SmartTV smartTVPhilips = new SmartTV(SmartTVBrands.PHILIPS, "32PHD6825", 2600.00, 100, 32);
		catalog.getListOfSmartsTVsForSale().add(smartTVNoblex);
		catalog.getListOfSmartsTVsForSale().add(smartTVHitachi);
		catalog.getListOfSmartsTVsForSale().add(smartTVPhilips);

		LOGGER.info("Wellcome to this Online Store");
		LOGGER.info("Please select an option to continue:");

//		Actions userActions;
//		FilterProductResults results;
//		switch (userActions) {
//		case SEE_FULL_CATALOG:
//			catalog.showComputersForSale();
//			break;
//		case SEARCH_PRODUCT_BY_KEYWORD:
//			switch (results) {
//			case ADD_PRODUCT_TO_CART:
//				break;
//			}
//			break;
//
//		}

		Cart cart = new Cart();

		catalog.showComputersForSale();
		catalog.showSmartPhonesForSale();
		catalog.showSmartTVsForSale();

		cart.addComputer(computerAcerSpin);
		cart.addSmartPhone(smartPhoneIphone13Pro);
		cart.addSmartTV(smartTVPhilips);

		cart.showProductsInTheCart();
	}
}
