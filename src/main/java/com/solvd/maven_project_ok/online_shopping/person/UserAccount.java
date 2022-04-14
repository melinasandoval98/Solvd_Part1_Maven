package com.solvd.maven_project_ok.online_shopping.person;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class UserAccount implements IAccessable {
	public static final Logger LOGGER = LogManager.getLogger(UserAccount.class);
	private String userName;
	private String password;
	private boolean statusIn;
	private boolean statusOut;

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

	public UserAccount(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public UserAccount() {

	}

	@Override
	public boolean logIn(String userName, String password) {
		Administrator admin = new Administrator();
		if (logOut()) {
			IVerifyable verifayable = () -> admin.getMapOfUserNamesAndPasswords().containsKey(userName)
					&& password.hashCode() == admin.getMapOfUserNamesAndPasswords().get(userName);
			statusIn = verifayable.verify();
		}
		return statusIn;
	}

	@Override
	public boolean logOut() {
		if (statusIn) {
			statusIn = false;
			statusOut = true;
		}
		return statusOut;
	}

}
