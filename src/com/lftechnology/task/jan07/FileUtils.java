package com.lftechnology.task.jan07;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This is a simple utility class file for handling io operations for the files.
 * 
 * @author Sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class FileUtils {

	public static final String PATH_SEPERATOR = "/";
	public static final String DOUBLE_QUOTE = "\"";

	/**
	 * This method reads the file in the given file path and returns each of the words separated by the space as tle list of string arrays.
	 * 
	 * @param filePath
	 *            complete path to the file with its filename
	 * @return lists of words obtained by delimiting the contents of file by 'space' character.
	 * @throws IOException
	 */
	public static List<String> readFile(String filePath) throws IOException {
		File file = new File(filePath);
		file.createNewFile();
		// Get data from this file using a file reader.
		FileReader fileReader = new FileReader(file);
		// To store the contents read via File Reader
		Scanner readFile = new Scanner(fileReader);
		List<String> fileChunks = new ArrayList<String>();
		try {
			while (readFile.hasNext()) {
				fileChunks.add(readFile.next());
			}
		} finally {
			readFile.close();
		}
		return fileChunks;
	}

	/**
	 * This method creates a new file with the given file path.If no file exists in the location it create a new file with the directory.
	 * <p>
	 * Assumes the path ending with "/" as directory and rest as the files. Assumes the path starting with "/" as the absolute path and
	 * without it as the relative path with respect to the project root directory.
	 * 
	 * @param filePath
	 *            complete path to the file with the file name
	 * @return the {@link File} instance of the created file
	 * @throws IOException
	 */
	public static File createNewFile(String filePath) throws IOException {
		File fileDirectory = new File("");
		if (filePath.endsWith("/")) {
			fileDirectory = new File(filePath);
			if (!fileDirectory.exists()) {
				fileDirectory.mkdirs();
			}
			return fileDirectory;
		} else {
			String[] path = filePath.split("/");
			String dirPath = joinWithDelimiter("/", Arrays.copyOf(path, path.length - 1));
			fileDirectory = new File(dirPath);
			if (!fileDirectory.exists()) {
				fileDirectory.mkdirs();
			}
			File file = new File(filePath);
			file.createNewFile();
			return file;
		}
	}

	/**
	 * This method create a newfile in the given directory with the file name
	 * 
	 * @param dirPath
	 *            directory path to the file
	 * @param fileName
	 *            name of the file to be created
	 * @throws IOException
	 */
	public static void createNewFile(String dirPath, String fileName) throws IOException {
		File file = new File(dirPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		File files = new File(dirPath + PATH_SEPERATOR + fileName);
		files.createNewFile();
	}

	/**
	 * This method joins the list of string with given delimiter and returns all of them as a single string object
	 * 
	 * @param delim
	 *            a delimiter to join the given string
	 * @param list
	 *            a list of string to be joined by the delimiter
	 * @return {@link String} concatenated with the elements in list delimited by delim
	 */
	public static String joinWithDelimiter(String delim, String... list) {
		StringBuilder stringBUilder = new StringBuilder();
		for (String string : list) {
			stringBUilder.append(string);
			stringBUilder.append(delim);
		}
		return stringBUilder.toString();
	}

	/**
	 * Create a directories with the given path parameter
	 * 
	 * @param pathDir
	 *            a name of directory or the sequence of directory inside each directory
	 * @return message for the result while creating the directory
	 */
	public static String createDirectory(String pathDir) {
		File file = new File(pathDir);
		if (!file.exists()) {
			if (file.mkdirs()) {
				return "Directory created successfully";
			} else {
				return "Error creating directory";
			}
		} else {
			return "directory already exists";
		}
	}

	/**
	 * Renames or moves the file from oldName to the newName
	 * 
	 * @param oldName
	 *            the path of the old file name
	 * @param newName
	 *            the new path to the file
	 * @return <code>true</code> if the file is successfully renamed <code>false</code> if the file renaming is unsuccessful
	 */
	public static boolean renameFile(File oldFile, File newFile) {
		return oldFile.renameTo(newFile);
	}

}
