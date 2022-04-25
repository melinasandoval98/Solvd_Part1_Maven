package com.solvd.mavenprojectok.onlineshopping.catalog;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductCatalog<T extends Product> {
	public static final Logger LOGGER = LogManager.getLogger(ProductCatalog.class);
	private LinkedHashSet<T> listOfProductsForSale = new LinkedHashSet<T>();
	public static int numberOfCatalogsCreated;

	public ProductCatalog() {
		numberOfCatalogsCreated++;
	}

	public LinkedHashSet<T> getListOfProductsForSale() {
		return listOfProductsForSale;
	}

	public void addItemToTheCatalog(T product) {
		listOfProductsForSale.add(product);
	}

	public LinkedHashSet<T> fliterProductList(Function<String, LinkedHashSet<T>> filterByBrand, String brand) {
		return listOfProductsForSale;
	}

	public String showProductFullDataills(T product) {
		return product.toString();
	}

	public void fillterProductByBrand(BiFunction<LinkedHashSet<T>, String, List<T>> filterByBrand, String brand) {
		LOGGER.info("Search results: " + brand);
		LOGGER.info("---------------------------------------------------");
		LOGGER.info("BRAND\tMODEL\t\tSIZE(inch)\tPRICE(USD)");
		LOGGER.info("---------------------------------------------------");
		filterByBrand.apply(listOfProductsForSale, brand).forEach(product -> LOGGER.info(product.getBrand() + "\t"
				+ product.getModel() + "\t" + product.getSizeInInchs() + "\t\t" + product.getPriceInUSD()));
		LOGGER.info("\n");
	}

	public void showProductsForSale() {
		LOGGER.info("---------------------------------------------------");
		LOGGER.info("BRAND\tMODEL\t\tSIZE(inch)\tPRICE(USD)");
		LOGGER.info("---------------------------------------------------");
		listOfProductsForSale.stream().forEach(product -> LOGGER.info(product.getBrand() + "\t" + product.getModel()
				+ "\t" + product.getSizeInInchs() + "\t\t" + product.getPriceInUSD()));
		LOGGER.info("\n");
	}

	@Override
	public String toString() {
		return "ProductCatalog [listOfProductsForSale=" + listOfProductsForSale + "]";
	}

}
