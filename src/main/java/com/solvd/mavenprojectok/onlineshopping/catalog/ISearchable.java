package com.solvd.mavenprojectok.onlineshopping.catalog;

import com.solvd.mavenprojectok.onlineshopping.catalog.enums.Products;

@FunctionalInterface
public interface ISearchable {
	boolean search(Products product);
}
