package com.solvd.mavenprojectok.onlineshopping.person;

import java.util.HashMap;

@FunctionalInterface
public interface IVerifyable {
	boolean verify(HashMap<String, Integer> mapOfElementes, String userName, String password);
}
