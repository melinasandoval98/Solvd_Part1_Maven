package com.solvd.Maven_Project.onlineShopping.person;

public interface IConsume {
	
	public abstract void addProductToCart(Integer productCategry);
	
	public abstract void removeProductFromCart(Integer productCategry, Integer productIndex);

}
