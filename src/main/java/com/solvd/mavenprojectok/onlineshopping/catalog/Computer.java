package com.solvd.mavenprojectok.onlineshopping.catalog;

import com.solvd.mavenprojectok.onlineshopping.catalog.enums.ComputerBrands;

public class Computer extends Product {
	private int ramMemoryInGb;
	private String processor;
	private String hardDiskType;
	private String hardDiskCapacityInGB;
	private ComputerBrands brand;

	public Computer() {
	}

	public Computer(ComputerBrands brand, String model, double price, int availiability, double sizeInInchs,
			int ramMemoryInGb, String processor, String hardDiskType, String hardDiskCapacity) {
		this.setBrand(brand);
		this.setModel(model);
		this.setPriceInUSD(price);
		this.setAvailiability(availiability);
		this.ramMemoryInGb = ramMemoryInGb;
		this.processor = processor;
		this.hardDiskType = hardDiskType;
		this.hardDiskCapacityInGB = hardDiskCapacity;
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
		return hardDiskCapacityInGB;
	}

	public void setHardDiskCapacity(String hardDiskCapacity) {
		this.hardDiskCapacityInGB = hardDiskCapacity;
	}

	public ComputerBrands getBrand() {
		return brand;
	}

	public void setBrand(ComputerBrands brand) {
		this.brand = brand;
	}

}
