package com.solvd.Maven_Project.exceptionHandling;
//package com.solvd.exception;
//
////import java.util.Map;
//import java.util.Scanner;
//import java.lang.Object;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import com.solvd.onlineShopping.catalog.Catalog;
//
//public class SearchProductInput<X,Y,Z> {
////	public static final Logger LOGGER = LogManager.getLogger(Catalog.class);
////	X value;
////	Y value2;
////	Z value3;
////	
////	public Z getValue3() {
////		return value3;
////	}
////	public void setValue3(Z z) {
////		this.value3 = z;
////	}
////
////	public Y getValue2() {
////		return value2;
////	}
////	public void setValue2(Y y) {
////		this.value2 = y;
////	}
////	
////	public X getValue() {
////		return value;
////	}
////	public void setValue(X x) {
////		this.value = x;
////	}
////	
////	//**private <X,Y,Z> Object searchProductCategory(String productName, Map<String, X> m, Map<String, Y> m2, Map<String, Z> m3) throws ProductNotFoundException {
////		if(m.containsKey(productName) && m2.containsKey(productName) && m3.containsKey(productName) == false) {
////			throw new ProductNotFoundException();
////		} else {
////			if (m.containsKey(productName)) {
////				setValue(m.get(productName));
////				setValue2(null);
////				setValue3(null);
////			} else {
////				if (m2.containsKey(productName)) {
////					setValue2(m2.get(productName));
////					setValue(null);
////					setValue3(null);
////				} else {
////					if (m3.containsKey(productName)) {
////						setValue3(m3.get(productName));
////						setValue(null);
////						setValue2(null);
////					}
////				}
////			}
////		}
////		return firstNonNull(value, value2, value3);
////	//**}
////	
////	private void logErrorsearchProduct(Exception e) {
////		LOGGER.error(e);
////		LOGGER.info("A product with the name entered cloud not be found, please try again");
////	}
////	
////	public void productCategory(String productName, Map<String, X> m, Map<String, Y> m2, Map<String, Z> m3) {
////		while(true) {
////			try(Scanner sn = new Scanner(System.in)){
////				productName = sn.next();
////				searchProductCategory(productName, m, m2, m3);
////			} catch(ProductNotFoundException e) {
////				logErrorsearchProduct(e);
////			}
////		}
////	}
////	
////	for (K product : )
////	
//}
