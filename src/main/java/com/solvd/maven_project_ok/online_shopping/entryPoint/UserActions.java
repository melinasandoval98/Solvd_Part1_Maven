package com.solvd.maven_project_ok.online_shopping.entryPoint;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.maven_project_ok.exception.ProductNotFoundException;
import com.solvd.maven_project_ok.online_shopping.catalog.Catalog;
import com.solvd.maven_project_ok.online_shopping.catalog.enums.ComputerBrands;
import com.solvd.maven_project_ok.online_shopping.catalog.enums.ComputerPriceRanges;
import com.solvd.maven_project_ok.online_shopping.catalog.enums.SmartPhoneBrands;
import com.solvd.maven_project_ok.online_shopping.catalog.enums.SmartPhonePriceRanges;
import com.solvd.maven_project_ok.online_shopping.catalog.enums.SmartTVBrands;
import com.solvd.maven_project_ok.online_shopping.catalog.enums.SmartTVPriceRanges;

public enum UserActions {
	SEARCH_PRODUCT_BY_KEYWORD {
		Catalog catalog = new Catalog();

		@SuppressWarnings("unused")
		public void searProductByKeyword(String pattern) {
			while (true) {
				try {
					catalog.findProductByKeyword(pattern);
					break;
				} catch (ProductNotFoundException e) {
					LOGGER.error("A product with the specified name could not be found, please try again", e);
					continue;
				}
			}
		}
	},
	SEE_FULL_CATALOG {
		Catalog catalog = new Catalog();

		@SuppressWarnings("unused")
		public void showFullCatalogOfProducts() {
			catalog.showCatalogOfItemsForSale();
		}
	},
	FILTER_COMPUTERS_BY_BRAND {
		Catalog catalog = new Catalog();

		@SuppressWarnings("unused")
		void showComputersOfBrand(ComputerBrands brand) {
			catalog.getListOfComputersForSale().stream()
					.filter((computers) -> computers.getBrand().equals(brand)).collect(Collectors.toList())
					.forEach(System.out::println);
		}
	},
	FILTER_COMPUTERS_BY_PRICE {
		Catalog catalog = new Catalog();

		void computersInTheRangeOfPrices(ComputerPriceRanges priceRange) throws ProductNotFoundException {
			if(catalog.getListOfComputersForSale().stream()
					.filter((computer) -> computer.getPriceInUSD()>priceRange.getMinPrice() && computer.getPriceInUSD()<priceRange
					.getMaxPrice()).collect(Collectors.toList()).size()!=0) {
				catalog.getListOfComputersForSale().stream()
				.filter((computer) -> computer.getPriceInUSD()>priceRange.getMinPrice() && computer.getPriceInUSD()<priceRange
				.getMaxPrice()).collect(Collectors.toList())
				.forEach(System.out::println);
			} else {
				throw new ProductNotFoundException();
			}
		}
		
		@SuppressWarnings("unused")
		void showComputersInTheRangeOfPrices(ComputerPriceRanges priceRange) {
			while (true) {
				try {
					computersInTheRangeOfPrices(priceRange);
					break;
				} catch (ProductNotFoundException e) {
					LOGGER.error("No computers were found in the selected price range. Please, select another range", e);
					continue;
				}
			}
		}
	},
	FILTER_SMART_PHONE_BY_BRAND {
		Catalog catalog = new Catalog();

		@SuppressWarnings("unused")
		void showSmartPhonesInTheRangeOfPrices(SmartPhoneBrands brand) {
			catalog.getListOfSmartPhonesForSale().stream()
					.filter((smartPhone) -> smartPhone.getBrand().equals(brand)).collect(Collectors.toList())
					.forEach(System.out::println);
		}
	},
	FILTER_SMART_PHONE_BY_PRICE {
		Catalog catalog = new Catalog();

		void smartPhonesInTheRangeOfPrices(SmartPhonePriceRanges priceRange) throws ProductNotFoundException {
			if(catalog.getListOfSmartPhonesForSale().stream()
					.filter((smartPhone) -> smartPhone.getPriceInUSD()>priceRange.getMinPrice() && smartPhone.getPriceInUSD()<priceRange
					.getMaxPrice()).collect(Collectors.toList()).size()!=0) {
				catalog.getListOfSmartPhonesForSale().stream()
				.filter((smartPhone) -> smartPhone.getPriceInUSD()>priceRange.getMinPrice() && smartPhone.getPriceInUSD()<priceRange
				.getMaxPrice()).collect(Collectors.toList())
				.forEach(System.out::println);
			} else {
				throw new ProductNotFoundException();
			}
		}
		
		@SuppressWarnings("unused")
		void showSmartPhonesInTheRangeOfPrices(SmartPhonePriceRanges priceRange) {
			while (true) {
				try {
					smartPhonesInTheRangeOfPrices(priceRange);
					break;
				} catch (ProductNotFoundException e) {
					LOGGER.error("no computers were found in the selected price range", e);
				}
			}
		}
	},
	FILTER_SMART_TV_BY_BRAND {
		Catalog catalog = new Catalog();

		@SuppressWarnings("unused")
		void showSmartTVInTheRangeOfPrices(SmartTVBrands brand) {
			catalog.getListOfSmartsTVsForSale().stream()
					.filter((smartTV) -> smartTV.getBrand().equals(brand)).collect(Collectors.toList())
					.forEach(System.out::println);
		}
	},
	FILTER_SMART_TV_BY_PRICE {
		Catalog catalog = new Catalog();

		void smartTVInTheRangeOfPrices(SmartTVPriceRanges priceRange) throws ProductNotFoundException {
			if(catalog.getListOfSmartsTVsForSale().stream()
					.filter((smartTV) -> smartTV.getPriceInUSD()>priceRange.getMinPrice() && smartTV.getPriceInUSD()<priceRange
					.getMaxPrice()).collect(Collectors.toList()).size()!=0) {
				catalog.getListOfSmartsTVsForSale().stream()
				.filter((smartTV) -> smartTV.getPriceInUSD()>priceRange.getMinPrice() && smartTV.getPriceInUSD()<priceRange
				.getMaxPrice()).collect(Collectors.toList())
				.forEach(System.out::println);
			} else {
				throw new ProductNotFoundException();
			}
		}
		
		@SuppressWarnings("unused")
		void showSmartTVInTheRangeOfPrices(SmartTVPriceRanges priceRange) {
			while (true) {
				try {
					smartTVInTheRangeOfPrices(priceRange);
					break;
				} catch (ProductNotFoundException e) {
					LOGGER.error("no computers were found in the selected price range", e);
				}
			}
		}
	};

	public static final Logger LOGGER = LogManager.getLogger(Catalog.class);

}
