package com.solvd.maven_project_ok.online_shopping.catalog;

public enum Products {
	COMPUTER("computer", "Computer"), SMART_TV("smart phone", "smartphone"), SMART_PHONE("smartTV", "smart TV");

	private String[] keyWords;

	Products(String... keyWords) {
		this.keyWords = keyWords;
	}

	public String[] getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String[] keyWords) {
		this.keyWords = keyWords;
	}

}
