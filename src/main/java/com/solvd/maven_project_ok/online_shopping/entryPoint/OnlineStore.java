package com.solvd.maven_project_ok.online_shopping.entryPoint;

import com.solvd.maven_project_ok.online_shopping.catalog.Catalog;
import com.solvd.maven_project_ok.online_shopping.catalog.Computer;
import com.solvd.maven_project_ok.online_shopping.catalog.SmartPhone;
import com.solvd.maven_project_ok.online_shopping.catalog.SmartTV;
import com.solvd.maven_project_ok.online_shopping.payment_method.PaymentMethods;
import com.solvd.maven_project_ok.online_shopping.person.Administrator;
import com.solvd.maven_project_ok.online_shopping.person.Costumer;
import com.solvd.maven_project_ok.online_shopping.person.UserAccount;
import com.solvd.maven_project_ok.online_shopping.person.UserActions;
import com.solvd.maven_project_ok.online_shopping.shopping.Cart;
import com.solvd.maven_project_ok.online_shopping.transaction.Transaction;

//Entry Point

public class OnlineStore {

	public static void main(String[] args) {
		Computer computer1 = new Computer("Lenovo", "IdeaPad", 4500.99, 100, 14, 4, "Intel� Core� i5-1035G1", "SSD",
				"250 GB");
		Computer computer2 = new Computer("Lenovo", "IdeaPad", 3900.00, 100, 14, 8, "Intel� Core� i3-1035G1", "SSD",
				"450 GB");
		Computer computer3 = new Computer("Lenovo", "IdeaPad", 3000.00, 100, 14, 4, "Intel� Core�", "SSD", "450 GB");
		Computer computer4 = new Computer("Lenovo", "Yoga Slim", 7500.99, 100, 14, 8, "Intel� Core� i5-1135G7", "SSD",
				"512 GB");
		SmartPhone smartPhone3 = new SmartPhone("iPhone", "13 Pro Max", 2500, 100, 6.7, 2, 28, "Black", true);
		SmartPhone smartPhone4 = new SmartPhone("iPhone", "13 Pro Max", 2500, 100, 6.7, 2, 28, "Green", true);
		SmartPhone smartPhone5 = new SmartPhone("Samsung", "Galaxy S22", 2300, 100, 7.1, 2, 23, "Pink", true);
		SmartPhone smartPhone6 = new SmartPhone("Samsung", "Galaxy S22+", 2800, 100, 7.5, 2, 23, "Blue", true);
		SmartTV smartTV1 = new SmartTV("Noblex", "DK32X5000", 1567.33, 100, 32);
		SmartTV smartTV2 = new SmartTV("Noblex", "DK32X5000", 2000.33, 100, 40);
		SmartTV smartTV3 = new SmartTV("Hitachi", "LE32SMART19", 2500.50, 100, 32);
		SmartTV smartTV4 = new SmartTV("Hitachi", "LE32SMART19", 3000.50, 100, 40);
		SmartTV smartTV5 = new SmartTV("Philips", "32PHD6825", 2600.00, 100, 32);

		UserAccount newAccount = new UserAccount();
		newAccount.accountAction(UserActions.SING_IN);

		Administrator admin = new Administrator();
		admin.addComputerToTheListOfItemsForSale(computer4);
		admin.addComputerToTheListOfItemsForSale(computer1);
		admin.addSmartPhoneToTheListOfItemsForSale(smartPhone6);
		admin.addSmartPhoneToTheListOfItemsForSale(smartPhone4);
		admin.addSmartTVToTheListOfItemsForSale(smartTV4);
		admin.addSmartTVToTheListOfItemsForSale(smartTV1);

		Catalog catalog = new Catalog();
		catalog.showCatalogOfItemsForSale();

		Costumer userCostumer = new Costumer();
		userCostumer.addComputerToTheCart(computer4);
		userCostumer.addSmartPhoneToTheCart(smartPhone6);
		userCostumer.addSmartPhoneToTheCart(smartPhone5);
		userCostumer.addSmartTVToTheCart(smartTV5);

		Cart cart = new Cart();
		cart.showProductsInTheCart();

		Transaction transaction = new Transaction();
		transaction.pay(PaymentMethods.CREDIT_CARD);
	}
}
