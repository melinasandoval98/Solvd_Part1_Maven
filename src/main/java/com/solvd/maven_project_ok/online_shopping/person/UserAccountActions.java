package com.solvd.maven_project_ok.online_shopping.person;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.maven_project_ok.online_shopping.catalog.Catalog;

public enum UserAccountActions {
	LOG_IN {
		UserAccount userAccount = new UserAccount();

		@SuppressWarnings("unused")
		void logInAccount() {
			try (Scanner sn = new Scanner(System.in)) {
				LOGGER.info("Please, enter your username and your password");
				userAccount.logIn(sn.nextLine(), sn.nextLine());
			}

		}

	},
	LOG_OUT {
		UserAccount userAccount = new UserAccount();

		@SuppressWarnings("unused")
		void logOutAccount() {
			userAccount.logOut();
			LOGGER.info("Thank you for shopping in our store, come back soon!");
		}

	};

	public static final Logger LOGGER = LogManager.getLogger(Catalog.class);

}
