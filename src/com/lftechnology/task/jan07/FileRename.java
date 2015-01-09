package com.lftechnology.task.jan07;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Q2.Write a program to rename the given file, after renaming the file delete the renamed file. (Accept the file name using command line
 * arguments.)
 * 
 * This files does the following operations.
 * <ul>
 * <li>Ask the user for the filepath to be renamed.</li>
 * <li>Ask the user for the name of the path to rename.This is mandatory.i.e.the user will be prompted until the user inputs the valid file
 * path.</li>
 * <li>Ask the user if he/she wants to delete the file.</li>
 * <li>Finally the file is deleted if the user decides "yes" to delete the file.</li>
 * <li>If there is problem in renaming the file then both files are deleted.</li>
 * </ul>
 * 
 * @author Sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class FileRename {
	public static final Logger LOGGER = Logger.getLogger(FileRename.class.getName());

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			// Ask the user for the path to the file to create
			String filePath = getInputFromUser(input, "Enter the filename with path to create:");
			File file = new File("");
			File fileRename = new File("");
			boolean errorRename = true;
			// Ask the name to be renamed
			try {
				file = FileUtils.createNewFile(filePath);
				String fileRenamePath = "";
				while (errorRename) {
					fileRenamePath = getInputFromUser(input, "Enter the filename with path to rename:");
					try {
						fileRename = FileUtils.createNewFile(fileRenamePath);
						errorRename = false;
					} catch (IOException e) {
						LOGGER.warning("Cannot rename the file to " + fileRenamePath);
						errorRename = true;
					}
				}
				boolean isReNamed = FileUtils.renameFile(file, fileRename);
				// Ask the user if he/she wants to delete the renamed file.
				LOGGER.info("Do you want to delete " + filePath + "?");
				String deleteDecision = getInputFromUser(input, "Do you want to delete " + fileRenamePath + "(y/n)?:", "y", "n");
				if (deleteDecision.equals("y")) {
					boolean deleteSuccess = fileRename.delete();
					// if file is not renamed delete both files
					if (!isReNamed) {
						file.delete();
					}
					if (deleteSuccess) {
						LOGGER.info("Successfully Deleted");
					}
				} else {
					LOGGER.info("File Not Deleted");
				}

			} catch (IOException e) {
				LOGGER.warning("Cannot create the file at " + filePath);
			}
		} finally {
			input.close();
		}
	}

	/**
	 * @param scanner
	 *            A {@link Scanner} instance to get user input
	 * @param message
	 *            a message to display to the users
	 * @param conditions
	 *            if conditions are set then the users will be prompted until and unless the user inputs the values in the conditions
	 * @return the input from the user as the String object
	 * @see {@link Scanner}
	 */
	public static String getInputFromUser(Scanner scanner, String message, String... conditions) {
		String inputUser = "";
		boolean loopAgain = true;
		while (loopAgain) {
			LOGGER.info(message);
			inputUser = scanner.nextLine();
			if (!inputUser.equals("") && conditions.length == 0) {
				loopAgain = false;
			} else {
				for (String cond : conditions) {
					if (inputUser.equals(cond)) {
						loopAgain = false;
						break;
					}
				}
			}
		}
		return inputUser;
	}
}
