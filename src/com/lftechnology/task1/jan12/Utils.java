package com.lftechnology.task1.jan12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Utils {

	/**
	 * This method shuffles the position of the words in the given sentence.
	 * 
	 * @param sentence
	 *            the {@link String} instance to be shuffled
	 * @return the shuffled sentence
	 */
	public static String shuffleSentence(String sentence) {
		List<String> wordsInSentence = new ArrayList<String>(Arrays.asList(sentence.split(" ")));
		Collections.shuffle(wordsInSentence);
		return listToString(wordsInSentence);
	}

	/**
	 * this method combines the elements of the list joined by(delimated) the space character
	 * 
	 * @param list
	 *            list of string array to be combined
	 * @return {@link String} which is obtained by combining list element by space character
	 */
	public static String listToString(Collection<String> list) {
		StringBuilder resultString = new StringBuilder();
		for (String value : list) {
			resultString.append(value);
			resultString.append(" ");
		}
		return resultString.toString().trim();
	}

	/**
	 * This methods removes the even positioned entry from given list of string arrays
	 * <p>
	 * For eg. if the list has{"1","2","3","4"} then the result will be {"1","3"}
	 * 
	 * @param list
	 *            the lists of string arrays of words
	 */
	public static void removeEvenEntry(List<String> list) {
		int loopTimes = list.size() / 2;
		for (int i = 0; i < loopTimes; i++) {
			list.remove(i + 1);
		}
	}
}
