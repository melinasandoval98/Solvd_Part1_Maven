package com.solvd.Maven_Project.onlineShopping.catalog;

public class SmartPhone extends Product {
	private int ramMemoryInGB;
	private int cameraPixel;
	private String color;
	private boolean bluetooth;
	
	public SmartPhone() {
	}
	
	public SmartPhone(String brand, String model, double price, int availiability, double sizeInInchs, int ramMemoryInGb, int cameraPixel, String color, boolean bluetooth) {
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
}
