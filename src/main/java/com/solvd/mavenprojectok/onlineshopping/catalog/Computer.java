package com.solvd.mavenprojectok.onlineshopping.catalog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.mavenprojectok.onlineshopping.cart.Cart;
import com.solvd.mavenprojectok.onlineshopping.catalog.enums.ComputerBrands;

public class Computer extends Product {
	public static final Logger LOGGER = LogManager.getLogger(Cart.class);
	private int ramMemoryInGb;
	private String processor;
	private String hardDiskType;
	private String hardDiskCapacity;
	private ComputerBrands brand;

	public Computer() {
		super();
	}

	public Computer(ComputerBrands brand, String model, double price, int availiability, double sizeInInchs,
			int ramMemoryInGb, String processor, String hardDiskType, String hardDiskCapacity) {
		super(model, price, availiability, sizeInInchs);
		this.ramMemoryInGb = ramMemoryInGb;
		this.processor = processor;
		this.hardDiskType = hardDiskType;
		this.hardDiskCapacity = hardDiskCapacity;
		this.brand = brand;
	}

	public int getRamMemoryInGb() {
		return ramMemoryInGb;
	}

	public void setRamMemoryInGb(int ramMemoryInGb) {
		this.ramMemoryInGb = ramMemoryInGb;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getHardDiskType() {
		return hardDiskType;
	}

	public void setHardDiskType(String hardDiskType) {
		this.hardDiskType = hardDiskType;
	}

	public String getHardDiskCapacity() {
		return hardDiskCapacity;
	}

	public void setHardDiskCapacity(String hardDiskCapacity) {
		this.hardDiskCapacity = hardDiskCapacity;
	}

	public ComputerBrands getBrand() {
		return brand;
	}

	public void setBrand(ComputerBrands brand) {
		this.brand = brand;
	}

}
