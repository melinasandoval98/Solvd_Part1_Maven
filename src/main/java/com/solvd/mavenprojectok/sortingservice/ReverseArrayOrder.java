package com.solvd.mavenprojectok.sortingservice;

public class ReverseArrayOrder {
	Swap swp = new Swap();

	void reverseArrayOrder(int[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			swp.swap(array, i, array.length - 1 - i);
		}
	}

	void reverseArrayOrder(String[] array1) {
		for (int j = 0; j < array1.length / 2; j++) {
			swp.swap(array1, j, array1.length - 1 - j);
		}
	}
}
