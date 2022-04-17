package com.solvd.mavenprojectok.onlineshopping.catalog.enums;

public enum ComputerPriceRanges {
	RANGE_1(2000, 5000), RANGE_2(5000, 9000), RANGE_3(9000, 1500);

	private int minPrice;
	private int maxPrice;

	private ComputerPriceRanges(int minPrice, int maxPrice) {
		this.setMinPrice(minPrice);
		this.setMaxPrice(maxPrice);
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

}
