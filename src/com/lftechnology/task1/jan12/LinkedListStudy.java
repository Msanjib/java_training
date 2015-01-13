package com.lftechnology.task1.jan12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h1>Q3.</h1>
 * <ul>
 * <li>Create a linked list named one and two.</li>
 * <li>Add some elements to both one (one, two, three, four, five) and two (six, seven, eight, nine, and ten).</li>
 * <li>Merge the words from two into one.</li>
 * <li>Remove every second word from two.</li>
 * <li>Remove all words in two from one.</li>
 * <li>Print the value after each operation.</li>
 * </ul>
 * 
 * @author Sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class LinkedListStudy {
	public static final Logger LOGGER = Logger.getLogger(LinkedListStudy.class.getName());

	public static void main(String[] args) {
		List<String> linkedListOne = new LinkedList<String>(Arrays.asList(new String[] { "one", "two", "three", "four", "five" }));
		List<String> linkedListTwo = new LinkedList<String>(Arrays.asList(new String[] { "six", "seven", "eight", "nine", "ten" }));
		LOGGER.log(Level.INFO, "Original values in the lists\nLinked list1:{0}\nLinked list2:{1} ",
				new Object[] { Utils.listToString(linkedListOne), Utils.listToString(linkedListTwo) });
		linkedListOne.addAll(linkedListTwo);
		LOGGER.log(Level.INFO, "Operation{0}:Add secondlist to firstlist\nLinked list1:{1}\nLinked list2:{2} ",
				new Object[] { 1, Utils.listToString(linkedListOne), Utils.listToString(linkedListTwo) });
		Utils.removeEvenEntry(linkedListTwo);
		LOGGER.log(Level.INFO, "Operation{0}:Remove even entry in secondlist\nLinked list1:{1}\nLinked list2:{2} ",
				new Object[] { 2, Utils.listToString(linkedListOne), Utils.listToString(linkedListTwo) });
		linkedListOne.removeAll(linkedListTwo);
		LOGGER.log(Level.INFO, "Operation{0}:Remove secondlist from firstlist\nLinked list1:{1}\nLinked list2:{2} ", new Object[] { 3,
				Utils.listToString(linkedListOne), Utils.listToString(linkedListTwo) });
	}
}
