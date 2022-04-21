package com.solvd.mavenprojectok.arraysort;

import java.util.Arrays;
import java.util.Scanner;

//This class can sort an array of INTEGERS
public class BubbleSort {
	public static void main(String[] args) {
		System.out.println(
				"Please, enter the number of elements of the array you want to sort through the bubble sorting method:");
		Scanner sn = new Scanner(System.in);
		try {
			int m = sn.nextInt();
			System.out.println("Please, enter the elements of the array:");
			int[] array = new int[m];
			for (int k = 0; k < m; k++) {
				int t = sn.nextInt();
				array[k] = t;
			}
			BubbleSort bsrt = new BubbleSort();
			bsrt.bubbleSort(array);
			System.out.println("The ordered arrangement is:");
			System.out.println(Arrays.toString(array));
		} finally {
			sn.close();
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