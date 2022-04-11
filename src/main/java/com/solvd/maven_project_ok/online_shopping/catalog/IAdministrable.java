package com.solvd.maven_project_ok.online_shopping.catalog;

public interface IAdministrable {

	public abstract void addComputerToTheListOfItemsForSale(Computer computer);

	public abstract void addSmartPhoneToTheListOfItemsForSale(SmartPhone smartPhone);

	public abstract void addSmartTVToTheListOfItemsForSale(SmartTV smartTV);

	public abstract void removeComputerFromTheListOfItemsForSale(Computer computer);

	public abstract void removeSmartPhoneFromTheListOfItemsForSale(SmartPhone smartPhone);

	public abstract void removeSmartTVFromTheListOfItemsForSale(SmartTV smartTV);

}
