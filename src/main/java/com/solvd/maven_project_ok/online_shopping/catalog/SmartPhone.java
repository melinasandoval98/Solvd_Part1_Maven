package com.solvd.maven_project_ok.online_shopping.catalog;

import com.solvd.maven_project_ok.online_shopping.catalog.enums.SmartPhoneBrands;

public class SmartPhone extends Product {
	private int ramMemoryInGB;
	private int cameraPixel;
	private String color;
	private boolean bluetooth;
	private SmartPhoneBrands brand;

	public SmartPhone() {
	}

	public SmartPhone(SmartPhoneBrands brand, String model, double price, int availiability, double sizeInInchs,
			int ramMemoryInGb, int cameraPixel, String color, boolean bluetooth) {
		this.setBrand(brand);
		this.setModel(model);
		this.setPriceInUSD(price);
		this.setAvailiability(availiability);
		this.ramMemoryInGB = ramMemoryInGb;
		this.cameraPixel = cameraPixel;
		this.color = color;
		this.bluetooth = bluetooth;
	}

	public int getRamMemoryInGb() {
		return ramMemoryInGB;
	}

	public void setRamMemoryInGb(int ramMemoryInGb) {
		this.ramMemoryInGB = ramMemoryInGb;
	}

	public int getCameraPixel() {
		return cameraPixel;
	}

	public void setCameraPixel(int cameraPixel) {
		this.cameraPixel = cameraPixel;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isBluetooth() {
		return bluetooth;
	}

	public void setBluetooth(boolean bluetooth) {
		this.bluetooth = bluetooth;
	}

	public SmartPhoneBrands getBrand() {
		return brand;
	}

	public void setBrand(SmartPhoneBrands brand) {
		this.brand = brand;
	}
}
