package com.lftechnology.task.jan05;

import java.util.logging.Logger;

/**
 * Q.2 Compare if two arrays have the same content (in the same order)
 * 
 * @author Sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class ArrayCompareContentOrder {
	private static final Logger LOGGER = Logger.getLogger(ArrayCompareContentOrder.class.getName());

	public static void main(String[] args) {
		String array1[] = { "abc", "bbc", "amc", "apple", "tango" };
		String array2[] = { "abc", "bbc", "amc", "apple", "tango" };
		if (isArrarsEqualInOrder(array1, array2)) {
			LOGGER.info("The arrays are identical");
		} else {
			LOGGER.info("The arrays are not identical");
		}
	}

	/**
	 * <p>
	 * checks the content element of array equals to the content of another maintaining the same order of the arrays.
	 * 
	 * @param array1
	 *            the 1st array of strings to compare
	 * @param array2
	 *            the 2nd array of strings to compare
	 * @return <code>true</code> if the arrays are identical in order; <code>false</code> if the arrays are not identical in order
	 */
	public static boolean isArrarsEqualInOrder(String[] array1, String[] array2) {
		int sizeArray1 = array1.length;
		int sizeArray2 = array2.length;
		if (sizeArray1 != sizeArray2) {
			return false;
		}
		for (int i = 0; i < sizeArray1; i++) {
			if (!array1[i].equals(array2[i])) {
				return false;
			}

		}
		return true;
	}
}
