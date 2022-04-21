package com.solvd.mavenprojectok.arraysort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//This class can sort an array of INTEGERS
public class QuickSort {
	public static void main(String[] args) {
		System.out.println(
				"Please, enter the number of elements of the array you want to sort through the Quick Sort method:");
		Scanner sn = new Scanner(System.in);
		try {
			int dim = sn.nextInt();
			System.out.println("Please, enter the elements of the array:");
			int[] array = new int[dim];
			for (int k = 0; k < dim; k++) {
				int element = sn.nextInt();
				array[k] = element;
			}
			QuickSort qs = new QuickSort();
			qs.quickSort(array);
			System.out.println("The ordered arrangement is:");
			System.out.println(Arrays.toString(array));
		} finally {
			sn.close();
		}
	}

	public void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private void quickSort(int[] array, int lower_ind, int higher_ind) {
		if (lower_ind < higher_ind + 1) {
			int partition = createPartition(array, lower_ind, higher_ind);
			quickSort(array, lower_ind, partition - 1);
			quickSort(array, partition + 1, higher_ind);
		}
	}

	// This method finds a pivot randomly between the lower and the higher index
	// of the partition, in order to ensure good performance of the method.
	private int getPivot(int lower_ind, int higher_ind) {
		Random rand = new Random();
		return rand.nextInt((higher_ind - lower_ind) + 1) + lower_ind;
	}

	// This method creates the partitions around the pivot. One of the partitions
	// may contain the minor values and the other partition may contain higher
	// values
	private int createPartition(int[] array, int lower_ind, int higher_ind) {
		swap(array, lower_ind, getPivot(lower_ind, higher_ind));
		int next_lower = lower_ind + 1;
		for (int i = next_lower; i <= higher_ind; i++) {
			if (array[i] < array[lower_ind]) {
				swap(array, i, next_lower++);
			}
		}
		swap(array, lower_ind, next_lower - 1);
		return next_lower - 1;
	}

	private void swap(int[] array, int index1, int index2) {
		int buffer = array[index1];
		array[index1] = array[index2];
		array[index2] = buffer;
	}
}