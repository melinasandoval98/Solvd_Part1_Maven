package com.solvd.mavenprojectok.helloworld;

import java.util.Scanner;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("What's your name?");
		Scanner sn = new Scanner(System.in);
		try {
			String userName = sn.nextLine();
			System.out.println("Hello " + userName + "!");
		} finally {
			sn.close();
		}
	}
}