package com.solvd.mavenprojectok.onlineshopping.runner;

import org.apache.logging.log4j.Logger;

import com.solvd.mavenprojectok.onlineshopping.cart.Cart;
import com.solvd.mavenprojectok.onlineshopping.cart.CustomLinkedList;
import com.solvd.mavenprojectok.onlineshopping.catalog.Computer;
import com.solvd.mavenprojectok.onlineshopping.catalog.ComputerBrands;
import com.solvd.mavenprojectok.onlineshopping.catalog.ISearchable;
import com.solvd.mavenprojectok.onlineshopping.catalog.ProductCatalog;
import com.solvd.mavenprojectok.onlineshopping.catalog.ProductStorage;
import com.solvd.mavenprojectok.onlineshopping.catalog.Products;
import com.solvd.mavenprojectok.onlineshopping.catalog.SmartPhone;
import com.solvd.mavenprojectok.onlineshopping.catalog.SmartPhoneBrands;
import com.solvd.mavenprojectok.onlineshopping.catalog.SmartTV;
import com.solvd.mavenprojectok.onlineshopping.catalog.SmartTVBrands;
import com.solvd.mavenprojectok.onlineshopping.paymentmethod.BankAccount;
import com.solvd.mavenprojectok.onlineshopping.paymentmethod.CreditCard;
import com.solvd.mavenprojectok.onlineshopping.person.Adress;
import com.solvd.mavenprojectok.onlineshopping.person.Costumer;
import com.solvd.mavenprojectok.onlineshopping.person.Gender;
import com.solvd.mavenprojectok.onlineshopping.person.IVerifyable;
import com.solvd.mavenprojectok.onlineshopping.person.PhoneNumber;
import com.solvd.mavenprojectok.onlineshopping.person.UserAccount;
import com.solvd.mavenprojectok.onlineshopping.transaction.IBuy;
import com.solvd.mavenprojectok.onlineshopping.transaction.Transaction;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;

public class OnlineStoreRunner {
	public static final Logger LOGGER = LogManager.getLogger(OnlineStoreRunner.class);

	public static void main(String[] args) {
		// Catalog Creation
		ProductCatalog<Computer> computerCatalog = new ProductCatalog<Computer>();
		ProductCatalog<SmartPhone> smartPhoneCatalog = new ProductCatalog<SmartPhone>();
		ProductCatalog<SmartTV> smartTVCatalog = new ProductCatalog<SmartTV>();
		ProductStorage productStorage = new ProductStorage();
		productStorage.getFullCatalog().put(Products.COMPUTER, computerCatalog);
		productStorage.getFullCatalog().put(Products.SMART_PHONE, smartTVCatalog);
		productStorage.getFullCatalog().put(Products.SMART_TV, smartTVCatalog);

		Computer computerLenovoIdeaPad = new Computer(ComputerBrands.LENOVO.getBrandName(), "IdeaPad\t", 4500.99, 100,
				14, 4, "Intel Core i5-1035G1", "SSD", "250 GB");
		Computer computerLenovoYogaSlim = new Computer(ComputerBrands.LENOVO.getBrandName(), "YogaSlim", 7500.99, 100,
				14, 8, "Intel Core i5-1135G7", "SSD", "512 GB");
		Computer computerMacBookAirPro = new Computer(ComputerBrands.MAC.getBrandName(), "MacBookAirPro", 9500.00, 100,
				13.3, 16, "8 cores", "SSD", "2 TB");
		Computer computerAcerSwift = new Computer(ComputerBrands.ACER.getBrandName(), "Swift 7\t", 12000.00, 100, 16,
				16, "Intel Core i7-1165G7", "SSD", "2 TB");
		Computer computerAcerSpin = new Computer(ComputerBrands.ACER.getBrandName(), "Spin 3\t", 4000.00, 100, 16, 16,
				"Intel Core i3-1035G1", "SSD", "1 TB");
		computerCatalog.addItemToTheCatalog(computerLenovoIdeaPad);
		computerCatalog.addItemToTheCatalog(computerLenovoYogaSlim);
		computerCatalog.addItemToTheCatalog(computerMacBookAirPro);
		computerCatalog.addItemToTheCatalog(computerAcerSwift);
		computerCatalog.addItemToTheCatalog(computerAcerSpin);

		SmartPhone smartPhoneIPhone13 = new SmartPhone(SmartPhoneBrands.I_PHONE.getBrandName(), "13 Pro\t", 2000, 100,
				6.1, 2, 25, "Red", true);
		SmartPhone smartPhoneIphone13Pro = new SmartPhone(SmartPhoneBrands.I_PHONE.getBrandName(), "13 Pro Max", 2500,
				100, 6.7, 2, 28, "Black", true);
		SmartPhone smartPhoneSamsungGalaxys22 = new SmartPhone(SmartPhoneBrands.SAMSUNG.getBrandName(), "Galaxy S22",
				2300, 100, 7.1, 2, 23, "Pink", true);
		SmartPhone smartPhonesamsungNote20 = new SmartPhone(SmartPhoneBrands.SAMSUNG.getBrandName(), "Galaxy Note 20",
				3500, 100, 6.9, 6, 17, "Gold Pink", true);
		smartPhoneCatalog.addItemToTheCatalog(smartPhoneIPhone13);
		smartPhoneCatalog.addItemToTheCatalog(smartPhoneIphone13Pro);
		smartPhoneCatalog.addItemToTheCatalog(smartPhoneSamsungGalaxys22);
		smartPhoneCatalog.addItemToTheCatalog(smartPhonesamsungNote20);

		SmartTV smartTVNoblex = new SmartTV(SmartTVBrands.NOBLEX.getBrandName(), "DK32X5000", 2000.33, 100, 40);
		SmartTV smartTVHitachi = new SmartTV(SmartTVBrands.HITACHI.getBrandName(), "LE32SMART19", 3000.50, 100, 40);
		SmartTV smartTVPhilips = new SmartTV(SmartTVBrands.PHILIPS.getBrandName(), "32PHD6825", 2600.00, 100, 32);
		smartTVCatalog.addItemToTheCatalog(smartTVNoblex);
		smartTVCatalog.addItemToTheCatalog(smartTVHitachi);
		smartTVCatalog.addItemToTheCatalog(smartTVPhilips);

		// Costumer Creation
		Costumer costumerBeatriceJenkins = new Costumer("Beatrice", "Jenkins", 23124884,
				new Adress(42, "Wallaby Way", "Sydney", "Australia"), new Date(), Gender.FEMALE,
				new PhoneNumber(02, null, 98765432), new UserAccount("beatriceJenkins09", "difficultPassword"));
		BankAccount bankAccountBJ = new BankAccount(costumerBeatriceJenkins, 14029.55, 1329840999);
		CreditCard creditCardBJ = new CreditCard(costumerBeatriceJenkins, 3725.6, 1924197515, 583);
		costumerBeatriceJenkins.createWallet(bankAccountBJ);
		costumerBeatriceJenkins.createWallet(creditCardBJ);

		// Creation of the Cart
		Cart cart = new Cart();

		// Map of user accounts creation
		UserAccount.MapOfUserNamesAndPasswords.put("beatriceJenkins09", "difficultPassword".hashCode());

		// Welcome
		LOGGER.info("Welcome to this Online Store!");
		LOGGER.info("Computer Catalog");
		computerCatalog.showProductsForSale();
		LOGGER.info("Smart Phone Catalog");
		smartPhoneCatalog.showProductsForSale();
		LOGGER.info("Smart TV Catalog");
		smartTVCatalog.showProductsForSale();

		// LogIn
		LOGGER.info("Please login to your account to star shopping");
		IVerifyable verifyable = (map, userName, password) -> map.containsKey(userName)
				&& password.hashCode() == map.get(userName);
		costumerBeatriceJenkins.getUserAccount().logIn(verifyable);

		// Shopping
		ISearchable searchable = (stringArray, string) -> Arrays.asList(stringArray).contains(string.toLowerCase());
		productStorage.findProductTypeByKeyword(searchable, "computers");
		BiFunction<LinkedHashSet<Computer>, String, List<Computer>> filterComputerByBrand = (set, brand) -> set.stream()
				.filter(computer -> computer.getBrand().equals(brand)).collect(Collectors.toList());
		computerCatalog.fillterProductByBrand(filterComputerByBrand, ComputerBrands.ACER.getBrandName());
		cart.addProductToCart(computerAcerSpin);

		productStorage.findProductTypeByKeyword(searchable, "SMART phones");
		BiFunction<LinkedHashSet<SmartPhone>, String, List<SmartPhone>> filterSmartPhoneByBrand = (set, brand) -> set
				.stream().filter(smartPhone -> smartPhone.getBrand().equals(brand)).collect(Collectors.toList());
		smartPhoneCatalog.fillterProductByBrand(filterSmartPhoneByBrand, SmartPhoneBrands.I_PHONE.getBrandName());
		cart.addProductToCart(smartPhoneIphone13Pro);

		productStorage.findProductTypeByKeyword(searchable, "camera");

		productStorage.findProductTypeByKeyword(searchable, "smartTV");
		BiFunction<LinkedHashSet<SmartTV>, String, List<SmartTV>> filterSmartTVByBrand = (set, brand) -> set.stream()
				.filter(smartTV -> smartTV.getBrand().equals(brand)).collect(Collectors.toList());
		smartTVCatalog.fillterProductByBrand(filterSmartTVByBrand, SmartTVBrands.PHILIPS.getBrandName());
		cart.addProductToCart(smartTVPhilips);
		cart.showProductsInTheCart();

		// The consumer buys some products and causes the decrease in the quantity
		// available of each one
		Consumer<CustomLinkedList<Computer>> sellComputersInTheCart = (listOfComputers) -> listOfComputers.stream()
				.forEach((product) -> product.getData().setAvailiability(product.getData().getAvailiability() - 1));
		Consumer<CustomLinkedList<SmartPhone>> sellSmartPhonesInTheCart = (listOfSmartPhones) -> listOfSmartPhones
				.stream().forEach((smartPhone) -> smartPhone.getData()
						.setAvailiability(smartPhone.getData().getAvailiability() - 1));
		Consumer<CustomLinkedList<SmartTV>> sellSmartTVsInTheCart = (listOfSmartTVs) -> listOfSmartTVs.stream()
				.forEach((smartTV) -> smartTV.getData().setAvailiability(smartTV.getData().getAvailiability() - 1));

		Transaction<BankAccount> transaction = new Transaction<BankAccount>(cart.getAccumulatedPrice(), bankAccountBJ);
		transaction.sellProducts(cart, sellComputersInTheCart, sellSmartPhonesInTheCart, sellSmartTVsInTheCart);

		// The Costumer pays with a certain payment method
		BiPredicate<Double, Double> sufficientBalance = (totalToPay, balance) -> balance >= totalToPay;
		IBuy<BankAccount> payWithBankAccount = (totalToPay, bankAccount) -> bankAccount
				.setAvailableBalance(bankAccount.getAvailableBalance() - totalToPay);

		transaction.pay(sufficientBalance, payWithBankAccount);
		Date dateAndTimeOfTransaction = new Date();
		transaction.getTransactionTicket(dateAndTimeOfTransaction);
		costumerBeatriceJenkins.getUserAccount().logOut();
	}
}
