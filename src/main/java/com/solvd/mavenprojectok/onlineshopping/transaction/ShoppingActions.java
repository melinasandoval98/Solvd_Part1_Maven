package com.solvd.mavenprojectok.onlineshopping.transaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.mavenprojectok.onlineshopping.catalog.Computer;
import com.solvd.mavenprojectok.onlineshopping.catalog.SmartPhone;
import com.solvd.mavenprojectok.onlineshopping.catalog.SmartTV;
import com.solvd.mavenprojectok.onlineshopping.exception.NoProductsInTheCartException;
import com.solvd.mavenprojectok.onlineshopping.paymentmethod.PaymentMethods;
import com.solvd.mavenprojectok.onlineshopping.person.Costumer;

public enum ShoppingActions {
	ADD_COMPUTER_TO_THE_CART {
		Costumer costumer = new Costumer();

		@SuppressWarnings("unused")
		void addComputerToTheCart(Computer computer) {
			costumer.addComputerToTheCart(computer);
			LOGGER.info("Computer added to the cart");
		}
	},
	REMOVE_COMPUTER_FROM_THE_CART {
		Costumer costumer = new Costumer();

		@SuppressWarnings("unused")
		void removeComputerFromTheCart(Computer computer) {
			costumer.removeComputerFromTheCart(computer);
			LOGGER.info("Computer removed from the cart");
		}
	},
	ADD_SMART_PHONE_TO_THE_CART {
		Costumer costumer = new Costumer();

		@SuppressWarnings("unused")
		void addSmartPhoneToTheCart(SmartPhone smartPhone) {
			costumer.addSmartPhoneToTheCart(smartPhone);
			LOGGER.info("Smart Phone added to the cart");
		}
	},
	REMOVE_SMART_PHONE_FROM_THE_CART {
		Costumer costumer = new Costumer();

		@SuppressWarnings("unused")
		void removeSmartPhoneFromTheCart(SmartPhone smartPhone) {
			costumer.removeSmartPhoneFromTheCart(smartPhone);
			LOGGER.info("Smart Phone removed from the cart");
		}
	},
	ADD_SMART_TV_TO_THE_CART {
		Costumer costumer = new Costumer();

		@SuppressWarnings("unused")
		void addSmartTVToTheCart(SmartTV smartTV) {
			costumer.addSmartTVToTheCart(smartTV);
			LOGGER.info("Smart TV added to the cart");
		}
	},
	REMOVE_SMART_TV_FROM_THE_CART {
		Costumer costumer = new Costumer();

		@SuppressWarnings("unused")
		void removeSmartTVFromTheCart(SmartTV smartTV) {
			costumer.removeSmartTVFromTheTheCart(smartTV);
			LOGGER.info("Smart TV removed from the cart");
		}
	},
	BUY_ALL_ITEMS_IN_THE_CART {
		Transaction transaction = new Transaction();

		@SuppressWarnings("unused")
		void buyComputersInTheCart(PaymentMethods paymentMethod) {
			transaction.pay(paymentMethod);
			try {
				transaction.sellProductsInTheCart();
				LOGGER.info("The purchase has been made successfully");
			} catch (NoProductsInTheCartException e) {
				LOGGER.error("The cart is empty, please add products to continue with the purchase", e);
			}
		}
	};

	public static final Logger LOGGER = LogManager.getLogger(Transaction.class);
}
