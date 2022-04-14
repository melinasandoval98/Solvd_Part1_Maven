package com.solvd.maven_project_ok.online_shopping.catalog;

import com.solvd.maven_project_ok.online_shopping.catalog.enums.Products;

@FunctionalInterface
public interface ISearchable {
	boolean search(Products product);
}
