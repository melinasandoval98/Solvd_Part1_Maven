package com.solvd.mavenprojectok.onlineshopping.catalog;

@FunctionalInterface
public interface ISearchable {
	boolean search(String[] stringArray, String string);
}
