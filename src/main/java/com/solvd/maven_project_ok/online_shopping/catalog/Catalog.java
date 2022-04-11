package com.solvd.maven_project_ok.online_shopping.catalog;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.maven_project_ok.exception.ProductNotFoundException;

public class Catalog {
	public static final Logger LOGGER = LogManager.getLogger(Catalog.class);
	private LinkedHashSet<Computer> listOfComputersForSale = new LinkedHashSet<Computer>();
	private LinkedHashSet<SmartPhone> listOfSmartPhonesForSale = new LinkedHashSet<SmartPhone>();
	private LinkedHashSet<SmartTV> listOfSmartTVsForSale = new LinkedHashSet<SmartTV>();
	private Map<String, LinkedHashSet<SmartPhone>> smartPhoneKeyWords = new HashMap<String, LinkedHashSet<SmartPhone>>();
	private Map<String, LinkedHashSet<SmartTV>> smartTVKeyWords = new HashMap<String, LinkedHashSet<SmartTV>>();

	public void findProduct(String pattern) throws ProductNotFoundException {
		ISearchable searchable = (product) -> Arrays.asList(product.getKeyWords()).contains(pattern.toUpperCase());
		Products matcher = null;
		for (Products product : Products.values()) {
			if (searchable.search(product)) {
				matcher = product;
				break;
			} else {
				throw new ProductNotFoundException();
			}
		}
		switch (matcher) {
		case COMPUTER:
			showComputersForSale();
			break;
		case SMART_PHONE:
			showComputersForSale();
			break;
		case SMART_TV:
			showComputersForSale();
			break;
		default:
			break;
		}
	}

	public void findAProduct(String pattern) {
		while (true) {
			try {
				findProduct(pattern);
			} catch (ProductNotFoundException e) {
				LOGGER.error("A product with the specified name could not be found, please try again", e);
			}
		}
	}

	public void showComputersForSale() {
		LOGGER.info(listOfComputersForSale);
	}

	public void showSmartPhonesForSale() {
		LOGGER.info(listOfSmartPhonesForSale);
	}

	public void showSmartTVsForSale() {
		LOGGER.info(listOfSmartTVsForSale);
	}

	public void showCatalogOfItemsForSale() {
		showComputersForSale();
		showSmartPhonesForSale();
		showSmartTVsForSale();
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
		return listOfSmartTVsForSale;
	}

	public void setListOfSmartsTVsForSale(LinkedHashSet<SmartTV> listOfSmartsTVsForSale) {
		this.listOfSmartTVsForSale = listOfSmartsTVsForSale;
	}
}
