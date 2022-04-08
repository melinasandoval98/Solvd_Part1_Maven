package com.solvd.Maven_Project.onlineShopping.catalog;

public interface IAdministrable<T extends Product> {

	public abstract void createListOfItemsForSale();

	public abstract void addProductToTheListOfItemsForSale(T product);

	public abstract void removeProductFromTheListOfItemsForSale(T product);

}
