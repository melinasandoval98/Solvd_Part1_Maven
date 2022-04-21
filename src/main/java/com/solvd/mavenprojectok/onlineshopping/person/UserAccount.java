package com.solvd.mavenprojectok.onlineshopping.person;

import org.apache.logging.log4j.Logger;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;

public class UserAccount implements IAccessable {
	public static final Logger LOGGER = LogManager.getLogger(UserAccount.class);
	private String userName;
	private String password;
	private boolean status;
	public static HashMap<String, Integer> MapOfUserNamesAndPasswords = new HashMap<String, Integer>();

	public static HashMap<String, Integer> getMapOfUserNamesAndPasswords() {
		return MapOfUserNamesAndPasswords;
	}

	public static void setMapOfUserNamesAndPasswords(HashMap<String, Integer> mapOfUserNamesAndPasswords) {
		MapOfUserNamesAndPasswords = mapOfUserNamesAndPasswords;
	}

	public UserAccount(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String logIn(IVerifyable verifayable) {
		if (status == false) {
			status = verifayable.verify(MapOfUserNamesAndPasswords, userName, password);
		}
		return "Successful Login";
	}

	@Override
	public String logOut() {
		if (status) {
			status = false;
		}
		return "Bye!";
	}

	@Override
	public String toString() {
		return "UserAccount [userName=" + userName + ", password=" + password + ", statusIn=" + status + "]";
	}

}
