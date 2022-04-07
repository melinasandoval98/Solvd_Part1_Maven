package com.solvd.Maven_Project.onlineShopping.catalog;

import java.util.LinkedHashSet;

public abstract class Product {
	private String brand;
	private String model;
	private double priceInUSD;
	private int availiability;
	private double sizeInInchs;
	private LinkedHashSet<Object> listOfItemsForSale = new LinkedHashSet<Object>();
	
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
	public LinkedHashSet<Object> getListOfItemsForSale() {
		return listOfItemsForSale;
	}
	public void setListOfItemsForSale(LinkedHashSet<Object> listOfItemsForSale) {
		this.listOfItemsForSale = listOfItemsForSale;
	}
}
