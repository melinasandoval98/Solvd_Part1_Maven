package com.solvd.maven_project_ok.online_shopping.catalog.enums;

public enum SmartPhonePriceRanges {
	RANGE_1(2000, 5000), RANGE_2(5000, 9000), RANGE_3(9000, 1500);

	private int minPrice;
	private int maxPrice;

	SmartPhonePriceRanges(int minPrice, int maxPrice) {
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
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
