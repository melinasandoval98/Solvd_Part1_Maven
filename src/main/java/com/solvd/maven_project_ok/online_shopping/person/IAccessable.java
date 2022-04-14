package com.solvd.maven_project_ok.online_shopping.person;

public interface IAccessable {

	public abstract boolean logIn(String userName, String password);

	public abstract boolean logOut();

}
