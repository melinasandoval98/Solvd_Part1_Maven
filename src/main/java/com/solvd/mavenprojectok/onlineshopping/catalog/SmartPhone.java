package com.solvd.mavenprojectok.onlineshopping.catalog;

public class SmartPhone extends Product {
	private int ramMemoryInGB;
	private int cameraPixel;
	private String color;
	private boolean bluetooth;

	public SmartPhone() {
	}

	public SmartPhone(String brand, String model, double price, int availiability, double sizeInInchs,
			int ramMemoryInGb, int cameraPixel, String color, boolean bluetooth) {
		super(brand, model, price, availiability, sizeInInchs);
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

	@Override
	public String toString() {
		return "SmartPhone [ramMemoryInGB=" + ramMemoryInGB + ", cameraPixel=" + cameraPixel + ", color=" + color
				+ ", bluetooth=" + bluetooth + ", brand=" + brand + ", model=" + model + ", priceInUSD=" + priceInUSD
				+ ", availiability=" + availiability + ", sizeInInchs=" + sizeInInchs + "]";
	}

}
