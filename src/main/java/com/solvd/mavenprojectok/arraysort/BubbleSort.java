package com.solvd.mavenprojectok.arraysort;

import java.util.Arrays;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//This class can sort an array of INTEGERS
public class BubbleSort {
	public static final Logger LOGGER = LogManager.getLogger(BubbleSort.class);

	public static void main(String[] args) {
		LOGGER.info(
				"Please, enter the number of elements of the array you want to sort through the bubble sorting method:");
		try (Scanner sn = new Scanner(System.in)) {
			int m = sn.nextInt();
			LOGGER.info("Please, enter the elements of the array:");
			int[] array = new int[m];
			for (int k = 0; k < m; k++) {
				int t = sn.nextInt();
				array[k] = t;
			}
			BubbleSort bsrt = new BubbleSort();
			bsrt.bubbleSort(array);
			LOGGER.info("The ordered arrangement is:");
			LOGGER.info(Arrays.toString(array));
		}
	}

	private void swap(int[] array, int index1, int index2) {
		int buffer = array[index1];
		array[index1] = array[index2];
		array[index2] = buffer;
	}

	private void bubbleSort(int[] array) {
		int l = array.length;
		for (int i = 1; i < l; i++) {
			for (int j = 0; j < l - i; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
				}
			}
		}
	}
}