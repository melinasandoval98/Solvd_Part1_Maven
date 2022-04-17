package com.solvd.mavenprojectok.onlineshopping.person;

public interface IAccessable {

	public abstract boolean logIn(String userName, String password);

	public abstract boolean logOut();

}
