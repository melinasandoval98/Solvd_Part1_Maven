package com.solvd.maven_project_ok.online_shopping.person;

import com.solvd.maven_project_ok.online_shopping.catalog.Computer;
import com.solvd.maven_project_ok.online_shopping.catalog.SmartPhone;
import com.solvd.maven_project_ok.online_shopping.catalog.SmartTV;

public interface IConsume {

	public abstract void addComputerToTheCart(Computer computer);

	public abstract void addSmartPhoneToTheCart(SmartPhone smartPhone);

	public abstract void addSmartTVToTheCart(SmartTV smartTV);

	public abstract void removeComputerFromTheCart(Computer computer);

	public abstract void removeSmartPhoneFromTheCart(SmartPhone smartPhone);

	public abstract void removeSmartTVFromTheTheCart(SmartTV smartTV);

}
