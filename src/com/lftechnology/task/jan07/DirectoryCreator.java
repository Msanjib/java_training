package com.lftechnology.task.jan07;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Q3.Write a program to create a directory and check whether the directory is created.
 * 
 * @author Sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class DirectoryCreator {
	public static final Logger LOGGER = Logger.getLogger(CreateFile.class.getName());

	public static void main(String[] args) throws IOException {
		LOGGER.info(FileUtils.createDirectory("/kl/kl/kl"));
	}
}
