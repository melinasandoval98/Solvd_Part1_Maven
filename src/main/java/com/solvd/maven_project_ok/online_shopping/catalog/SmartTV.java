package com.solvd.maven_project_ok.online_shopping.catalog;

import com.solvd.maven_project_ok.online_shopping.catalog.enums.SmartTVBrands;

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
