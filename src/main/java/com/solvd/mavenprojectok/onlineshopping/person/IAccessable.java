package com.solvd.mavenprojectok.onlineshopping.person;

public interface IAccessable {

	public abstract String logIn(IVerifyable verifyable);

	public abstract String logOut();

}
