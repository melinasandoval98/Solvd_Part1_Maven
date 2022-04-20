package com.solvd.mavenprojectok.onlineshopping.catalog.enums;

public enum ComputerBrands {
	MAC("Mac"), LENOVO("Lenovo"), ACER("Acer");

	private String brandName;

	ComputerBrands(String string) {
		this.brandName = string;
	}

	public String getBrandName() {
		return brandName;
	}
}
