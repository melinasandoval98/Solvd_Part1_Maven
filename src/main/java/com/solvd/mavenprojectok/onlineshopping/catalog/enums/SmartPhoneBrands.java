package com.solvd.mavenprojectok.onlineshopping.catalog.enums;

public enum SmartPhoneBrands {
	I_PHONE("iPhone"), SAMSUNG("Samsung");

	private String brandName;

	SmartPhoneBrands(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandName() {
		return brandName;
	}

}
