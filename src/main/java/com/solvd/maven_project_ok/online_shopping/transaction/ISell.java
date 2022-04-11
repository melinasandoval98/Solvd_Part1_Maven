package com.solvd.maven_project_ok.online_shopping.transaction;

import com.solvd.maven_project_ok.online_shopping.catalog.Computer;
import com.solvd.maven_project_ok.online_shopping.catalog.SmartPhone;
import com.solvd.maven_project_ok.online_shopping.catalog.SmartTV;

//This interface determines the behavior of product stocks during the sale 
//of products added to the cart
public interface ISell {

	void sellComputer(Computer c);

	void sellSmartPhone(SmartPhone sm);

	void sellSmartTV(SmartTV st);
}
