package com.solvd.mavenprojectok.onlineshopping.catalog;

public enum SmartTVBrands {
	NOBLEX("Noblex"), HITACHI("Hitachi"), PHILIPS("Philips");

	private String brandName;

	private SmartTVBrands(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandName() {
		return brandName;
	}

}
