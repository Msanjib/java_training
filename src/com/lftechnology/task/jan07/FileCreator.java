package com.lftechnology.task.jan07;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Q1.Write a program to create a text file in the path java\abc.txt and check whether that file is exists. Using the command exists(),
 * isDirectory(), isFile(), getName() and getAbsolutePath().
 * 
 * @author Sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class FileCreator {
	public static final Logger LOGGER = Logger.getLogger(FileCreator.class.getName());

	public static void main(String[] args) {
		try {
			File file = FileUtils.createNewFile("kk/ll/");
			if (file.isFile()) {
				LOGGER.info("file \"" + file.getName() + "\" created at \"" + file.getAbsolutePath() + "\"");
			} else if (file.isDirectory()) {
				LOGGER.info("Directory created at \"" + file.getAbsolutePath() + "\"");
			}
		} catch (IOException e) {
			LOGGER.warning("Cannot create the file");
		}

	}
}
