package com.solvd.mavenprojectok.sortingservice;

import java.util.Random;

public class QuickSort {

	private int getPivot(int lower_ind, int higher_ind) {
		Random rand = new Random();
		return rand.nextInt((higher_ind - lower_ind) + 1) + lower_ind;
	}

	private int createPartition(Swap swp, int[] array, int lower_ind, int higher_ind) {
		swp.swap(array, lower_ind, getPivot(lower_ind, higher_ind));
		int next_lower = lower_ind + 1;
		for (int i = next_lower; i <= higher_ind; i++) {
			if (array[i] < array[lower_ind]) {
				swp.swap(array, i, next_lower++);
			}
		}
		swp.swap(array, lower_ind, next_lower - 1);
		return next_lower - 1;
	}

	private void quickSort(Swap swp, int[] array, int lower_ind, int higher_ind) {
		if (lower_ind < higher_ind + 1) {
			int partition = createPartition(swp, array, lower_ind, higher_ind);
			quickSort(swp, array, lower_ind, partition - 1);
			quickSort(swp, array, partition + 1, higher_ind);
		}
	}

	int[] quickSort(Swap swp, int[] array) {
		quickSort(swp, array, 0, array.length - 1);
		return array;
	}

	private int createPartition(Swap swp, String[] array1, int lower_ind, int higher_ind) {
		swp.swap(array1, lower_ind, getPivot(lower_ind, higher_ind));
		int next_lower = lower_ind + 1;
		for (int i = next_lower; i <= higher_ind; i++) {
			for (int k = 0; k < Math.min(array1[i].length(), array1[lower_ind].length()); k++) {
				if (array1[i].charAt(k) < array1[lower_ind].charAt(k)) {
					swp.swap(array1, i, next_lower++);
				}
			}
		}
		swp.swap(array1, lower_ind, next_lower - 1);
		return next_lower - 1;
	}

	void quickSort(Swap swp, String[] array, int lower_ind, int higher_ind) {
		if (lower_ind < higher_ind + 1) {
			int partition = createPartition(swp, array, lower_ind, higher_ind);
			quickSort(swp, array, lower_ind, partition - 1);
			quickSort(swp, array, partition + 1, higher_ind);
		}
	}

	String[] quickSort(Swap swp, String[] array) {
		quickSort(swp, array, 0, array.length - 1);
		return array;
	}
}
