package com.solvd.mavenprojectok.onlineshopping.catalog;

public enum Products {
	COMPUTER("computer", "computers"), SMART_TV("smart phone", "smartphone", "smart phones"),
	SMART_PHONE("smarttv", "smart tv");

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
