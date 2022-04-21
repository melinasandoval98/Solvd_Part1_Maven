package com.solvd.mavenprojectok.helloworld;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorld {
	public static final Logger LOGGER = LogManager.getLogger(HelloWorld.class);

	public static void main(String[] args) {
		LOGGER.info("What's your name?");
		try (Scanner sn = new Scanner(System.in)) {
			String userName = sn.nextLine();
			LOGGER.info("Hello " + userName + "!");
		}
	}
}