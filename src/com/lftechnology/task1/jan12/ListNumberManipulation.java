package com.lftechnology.task1.jan12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Q4.Create an array list with 49 Integer objects containing the numbers 1 through 49. It then randomly shuffles the list and selects the
 * first 6 values from the shuffled list. Finally, it sorts the selected values and prints them out. Hint: Use ArrayList,
 * Collections.shuffle(), ArrayList.subList(), and Collection.sort().
 * 
 * The program does the following.
 * <ul>
 * <li>A list is created and numbers are added to it from 1 to 49</li>
 * <li>Shuffle the array</li>
 * <li>Get first six element from the first array and assigns the in the second array.</li>
 * <li>Sort the second array and prints them out.</li>
 * </ul>
 * 
 * @author Sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class ListNumberManipulation {
	public static final Logger LOGGER = Logger.getLogger(ListNumberManipulation.class.getName());

	public static void main(String[] args) {
		List<Integer> numArray = new ArrayList<Integer>();
		List<Integer> selectedNum = new ArrayList<Integer>();
		// adding elements to the lists
		for (int i = 1; i < 50; i++) {
			numArray.add(i);
		}
		// shuffling the list elements
		Collections.shuffle(numArray);
		// assigning first six elements to secong list
		selectedNum = numArray.subList(0, 6);
		// sorting out the numbers
		Collections.sort(selectedNum);
		LOGGER.log(Level.INFO, "The selected numbers in sorted order are\n {0}", selectedNum);
	}
}
