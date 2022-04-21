package com.solvd.mavenprojectok.onlineshopping.catalog;

public class SmartTV extends Product {

	public SmartTV() {
	}

	public SmartTV(String brand, String model, double price, int availiability, double sizeInInchs) {
		super(brand, model, price, availiability, sizeInInchs);
	}

	@Override
	public String toString() {
		return "SmartTV [brand=" + brand + ", model=" + model + ", priceInUSD=" + priceInUSD + ", availiability="
				+ availiability + ", sizeInInchs=" + sizeInInchs + "]";
	}

}
