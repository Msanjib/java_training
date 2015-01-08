package com.lftechnology.task.jan07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Q4. Write a program called FileInput to read an int, a double, and a String form a text file called "in.txt", and produce the following
 * output: (Hint use Scanner to read from file) a. The integer read is 12 b. The floating point number read is 33.44 c. The String read is
 * "Peter" d. Hi! Peter, the sum of 12 and 33.44 is 45.44
 * 
 * This class reads the files and then lists out all its words with numbers and strings. Then it adds up all the numbers and finally
 * displays in the given format.
 * <p>
 * However if there is no file location in the path, then a empty file is created.
 * 
 * Eg.the file have contents "ram shyam 10 10 10 34.5"
 * 
 * then the result will be Hi!ram, shyam the sum of 10.0, 10.0, 10.0 and 34.5 is 64.5.
 * 
 * @author Sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class FileInput {
	public static final Logger LOGGER = Logger.getLogger(FileInput.class.getName());

	public static void main(String[] args) {
		ArrayList<String> fileWordLists = new ArrayList<String>();
		ArrayList<Float> numLists = new ArrayList<Float>();
		ArrayList<String> stringLists = new ArrayList<String>();
		try {
			fileWordLists = FileUtils.readFile("files/bib.txt");
		} catch (IOException e) {
			LOGGER.warning("Problem reading the file.");
		}
		for (String word : fileWordLists) {
			if (isFloat(word)) {
				numLists.add(Float.parseFloat(word));
			} else {
				stringLists.add(word);
			}
		}
		// Displaying in the given format
		StringBuilder stringBuilder = new StringBuilder("Hi!");
		for (String string : stringLists) {
			stringBuilder.append(string);
			stringBuilder.append(", ");
		}
		stringBuilder.append("the sum of ");
		int numNumbers = numLists.size();
		for (int i = 0; i < numNumbers; i++) {

			stringBuilder.append(numLists.get(i));
			if (i == (numNumbers - 2)) {
				stringBuilder.append(" and ");
			}
			// to not include comma at the last
			if (i < (numNumbers - 2)) {
				stringBuilder.append(", ");
			}
		}
		stringBuilder.append(" is ");
		stringBuilder.append(addNums(numLists));
		stringBuilder.append(".");
		LOGGER.info(stringBuilder.toString());
	}

	private static float addNums(ArrayList<Float> numbers) {
		float sum = 0;
		for (float floats : numbers) {
			sum += floats;
		}
		return sum;
	}

	/**
	 * This method checks if the given parameter is a {@link Long} value by trying to parsing the given string parameter to the {@link Long}
	 * 
	 * @param longs
	 *            a string value
	 * @return <code>true</code> if the given parameter is {@link Long} <code>false</code> if the given parameter is no {@link Long}
	 */
	private static boolean isLong(String longs) {
		try {
			Long.parseLong(longs);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * This method checks if the given parameter is a {@link Float} value by trying to parsing the given string parameter to the
	 * {@link Float}
	 * 
	 * @param integer
	 *            a string value
	 * @return <code>true</code> if the given parameter is {@link Float} <code>false</code> if the given parameter is no {@link Float}
	 */
	private static boolean isFloat(String floatValue) {
		try {
			Float.parseFloat(floatValue);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
