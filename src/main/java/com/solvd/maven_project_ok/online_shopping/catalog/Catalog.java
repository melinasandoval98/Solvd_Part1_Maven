package com.solvd.maven_project_ok.online_shopping.catalog;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.maven_project_ok.exception.ProductNotFoundException;
import com.solvd.maven_project_ok.online_shopping.catalog.enums.Products;

public class Catalog {
	public static final Logger LOGGER = LogManager.getLogger(Catalog.class);
	private LinkedHashSet<Computer> listOfComputersForSale = new LinkedHashSet<Computer>();
	private LinkedHashSet<SmartPhone> listOfSmartPhonesForSale = new LinkedHashSet<SmartPhone>();
	private LinkedHashSet<SmartTV> listOfSmartTVsForSale = new LinkedHashSet<SmartTV>();

	@Override
	public String toString() {
		return "Catalog [listOfComputersForSale=" + listOfComputersForSale + ", listOfSmartPhonesForSale="
				+ listOfSmartPhonesForSale + ", listOfSmartTVsForSale=" + listOfSmartTVsForSale + "]";
	}

	public void findProductByKeyword(String pattern) throws ProductNotFoundException {
		ISearchable searchable = (product) -> Arrays.asList(product.getKeyWords()).contains(pattern.toUpperCase());
		if (Arrays.asList(Products.values()).stream().filter((product) -> searchable.search(product)) == null) {
			throw new ProductNotFoundException();
		} else {
			showProductsOfCategory(pattern);
		}
	}

	public void showProductsOfCategory(String product) {
		switch (Products.valueOf(product.toUpperCase())) {
		case COMPUTER:
			LOGGER.info(listOfComputersForSale);
			break;
		case SMART_PHONE:
			LOGGER.info(listOfSmartPhonesForSale);
			break;
		case SMART_TV:
			LOGGER.info(listOfSmartTVsForSale);
			break;
		default:
			break;
		}
	}

	public void showCatalogOfItemsForSale() {
		LOGGER.info(listOfComputersForSale);
		LOGGER.info(listOfSmartPhonesForSale);
		LOGGER.info(listOfSmartTVsForSale);
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
