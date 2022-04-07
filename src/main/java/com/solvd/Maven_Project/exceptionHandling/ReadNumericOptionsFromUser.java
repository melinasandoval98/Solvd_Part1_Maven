package com.solvd.Maven_Project.exceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.Maven_Project.exception.InvalidOptionInputException;

public class ReadNumericOptionsFromUser {
	public static final Logger LOGGER = LogManager.getLogger(ReadNumericOptionsFromUser.class);

	private void readOptionFromUser(Integer option, Integer maxOptionExpected) throws InvalidOptionInputException {
		try (Scanner sn = new Scanner(System.in)) {
			option =  sn.nextInt();
			if (option < 1 || option > maxOptionExpected) {
				throw new InvalidOptionInputException();
			}
		}
	}

	private void logErrorReadNumericOption(Exception e) {
		LOGGER.error(e);
		LOGGER.info("Invalid option entered, please try again");
	}

	public void optionFromUser(Integer option, Integer maxOptionExpected) {
		while (true) {
			try {
				readOptionFromUser(option, maxOptionExpected);
				break;
			} catch (InvalidOptionInputException | InputMismatchException e) {
				logErrorReadNumericOption(e);
				continue;
			}
		}
	}
}
