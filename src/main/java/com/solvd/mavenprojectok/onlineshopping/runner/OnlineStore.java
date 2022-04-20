package com.solvd.mavenprojectok.onlineshopping.runner;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class OnlineStore {
	public static final Logger LOGGER = LogManager.getLogger(OnlineStore.class);

	public enum Actions {
		SEE_FULL_CATALOG, SEARCH_PRODUCT_BY_KEYWORD;
	}

	public enum FilterProductResults {
		ADD_PRODUCT_TO_CART,FILTER_RESULTS_BY_BRAND, FILTER_RESULTS_BY_PRICE_RANGE;
	}

}
