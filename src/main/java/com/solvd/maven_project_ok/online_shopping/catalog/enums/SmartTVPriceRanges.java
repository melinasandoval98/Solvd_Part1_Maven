package com.solvd.maven_project_ok.online_shopping.catalog.enums;

public enum SmartTVPriceRanges {
	RANGE_1(1000, 1500), RANGE_2(1500, 4000);

	private int minPrice;
	private int maxPrice;

	SmartTVPriceRanges(int minPrice, int maxPrice) {
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
