package com.solvd.mavenprojectok.reflection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.mavenprojectok.onlineshopping.person.Adress;
import com.solvd.mavenprojectok.onlineshopping.person.Costumer;
import com.solvd.mavenprojectok.onlineshopping.person.Gender;
import com.solvd.mavenprojectok.onlineshopping.person.PhoneNumber;
import com.solvd.mavenprojectok.onlineshopping.person.UserAccount;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Date;

public class Reflection {
	public static final Logger LOGGER = LogManager.getLogger(Reflection.class);

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, SecurityException {

		Constructor<?>[] classCostumerConstructorsArray = Costumer.class.getDeclaredConstructors();
		Parameter[] firstConstructorParameters = classCostumerConstructorsArray[0].getParameters();
		Field[] fields = Costumer.class.getDeclaredFields();
		Field[] superClassFields = Costumer.class.getSuperclass().getDeclaredFields();
		Constructor<?>[] costumerSuperClassConstructorsArray = Costumer.class.getSuperclass().getDeclaredConstructors();
		String costumerSuperClassName = Costumer.class.getSuperclass().getName();
		
		Object person = costumerSuperClassConstructorsArray[1].newInstance("Beatrice", "Jenkins", 23124884,
				new Adress(42, "Wallaby Way", "Sydney", "Australia"), new Date(), Gender.FEMALE,
				new PhoneNumber(02, null, 98765432), new UserAccount("beatriceJenkins09", "difficultPassword"));
		Object costumer = classCostumerConstructorsArray[0].newInstance();
		Method[] classCostumerMethods = costumer.getClass().getDeclaredMethods();

//		Constructor<?>[] classCostumerConstructorsArray = Costumer.class.getDeclaredConstructors();
//		
//		Parameter[] param = classCostumerConstructorsArray[0].getParameters();
//		
//		Object consumer = classCostumerConstructorsArray[0].newInstance(param[0]);
//		
//		Field[] fields = consumer.getClass().getDeclaredFields();
//		

//		"The superclass of the " + Costumer.class.getSuperclass().getName()
//		Costumer costumer = classCostumerConstructorsArray[0].newInstance(args);

		LOGGER.info(Arrays.toString(classCostumerConstructorsArray));
		LOGGER.info(Arrays.toString(firstConstructorParameters));
		LOGGER.info(Arrays.toString(fields));
		LOGGER.info(Arrays.toString(superClassFields));
		LOGGER.info(costumerSuperClassName);
		LOGGER.info(Arrays.toString(classCostumerMethods));
	}
}
