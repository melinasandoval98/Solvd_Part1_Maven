package com.solvd.mavenprojectok.sortingservice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OptionMenu {
	public static final Logger LOGGER = LogManager.getLogger(BubbleSort.class);
	BubbleSort bbsrt = new BubbleSort();
	QuickSort qs = new QuickSort();
	Swap swp = new Swap();
	ReverseArrayOrder reverse = new ReverseArrayOrder();

	public void menu() {
		LOGGER.info("Hello! please select the type, the method and the and the order you want to sort your array:"
				+ "\n" + "1. Integer Array - BubbleSort - Ascending Order" + "\n"
				+ "2. Integer Array - BubbleSort - Descending Order" + "\n"
				+ "3. String Array - BubbleSort - Ascending Order" + "\n"
				+ "4. String Array - BubbleSort - Descending Order" + "\n"
				+ "5. Integer Array - QuickSort - Ascending Order" + "\n"
				+ "6. Integer Array - QuickSort - Descending Order" + "\n"
				+ "7. String Array - QuickSort - Ascending Order" + "\n"
				+ "8. String Array - QuickSort - Descending Order");
		try (Scanner sn = new Scanner(System.in)) {
			int option = sn.nextInt();
			LOGGER.info("How many elements has the array you want to sort?:");
			int dim = sn.nextInt();
			LOGGER.info("Please, enter the elements of te array:");
			switch (option) {
			case 1:
				int[] array = new int[dim];
				for (int k = 0; k < dim; k++) {
					int element = sn.nextInt();
					array[k] = element;
				}
				bbsrt.bubbleSort(swp, array);
				LOGGER.info("The ordered array is");
				LOGGER.info(Arrays.toString(array));
				break;
			case 2:
				int[] array1 = new int[dim];
				for (int k = 0; k < dim; k++) {
					int element = sn.nextInt();
					array1[k] = element;
				}
				Collections.reverse(Arrays.asList(bbsrt.bubbleSort(swp, array1)));
				LOGGER.info("The ordered array is");
				LOGGER.info(Arrays.toString(array1));
				break;
			case 3:
				String[] array2 = new String[dim];
				for (int k = 0; k < dim; k++) {
					String element = sn.next();
					array2[k] = element;
				}
				bbsrt.bubbleSort(swp, array2);
				LOGGER.info("The ordered array is");
				LOGGER.info(Arrays.toString(array2));
				break;
			case 4:
				String[] array3 = new String[dim];
				for (int k = 0; k < dim; k++) {
					String element = sn.next();
					array3[k] = element;
				}
				Collections.reverse(Arrays.asList(bbsrt.bubbleSort(swp, array3)));
				LOGGER.info("The ordered array is");
				LOGGER.info(Arrays.toString(array3));
				break;
			case 5:
				int[] array4 = new int[dim];
				for (int k = 0; k < dim; k++) {
					int element = sn.nextInt();
					array4[k] = element;
				}
				qs.quickSort(swp, array4);
				LOGGER.info("The ordered array is");
				LOGGER.info(Arrays.toString(array4));
				break;
			case 6:
				int[] array5 = new int[dim];
				for (int k = 0; k < dim; k++) {
					int element = sn.nextInt();
					array5[k] = element;
				}
				Collections.reverse(Arrays.asList(qs.quickSort(swp, array5)));
				LOGGER.info("The ordered array is");
				LOGGER.info(Arrays.toString(array5));
				break;
			case 7:
				String[] array6 = new String[dim];
				for (int k = 0; k < dim; k++) {
					String element = sn.next();
					array6[k] = element;
				}
				qs.quickSort(swp, array6);
				LOGGER.info("The ordered array is");
				LOGGER.info(Arrays.toString(array6));
				break;
			case 8:
				String[] array7 = new String[dim];
				for (int k = 0; k < dim; k++) {
					String element = sn.next();
					array7[k] = element;
				}
				Collections.reverse(Arrays.asList(qs.quickSort(swp, array7)));
				LOGGER.info("The ordered array is");
				LOGGER.info(Arrays.toString(array7));
				break;
			}
		}
	}
}
