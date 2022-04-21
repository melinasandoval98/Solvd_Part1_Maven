package com.solvd.mavenprojectok.sortingservice;

public class Swap {
	void swap(int[] array, int index1, int index2) {
		int buffer = array[index1];
		array[index1] = array[index2];
		array[index2] = buffer;
	}

	void swap(String[] array, int index1, int index2) {
		String buffer = array[index1];
		array[index1] = array[index2];
		array[index2] = buffer;
	}
}
