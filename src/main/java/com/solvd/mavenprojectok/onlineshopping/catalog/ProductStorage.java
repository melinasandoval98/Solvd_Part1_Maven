package com.solvd.mavenprojectok.onlineshopping.catalog;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.mavenprojectok.onlineshopping.exception.ProductNotFoundException;

public class ProductStorage {
	public static final Logger LOGGER = LogManager.getLogger(ProductStorage.class);
	private HashMap<Products, Object> fullCatalog = new HashMap<Products, Object>();

	public HashMap<Products, Object> getFullCatalog() {
		return fullCatalog;
	}

	private void searchProductTypeByKeyword(ISearchable searchable, String pattern) throws ProductNotFoundException {
		@SuppressWarnings("unused")
		boolean isProductFound;
		for (Products product : Products.values()) {
			if (searchable.search(product.getKeywords(), pattern.toLowerCase())) {
				isProductFound = true;
				LOGGER.info("Search results for '" + pattern + "'\n" + fullCatalog.get(product) + "\n");
				break;
			}
		}
		if (isProductFound = false) {
			throw new ProductNotFoundException();
		}
	}

	public void findProductTypeByKeyword(ISearchable searchable, String pattern) {
		try {
			searchProductTypeByKeyword(searchable, pattern);
		} catch (ProductNotFoundException e) {
			LOGGER.error("No products have been found for the keyword '" + pattern + "'", e);
		}
	}

}
