package com.solvd.maven_project_ok.online_shopping.person;

import java.util.Scanner;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class UserAccount extends Costumer implements IAccessable {
	public static final Logger LOGGER = LogManager.getLogger(UserAccount.class);

	public void accountAction(UserActions action) {
		switch (action) {
		case LOG_IN:
			logIn();
			break;
		case LOG_OUT:
			logOut();
			break;
		case SING_IN:
			createAccount();
			break;
		}
	}

	@Override
	public void createAccount() {
		try (Scanner sn = new Scanner(System.in);) {
			LOGGER.info("Please, enter your first and last name");
			String[] nameAndSurname = sn.nextLine().split(" ", 1);
			setName(nameAndSurname[1]);
			setSurname(nameAndSurname[2]);
			LOGGER.info("Please, enter your ID number");
			setID(sn.nextInt());
			LOGGER.info("Please, enter your ID number");

		}
		setUserName(getName() + Integer.toString(getID()));
		StringBuilder strb = new StringBuilder(getSurname() + getID());
		setPassword(strb.reverse().toString());
	}

	@Override
	public void logIn() {
		Scanner sn = new Scanner(System.in);
		LOGGER.info("Enter your username and password");
		String user;
		String password;
		while (true) {
			try {
				user = sn.next();
				password = sn.next();
				if (user != getUserName() || password != getPassword()) {
					throw new Exception();
				}
				break;
			} catch (Exception e) {
				LOGGER.info("Wrong username or password, please try again");
				continue;
			} finally {
				sn.close();
			}
		}
	}

	@Override
	public void logOut() {
		Person.setName(null);
		Person.setSurname(null);
	}

}