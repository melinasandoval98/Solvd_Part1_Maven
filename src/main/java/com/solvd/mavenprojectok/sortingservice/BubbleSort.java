package com.solvd.mavenprojectok.sortingservice;

public class BubbleSort {

	int[] bubbleSort(Swap swp, int[] array) {
		int l = array.length;
		for (int i = 1; i < l; i++) {
			for (int j = 0; j < l - i; j++) {
				if (array[j] > array[j + 1]) {
					swp.swap(array, j, j + 1);
				}
			}
		}
		return array;
	}

	String[] bubbleSort(Swap swp, String[] array1) {
		int l = array1.length;
		for (int i = 1; i < l; i++) {
			for (int j = 0; j < l - i; j++) {
				for (int k = 0; k < Math.min(array1[j].length(), array1[j + 1].length()); k++) {
					if (array1[j].charAt(k) > array1[j + 1].charAt(k)) {
						swp.swap(array1, j, j + 1);
					}
				}
			}
		}
		return array1;
	}
}
