package com.solvd.mavenprojectok.onlineshopping.catalog.enums;

public enum Products {
	COMPUTER("computer", "Computer"), SMART_TV("smart phone", "smartphone"), SMART_PHONE("smartTV", "smart TV");

	private String[] keywords;

	Products(String... keywords) {
		this.keywords = keywords;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

}
