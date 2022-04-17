package com.solvd.mavenprojectok.onlineshopping.catalog;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.mavenprojectok.onlineshopping.exception.InvalidOptionInputException;

public class ReadNumericOptionsFromUser {
	public static final Logger LOGGER = LogManager.getLogger(ReadNumericOptionsFromUser.class);

	private int readOptionFromUser(int maxOptionExpected) throws InvalidOptionInputException {
		int option;
		try (Scanner sn = new Scanner(System.in)) {
			option = sn.nextInt();
			if (option < 1 || option > maxOptionExpected) {
				throw new InvalidOptionInputException();
			}
		}
		return option;
	}

	public int optionFromUser(int maxOptionExpected) {
		while (true) {
			try {
				return readOptionFromUser(maxOptionExpected);
			} catch (InvalidOptionInputException | InputMismatchException e) {
				LOGGER.error("Invalid option entered, please try again", e);
				continue;
			}
		}
	}
}
