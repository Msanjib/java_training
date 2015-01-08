package com.lftechnology.task.jan07;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

	public static void main(String[] args) {

	}

	/**
	 * @param filePath
	 *            complete path to the file with its filename
	 * @return lists of words obtained by delimiting the contents of file by 'space' character.
	 * @throws IOException
	 */
	public static ArrayList<String> readFile(String filePath) throws IOException {
		File file = new File(filePath);
		file.createNewFile();
		// Get data from this file using a file reader.
		FileReader fileReader = new FileReader(file);
		// To store the contents read via File Reader
		Scanner readFile = new Scanner(fileReader);
		ArrayList<String> fileChunks = new ArrayList<String>();
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
	 * @return
	 * @throws IOException
	 */
	public static File createNewFile(String filePath) throws IOException {
		File directory;
		if (filePath.endsWith("/")) {
			directory = new File(filePath);
			if (!directory.exists()) {
				directory.mkdirs();
			}
			return directory;
		} else {
			String[] path = filePath.split("/");
			String dirPath = joinWithDelimiter("/", Arrays.copyOf(path, path.length - 1));
			directory = new File(dirPath);
			if (!directory.exists()) {
				directory.mkdirs();
			}
			File file = new File(filePath);
			file.createNewFile();
			return file;
		}

	}

	public static void createNewFile(String dirPath, String fileName) throws IOException {
		File file = new File(dirPath);

		if (!file.exists()) {
			file.mkdirs();
			System.out.println("what");
		} else {
			System.out.println("no");
		}

		File files = new File(dirPath + PATH_SEPERATOR + fileName);
		// System.out.println(file.getAbsolutePath());
		files.createNewFile();
	}

	/**
	 * @param delim
	 *            a delimiter
	 * @param list
	 *            a list of string to be joined by the delimiter
	 * @return {@link String} concatenated with the elements in list delimited by delim
	 */
	public static String joinWithDelimiter(String delim, String... list) {
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s);
			sb.append(delim);
		}
		return sb.toString();
	}

	/**
	 * Create a directories with the given path parameter
	 * 
	 * @param dirPath
	 * @return message for the result while creating the directory
	 */
	public static String createDirectory(String dirPath) {
		File file = new File(dirPath);
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
	 * @return
	 */
	public static boolean renameFile(String oldName, String newName) {
		File oldFile = new File(oldName);
		File newFile = new File(newName);
		return oldFile.renameTo(newFile);
	}

}
