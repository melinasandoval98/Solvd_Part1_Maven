package com.solvd.Maven_Project.onlineShopping.catalog;

public class SmartTV extends Product{
	public SmartTV() {
	}
	
	public SmartTV(String brand, String model, double price, int availiability, double sizeInInchs) {
		this.setBrand(brand);
		this.setModel(model);
		this.setPriceInUSD(price);
		this.setAvailiability(availiability);
	}
}
