package com.solvd.mavenprojectok.onlineshopping.catalog;

import com.solvd.mavenprojectok.onlineshopping.catalog.enums.SmartTVBrands;

public class SmartTV extends Product {
	private SmartTVBrands brand;

	public SmartTV() {
	}

	public SmartTV(SmartTVBrands brand, String model, double price, int availiability, double sizeInInchs) {
		this.setBrand(brand);
		this.setModel(model);
		this.setPriceInUSD(price);
		this.setAvailiability(availiability);
	}

	public SmartTVBrands getBrand() {
		return brand;
	}

	public void setBrand(SmartTVBrands brand) {
		this.brand = brand;
	}
}
