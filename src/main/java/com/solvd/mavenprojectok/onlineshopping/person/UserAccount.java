package com.solvd.mavenprojectok.onlineshopping.person;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class UserAccount implements IAccessable {
	public static final Logger LOGGER = LogManager.getLogger(UserAccount.class);
	private String userName;
	private String password;
	private boolean status;

	public UserAccount() {

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
	public String logIn(String userName, String password) {
		Administrator admin = new Administrator();
		if (status == false) {
			IVerifyable verifayable = () -> admin.getMapOfUserNamesAndPasswords().containsKey(userName)
					&& password.hashCode() == admin.getMapOfUserNamesAndPasswords().get(userName);
			status = verifayable.verify();
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
