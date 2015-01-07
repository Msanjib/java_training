package com.lftechnology.task.jan05;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Q.3 Compare if two arrays have the same content (doesn't matter if they aren't in order)
 * 
 * @author Sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class ArrayCompareContentAnyOrder {
	private static final Logger LOGGER = Logger.getLogger(ArrayCompareContentAnyOrder.class.getName());

	public static void main(String[] args) {
		String array1[] = { "abc1", "abc", "abc" };
		String array2[] = { "abc", "abc1", "abc1" };
		if (isArrarsEqualAnyOrder(array1, array2)) {
			LOGGER.info("The arrays are identical");
		} else {
			LOGGER.info("The arrays are not identical");
		}
	}

	/**
	 * checks if the size of arrays are equal.
	 * <p>
	 * Next checks the content of array equals to the content of another. If at instant any element of one array is not found in the
	 * contents of another array returns <code>false</code> immediately.
	 * 
	 * @param array1
	 *            the 1st array of strings to compare
	 * @param array2
	 *            the 2nd array of strings to compare
	 * @return <code>true</code> if the arrays are identical or <code>false</code> if the arrays are not identical
	 */
	public static boolean isArrarsEqualAnyOrder(String[] array1, String[] array2) {
		int lengthArray1 = array1.length;
		int lengthArray2 = array2.length;
		if (lengthArray1 != lengthArray2) {
			return false;
		}
		Arrays.sort(array1);
		Arrays.sort(array2);
		for (int i = 0; i < lengthArray1; i++) {
			if (!array1[i].equals(array2[i])) {
				return false;
			}

		}
		return true;
	}

}
