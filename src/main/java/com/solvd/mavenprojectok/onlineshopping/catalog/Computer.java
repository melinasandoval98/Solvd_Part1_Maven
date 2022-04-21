package com.solvd.mavenprojectok.onlineshopping.catalog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.mavenprojectok.onlineshopping.cart.Cart;

public class Computer extends Product {
	public static final Logger LOGGER = LogManager.getLogger(Cart.class);
	private int ramMemoryInGb;
	private String processor;
	private String hardDiskType;
	private String hardDiskCapacity;

	public Computer() {
		super();
	}

	public Computer(String brand, String model, double price, int availiability, double sizeInInchs, int ramMemoryInGb,
			String processor, String hardDiskType, String hardDiskCapacity) {
		super(brand, model, price, availiability, sizeInInchs);
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

	@Override
	public String toString() {
		return "Computer [ramMemoryInGb=" + ramMemoryInGb + ", processor=" + processor + ", hardDiskType="
				+ hardDiskType + ", hardDiskCapacity=" + hardDiskCapacity + ", brand=" + brand + ", model=" + model
				+ ", priceInUSD=" + priceInUSD + ", availiability=" + availiability + ", sizeInInchs=" + sizeInInchs
				+ "]";
	}

}
