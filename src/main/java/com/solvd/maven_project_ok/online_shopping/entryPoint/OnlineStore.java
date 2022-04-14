package com.solvd.maven_project_ok.online_shopping.entryPoint;

import com.solvd.maven_project_ok.online_shopping.cart.Cart;
import com.solvd.maven_project_ok.online_shopping.catalog.Catalog;
import com.solvd.maven_project_ok.online_shopping.catalog.Computer;
import com.solvd.maven_project_ok.online_shopping.catalog.SmartPhone;
import com.solvd.maven_project_ok.online_shopping.catalog.SmartTV;
import com.solvd.maven_project_ok.online_shopping.catalog.enums.ComputerBrands;
import com.solvd.maven_project_ok.online_shopping.catalog.enums.SmartPhoneBrands;
import com.solvd.maven_project_ok.online_shopping.catalog.enums.SmartTVBrands;
import com.solvd.maven_project_ok.online_shopping.person.Administrator;
import com.solvd.maven_project_ok.online_shopping.person.UserAccount;
import com.solvd.maven_project_ok.online_shopping.person.UserAccountActions;
import com.solvd.maven_project_ok.online_shopping.person.UserActions;
import com.solvd.maven_project_ok.online_shopping.transaction.ShoppingActions;

//Entry Point

public class OnlineStore {

	public static void main(String[] args) {
		Computer computer1 = new Computer(ComputerBrands.LENOVO, "IdeaPad", 4500.99, 100, 14, 4,
				"Intel� Core� i5-1035G1", "SSD", "250 GB");
		new Computer(ComputerBrands.ACER, "IdeaPad", 3900.00, 100, 14, 8, "Intel� Core� i3-1035G1", "SSD", "450 GB");
		new Computer(ComputerBrands.LENOVO, "IdeaPad", 3000.00, 100, 14, 4, "Intel� Core�", "SSD", "450 GB");
		Computer computer4 = new Computer(ComputerBrands.MAC, "Yoga Slim", 7500.99, 100, 14, 8,
				"Intel� Core� i5-1135G7", "SSD", "512 GB");
		new SmartPhone(SmartPhoneBrands.I_PHONE, "13 Pro Max", 2500, 100, 6.7, 2, 28, "Black", true);
		SmartPhone smartPhone4 = new SmartPhone(SmartPhoneBrands.I_PHONE, "13 Pro Max", 2500, 100, 6.7, 2, 28, "Green",
				true);
		new SmartPhone(SmartPhoneBrands.SAMSUNG, "Galaxy S22", 2300, 100, 7.1, 2, 23, "Pink", true);
		SmartPhone smartPhone6 = new SmartPhone(SmartPhoneBrands.SAMSUNG, "Galaxy S22+", 2800, 100, 7.5, 2, 23, "Blue",
				true);
		SmartTV smartTV1 = new SmartTV(SmartTVBrands.NOBLEX, "DK32X5000", 1567.33, 100, 32);
		new SmartTV(SmartTVBrands.NOBLEX, "DK32X5000", 2000.33, 100, 40);
		new SmartTV(SmartTVBrands.HITACHI, "LE32SMART19", 2500.50, 100, 32);
		new SmartTV(SmartTVBrands.PHILIPS, "32PHD6825", 2600.00, 100, 32);

		Administrator admin = new Administrator();
		admin.addComputerToTheListOfItemsForSale(computer4);
		admin.addComputerToTheListOfItemsForSale(computer1);
		admin.addSmartPhoneToTheListOfItemsForSale(smartPhone6);
		admin.addSmartPhoneToTheListOfItemsForSale(smartPhone4);
		admin.addSmartTVToTheListOfItemsForSale(smartTV1);
		UserAccount userAccount1 = new UserAccount("name", "password");
		admin.createMapOfUserAccounts(userAccount1);
		new Catalog();

		Cart cart = new Cart();
		cart.showProductsInTheCart();

	}
}
