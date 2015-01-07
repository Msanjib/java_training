package com.lftechnology.task.jan05;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Q4.Try to do a program that constantly prompts the user to enter something (using the Scanner class) until the user enters a specific
 * word (such as quit for example)
 * 
 * @author Sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class EnterValues {
	private static final Logger LOGGER = Logger.getLogger(EnterValues.class.getName());

	public static void main(String[] args) {
		Scanner inputuser = new Scanner(System.in);
		String searchText = "";
		try {
			while (!searchText.equalsIgnoreCase("quit")) {
				LOGGER.info("Enter any text(Enter \"quit\" to exit):");
				searchText = inputuser.nextLine();
			}
		} finally {
			inputuser.close();
		}
	}
}
