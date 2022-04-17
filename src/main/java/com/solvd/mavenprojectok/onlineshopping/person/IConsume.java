package com.solvd.mavenprojectok.onlineshopping.person;

import com.solvd.mavenprojectok.onlineshopping.catalog.Computer;
import com.solvd.mavenprojectok.onlineshopping.catalog.SmartPhone;
import com.solvd.mavenprojectok.onlineshopping.catalog.SmartTV;

public interface IConsume {

	public abstract void addComputerToTheCart(Computer computer);

	public abstract void addSmartPhoneToTheCart(SmartPhone smartPhone);

	public abstract void addSmartTVToTheCart(SmartTV smartTV);

	public abstract void removeComputerFromTheCart(Computer computer);

	public abstract void removeSmartPhoneFromTheCart(SmartPhone smartPhone);

	public abstract void removeSmartTVFromTheTheCart(SmartTV smartTV);

}
