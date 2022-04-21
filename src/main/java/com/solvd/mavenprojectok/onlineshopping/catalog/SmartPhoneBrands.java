package com.solvd.mavenprojectok.onlineshopping.catalog;

public enum SmartPhoneBrands {
	I_PHONE("IPhone"), SAMSUNG("Samsung");

	String brandName;

	SmartPhoneBrands(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandName() {
		return brandName;
	}

}
