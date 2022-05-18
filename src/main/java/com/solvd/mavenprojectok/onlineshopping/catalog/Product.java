package com.solvd.mavenprojectok.onlineshopping.catalog;

public class Product {
	public String brand;
	public String model;
	public double priceInUSD;
	public int availiability;
	public double sizeInInchs;

	public Product() {
	}

	public Product(String brand, String model, double price, int availiability, double sizeInInchs) {
		this.brand = brand;
		this.model = model;
		this.priceInUSD = price;
		this.availiability = availiability;
		this.sizeInInchs = sizeInInchs;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

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
