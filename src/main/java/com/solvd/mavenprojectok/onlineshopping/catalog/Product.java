package com.solvd.mavenprojectok.onlineshopping.catalog;

public class Product {
	private String model;
	private double priceInUSD;
	private int availiability;
	private double sizeInInchs;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPriceInUSD() {
		return priceInUSD;
	}

	public void setPriceInUSD(double price) {
		this.priceInUSD = price;
	}

	public int getAvailiability() {
		return availiability;
	}

	public void setAvailiability(int availiability) {
		this.availiability = availiability;
	}

	public double getSizeInInchs() {
		return sizeInInchs;
	}

	public void setSizeInInchs(double sizeInInchs) {
		this.sizeInInchs = sizeInInchs;
	}

	@Override
	public String toString() {
		return "Product [model=" + model + ", priceInUSD=" + priceInUSD + ", availiability=" + availiability
				+ ", sizeInInchs=" + sizeInInchs + "]";
	}

}
