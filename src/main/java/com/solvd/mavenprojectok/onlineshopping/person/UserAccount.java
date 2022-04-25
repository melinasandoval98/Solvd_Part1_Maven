package com.solvd.mavenprojectok.onlineshopping.person;

import org.apache.logging.log4j.Logger;

import com.solvd.mavenprojectok.onlineshopping.exception.IncorrectUsserNameOrPasswordException;

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

	private void logInAccount(IVerifyable verifayable) throws IncorrectUsserNameOrPasswordException {
		if (status == false) {
			status = verifayable.verify(MapOfUserNamesAndPasswords, userName, password);
			LOGGER.info("Hello, " + userName + "!");
		} else {
			throw new IncorrectUsserNameOrPasswordException();
		}
	}

	@Override
	public void logIn(IVerifyable verifayable) {
		while (true) {
			try {
				logInAccount(verifayable);
				break;
			} catch (IncorrectUsserNameOrPasswordException e) {
				LOGGER.error("Wrong user name or passwor, please try again");
				continue;
			}
		}
	}

	@Override
	public void logOut() {
		if (status) {
			status = false;
			LOGGER.info("Bye!");
		}
	}

	@Override
	public String toString() {
		return "UserAccount [userName=" + userName + ", password=" + password + ", statusIn=" + status + "]";
	}

}
