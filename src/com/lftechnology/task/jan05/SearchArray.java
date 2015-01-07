package com.lftechnology.task.jan05;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Q1.Search for a specific value in an array.
 * 
 * @author Sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class SearchArray {
	private static final Logger LOGGER = Logger.getLogger(SearchArray.class.getName());
	private static final String ARRAY_WORDS[] = { "Amnesia", "Good", "Bad", "Awesome", "good", "awesome", "123Madman", "Yeah" };

	public static void main(String[] args) {
		Scanner inputuser = new Scanner(System.in);
		String searchText = "";
		ArrayList<Integer> matchedPosition = new ArrayList<Integer>();
		try {
			while (searchText.equals("")) {
				LOGGER.info("Enter any text to search:");
				searchText = inputuser.nextLine();
			}
		} finally {
			inputuser.close();
		}
		matchedPosition = getMatchedPosition(ARRAY_WORDS, searchText);
		if (matchedPosition.size() == 0) {
			LOGGER.info("No matched result in the given array");
		} else {
			int resultSize = matchedPosition.size();
			StringBuilder savePos = new StringBuilder("position");
			for (int i = 0; i < resultSize; i++) {
				savePos.append(" " + (matchedPosition.get(i) + 1) + " ");
			}
			LOGGER.info("\"" + searchText + "\"" + " found in " + savePos);
		}

	}

	/**
	 * @param arrayString
	 *            the array of strings
	 * @param searchValue
	 *            the string value to be searched in the array
	 * @return list of position of array where the search value matches the array
	 */
	public static ArrayList<Integer> getMatchedPosition(String[] arrayString, String searchValue) {
		ArrayList<Integer> searchResult = new ArrayList<Integer>();
		int arraySize = arrayString.length;
		for (int i = 0; i < arraySize; i++) {
			if (arrayString[i].equalsIgnoreCase(searchValue)) {
				searchResult.add(i);
			}
		}
		return searchResult;
	}
}
