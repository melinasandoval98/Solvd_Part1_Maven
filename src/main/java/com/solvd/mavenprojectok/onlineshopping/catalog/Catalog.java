package com.solvd.mavenprojectok.onlineshopping.catalog;

import java.util.LinkedHashSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.mavenprojectok.onlineshopping.exception.ProductNotFoundException;

public class Catalog {
	public static final Logger LOGGER = LogManager.getLogger(Catalog.class);
	private LinkedHashSet<Computer> listOfComputersForSale = new LinkedHashSet<Computer>();
	private LinkedHashSet<SmartPhone> listOfSmartPhonesForSale = new LinkedHashSet<SmartPhone>();
	private LinkedHashSet<SmartTV> listOfSmartTVsForSale = new LinkedHashSet<SmartTV>();

	public Products searchProductByKeyword(ISearchable searchable, String pattern) throws ProductNotFoundException {
		for (Products product : Products.values()) {
			if (searchable.search(product.getKeywords(), pattern)) {
				break;
			} else {
				throw new ProductNotFoundException();
			}
		}
		return Products.valueOf(pattern.toUpperCase());
	}

	public Products findProductByKeyword(ISearchable searchable, String pattern) {
		while (true) {
			try {
				return searchProductByKeyword(searchable, pattern);
			} catch (ProductNotFoundException e) {
				LOGGER.error("No products have been found with that name");
				continue;
			}
		}
	}

	public void showProductsOfCategory(Products product) {
		switch (product) {
		case COMPUTER:
			showComputersForSale();
			break;
		case SMART_PHONE:
			showSmartPhonesForSale();
			break;
		case SMART_TV:
			showSmartTVsForSale();
			break;
		default:
			break;
		}
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
		return listOfSmartTVsForSale;
	}

	public void setListOfSmartsTVsForSale(LinkedHashSet<SmartTV> listOfSmartsTVsForSale) {
		this.listOfSmartTVsForSale = listOfSmartsTVsForSale;
	}

	@Override
	public String toString() {
		return "Catalog [listOfComputersForSale=" + listOfComputersForSale + ", listOfSmartPhonesForSale="
				+ listOfSmartPhonesForSale + ", listOfSmartTVsForSale=" + listOfSmartTVsForSale + "]";
	}

	public void showComputersForSale() {
		LOGGER.info("Computers for sale:");
		LOGGER.info("---------------------------------------------------------------------------");
		LOGGER.info("BRAND\tMODEL\t\tSIZE(inch)\tRAM(GB)\tH.D.Capacity\tPRICE(USD)");
		LOGGER.info("---------------------------------------------------------------------------");
		listOfComputersForSale.stream()
				.forEach(computer -> LOGGER.info(computer.getBrand() + "\t" + computer.getModel() + "\t"
						+ computer.getSizeInInchs() + "\t\t" + computer.getRamMemoryInGb() + "\t"
						+ computer.getHardDiskCapacity() + "\t\t" + computer.getPriceInUSD()));
		LOGGER.info("\n");
	}

	public void showSmartPhonesForSale() {
		LOGGER.info("Smart Phones for sale:");
		LOGGER.info("-------------------------------------------------------------------");
		LOGGER.info("BRAND\tMODEL\t\tSIZE(inch)\tRAM(GB)\tPIXELS\tPRICE(USD)");
		LOGGER.info("-------------------------------------------------------------------");
		listOfSmartPhonesForSale.stream()
				.forEach(smartPhones -> LOGGER.info(smartPhones.getBrand() + "\t" + smartPhones.getModel() + "\t"
						+ smartPhones.getSizeInInchs() + "\t\t" + smartPhones.getRamMemoryInGb() + "\t"
						+ smartPhones.getCameraPixel() + "\t" + smartPhones.getPriceInUSD()));
		LOGGER.info("\n");
	}

	public void showSmartTVsForSale() {
		LOGGER.info("Smart TVs for sale:");
		LOGGER.info("----------------------------------------------------------");
		LOGGER.info("BRAND\t\tMODEL\t\tSIZE(inch)\tPRICE(USD)");
		LOGGER.info("----------------------------------------------------------");
		listOfSmartTVsForSale.stream().forEach(smartTV -> LOGGER.info(smartTV.getBrand() + "\t\t" + smartTV.getModel()
				+ "\t" + smartTV.getSizeInInchs() + "\t\t" + smartTV.getPriceInUSD()));
		LOGGER.info("\n");
	}

}
