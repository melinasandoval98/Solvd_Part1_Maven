package com.solvd.Maven_Project.onlineShopping.catalog;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Catalog implements IAdministrable<Product> {
	public static final Logger LOGGER = LogManager.getLogger(Catalog.class);
	private LinkedHashSet<Computer> listOfComputersForSale = new LinkedHashSet<Computer>();
	private LinkedHashSet<SmartPhone> listOfSmartPhonesForSale = new LinkedHashSet<SmartPhone>();
	private LinkedHashSet<SmartTV> listOfSmartsTVsForSale = new LinkedHashSet<SmartTV>();
	private Map<String, LinkedHashSet<Computer>> computerKeyWords = new HashMap<String, LinkedHashSet<Computer>>();
	private Map<String, LinkedHashSet<SmartPhone>> smartPhoneKeyWords = new HashMap<String, LinkedHashSet<SmartPhone>>();
	private Map<String, LinkedHashSet<SmartTV>> smartTVKeyWords = new HashMap<String, LinkedHashSet<SmartTV>>();

	public Map<String, LinkedHashSet<Computer>> getComputerKeyWords() {
		return computerKeyWords;
	}

	@Override
	public void createListOfItemsForSale() {
		// Create a list of the computers available for sale
		getListOfComputersForSale().add(computer1);
		getListOfComputersForSale().add(computer2);
		getListOfComputersForSale().add(computer3);
		getListOfComputersForSale().add(computer4);
		getListOfComputersForSale().add(computer5);
		getListOfComputersForSale().add(computer6);
		getListOfComputersForSale().add(computer7);
		getListOfComputersForSale().add(computer8);
		getListOfComputersForSale().add(computer9);
		getListOfComputersForSale().add(computer10);
		getListOfComputersForSale().add(computer11);
		getListOfComputersForSale().add(computer12);
		getListOfComputersForSale().add(computer13);
		getListOfComputersForSale().add(computer14);
		// Create a list of the smart phones available for sale
		getListOfSmartPhonesForSale().add(smartPhone1);
		getListOfSmartPhonesForSale().add(smartPhone2);
		getListOfSmartPhonesForSale().add(smartPhone3);
		getListOfSmartPhonesForSale().add(smartPhone4);
		getListOfSmartPhonesForSale().add(smartPhone5);
		getListOfSmartPhonesForSale().add(smartPhone6);
		getListOfSmartPhonesForSale().add(smartPhone7);
		getListOfSmartPhonesForSale().add(smartPhone8);
		// Create a list of the smart TV's available for sale
		getListOfSmartsTVsForSale().add(smartTV1);
		getListOfSmartsTVsForSale().add(smartTV2);
		getListOfSmartsTVsForSale().add(smartTV3);
		getListOfSmartsTVsForSale().add(smartTV4);
		getListOfSmartsTVsForSale().add(smartTV5);
		getListOfSmartsTVsForSale().add(smartTV6);
	}

	public void productKeyWords() {
		// Create the list of keywords the enables the user to search for an specific
		// type of product
		getComputerKeyWords().put("Computer", getListOfComputersForSale());
		getComputerKeyWords().put("computer", getListOfComputersForSale());
		getComputerKeyWords().put("computers", getListOfComputersForSale());
		getSmartPhoneKeyWords().put("smartphone", getListOfSmartPhonesForSale());
		getSmartPhoneKeyWords().put("Smartphone", getListOfSmartPhonesForSale());
		getSmartPhoneKeyWords().put("smart phone", getListOfSmartPhonesForSale());
		getSmartPhoneKeyWords().put("smart phones", getListOfSmartPhonesForSale());
		getSmartPhoneKeyWords().put("Smart phones", getListOfSmartPhonesForSale());
		getSmartPhoneKeyWords().put("Smart Phone", getListOfSmartPhonesForSale());
		getSmartTVKeyWords().put("Smart TV", getListOfSmartsTVsForSale());
		getSmartTVKeyWords().put("Smart tv", getListOfSmartsTVsForSale());
		getSmartTVKeyWords().put("smart tv", getListOfSmartsTVsForSale());
		getSmartTVKeyWords().put("smart TV", getListOfSmartsTVsForSale());
	}

	@Override
	public void addProductToTheListOfItemsForSale(Product product) {
		switch (Product.class.getName()) {
		case ("Computer"):
			getListOfComputersForSale().add((Computer) product);
			break;
		case ("SmartPhone"):
			getListOfSmartPhonesForSale().add((SmartPhone) product);
			break;
		case ("SmartTV"):
			getListOfSmartsTVsForSale().add((SmartTV) product);
		}
	}

	@Override
	public void removeProductFromTheListOfItemsForSale(Product product) {
		switch (Product.class.getName()) {
		case ("Computer"):
			getListOfComputersForSale().remove((Computer) product);
			break;
		case ("SmartPhone"):

			getListOfSmartPhonesForSale().remove((SmartPhone) product);
			break;
		case ("SmartTV"):
			getListOfSmartsTVsForSale().remove((SmartTV) product);
		}
	}

	public void showComputersForSale() {
		LOGGER.info("Computers for sale %30\n");
		LOGGER.info("Brand %5\n" + "Model %5\n" + "Ram_Memory" + "Processor %8\n" + "Hard_disk_type"
				+ "Hard_disk_capacity" + "Price");
		for (Computer computer : listOfComputersForSale) {
			LOGGER.info(
					computer.getBrand() + computer.getModel() + computer.getRamMemoryInGb() + computer.getProcessor()
							+ computer.getHardDiskType() + computer.getHardDiskCapacity() + computer.getPriceInUSD());
		}
	}

	public void showSmartPhonesForSale() {
		LOGGER.info("Smartphones for sale %30\n");
		LOGGER.info("Brand %5\n" + "Model %5\n" + "Ram_Memory" + "Camera Definition " + "Color %5\\n" + "BlueTooth"
				+ "Price");
		for (SmartPhone smartPhone : listOfSmartPhonesForSale) {
			LOGGER.info(smartPhone.getBrand() + smartPhone.getModel() + smartPhone.getRamMemoryInGb()
					+ smartPhone.getCameraPixel() + smartPhone.getColor() + smartPhone.isBluetooth()
					+ smartPhone.getPriceInUSD());
		}
	}

	public void showSmartTVsForSale() {
		LOGGER.info("Smart TV's for sale %30\n");
		LOGGER.info("Brand %5\n" + "Model %5\n" + "Size" + "Price");
		for (SmartTV smartTV : listOfSmartsTVsForSale) {
			LOGGER.info(smartTV.getBrand() + smartTV.getModel() + smartTV.getSizeInInchs() + smartTV.getPriceInUSD());
		}
	}

	public void showCatalogOfItemsForSale() {
		showComputersForSale();
		showSmartPhonesForSale();
		showSmartTVsForSale();
	}

	Computer computer1 = new Computer("Lenovo", "IdeaPad", 4500.99, 100, 14, 4, "Intel� Core� i5-1035G1", "SSD",
			"250 GB");
	Computer computer2 = new Computer("Lenovo", "IdeaPad", 3900.00, 100, 14, 8, "Intel� Core� i3-1035G1", "SSD",
			"450 GB");
	Computer computer3 = new Computer("Lenovo", "IdeaPad", 3000.00, 100, 14, 4, "Intel� Core�", "SSD", "450 GB");
	Computer computer4 = new Computer("Lenovo", "Yoga Slim", 7500.99, 100, 14, 8, "Intel� Core� i5-1135G7", "SSD",
			"512 GB");
	Computer computer5 = new Computer("Lenovo", "ThinkPad T14s 2nd Gen", 7000.99, 100, 14, 8, "Intel� Core� i7-1165G7",
			"SSD", "512 GB");
	Computer computer6 = new Computer("Mac", "MacBook Air", 9000.00, 100, 13.3, 16, "8 cores", "SSD", "2 TB");
	Computer computer7 = new Computer("Mac", "MacBook Air Pro", 9500.00, 100, 13.3, 16, "8 cores", "SSD", "2 TB");
	Computer computer8 = new Computer("Mac", "MacBook Air Pro", 9800.00, 100, 14, 16, "8 cores", "SSD", "2 TB");
	Computer computer9 = new Computer("Mac", "MacBook Air Pro", 10000.00, 100, 16, 16, "8 cores", "SSD", "2 TB");
	Computer computer10 = new Computer("Acer", "Porsche Design Acer Book RS", 7000.00, 100, 16, 16,
			"Intel� Core� i5-1035G1", "SSD", "2 TB");
	Computer computer11 = new Computer("Acer", "Acer ENDURO Urban", 8500.00, 100, 16, 16, "Intel� Core� i5-1035G1",
			"SSD", "1 TB");
	Computer computer12 = new Computer("Acer", "Swift x AMD", 4385.00, 100, 16, 16, "Intel� Core� i7-1165G7", "SSD",
			"2 TB");
	Computer computer13 = new Computer("Acer", "Swift 7", 12000.00, 100, 16, 16, "Intel� Core� i7-1165G7", "SSD",
			"2 TB");
	Computer computer14 = new Computer("Acer", "Spin 3", 4000.00, 100, 16, 16, "Intel� Core� i3-1035G1", "SSD", "1 TB");

	SmartPhone smartPhone1 = new SmartPhone("iPhone", "13 Pro", 2000, 100, 6.1, 2, 25, "Black", true);
	SmartPhone smartPhone2 = new SmartPhone("iPhone", "13 Pro", 2000, 100, 6.1, 2, 25, "Red", true);
	SmartPhone smartPhone3 = new SmartPhone("iPhone", "13 Pro Max", 2500, 100, 6.7, 2, 28, "Black", true);
	SmartPhone smartPhone4 = new SmartPhone("iPhone", "13 Pro Max", 2500, 100, 6.7, 2, 28, "Green", true);
	SmartPhone smartPhone5 = new SmartPhone("Samsung", "Galaxy S22", 2300, 100, 7.1, 2, 23, "Pink", true);
	SmartPhone smartPhone6 = new SmartPhone("Samsung", "Galaxy S22+", 2800, 100, 7.5, 2, 23, "Blue", true);
	SmartPhone smartPhone7 = new SmartPhone("Samsung", "Galaxy S22 Ultra", 3200, 100, 7.5, 4, 26, "Silver", true);
	SmartPhone smartPhone8 = new SmartPhone("Samsung", "Galaxy Note 20", 3500, 100, 6.9, 6, 17, "Gold Pink", true);

	SmartTV smartTV1 = new SmartTV("Noblex", "DK32X5000", 1567.33, 100, 32);
	SmartTV smartTV2 = new SmartTV("Noblex", "DK32X5000", 2000.33, 100, 40);
	SmartTV smartTV3 = new SmartTV("Hitachi", "LE32SMART19", 2500.50, 100, 32);
	SmartTV smartTV4 = new SmartTV("Hitachi", "LE32SMART19", 3000.50, 100, 40);
	SmartTV smartTV5 = new SmartTV("Philips", "32PHD6825", 2600.00, 100, 32);
	SmartTV smartTV6 = new SmartTV("Philips", "32PHD6825", 2700.00, 100, 40);

	public void setComputerKeyWords(Map<String, LinkedHashSet<Computer>> computerKeyWords) {
		this.computerKeyWords = computerKeyWords;
	}

	public Map<String, LinkedHashSet<SmartPhone>> getSmartPhoneKeyWords() {
		return smartPhoneKeyWords;
	}

	public void setSmartPhoneKeyWords(Map<String, LinkedHashSet<SmartPhone>> smartPhoneKeyWords) {
		this.smartPhoneKeyWords = smartPhoneKeyWords;
	}

	public Map<String, LinkedHashSet<SmartTV>> getSmartTVKeyWords() {
		return smartTVKeyWords;
	}

	public void setSmartTVKeyWords(Map<String, LinkedHashSet<SmartTV>> smartTVKeyWords) {
		this.smartTVKeyWords = smartTVKeyWords;
	}

	public LinkedHashSet<Computer> getListOfComputersForSale() {
		return listOfComputersForSale;
	}

	public void setListOfComputersForSale(LinkedHashSet<Computer> listOfComputersForSale) {
		this.listOfComputersForSale = listOfComputersForSale;
	}

	public LinkedHashSet<SmartPhone> getListOfSmartPhonesForSale() {
		return listOfSmartPhonesForSale;
	}

	public void setListOfSmartPhonesForSale(LinkedHashSet<SmartPhone> listOfSmartPhonesForSale) {
		this.listOfSmartPhonesForSale = listOfSmartPhonesForSale;
	}

	public LinkedHashSet<SmartTV> getListOfSmartsTVsForSale() {
		return listOfSmartsTVsForSale;
	}

	public void setListOfSmartsTVsForSale(LinkedHashSet<SmartTV> listOfSmartsTVsForSale) {
		this.listOfSmartsTVsForSale = listOfSmartsTVsForSale;
	}
}
