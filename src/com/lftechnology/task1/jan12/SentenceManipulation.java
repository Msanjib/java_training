package com.lftechnology.task1.jan12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Q1.Takes the words in its argument list and prints out any duplicate words, the number of distinct words, and a list of the words with
 * duplicates eliminated. Hint: Try with HashSet and List implementation.
 * 
 * @author Sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class SentenceManipulation {

	public static void main(String[] args) {
		String word = "hello this is testing testing hello";
		Map<String, Set<String>> result = distinguishDuplicates(word);

		for (Entry<String, Set<String>> entry : result.entrySet()) {
			// String key = entry.getKey();
			// String value = entry.getValue();
			System.out.println(entry.getKey() + " : " + Utils.listToString(entry.getValue()));
		}

	}

	/**
	 * This method analyzes the given sentences and find out the number of duplicate words and distinct words.
	 * <p>
	 * Then maps the distinct words, duplicates words and duplicate word eliminated to some specific keys.
	 * 
	 * @param sentence
	 *            the {@link String} instance to be inspected
	 * 
	 * @return The {@link Map} instance with the mappings of duplicate word removed,distinct words and duplicate words
	 */
	public static Map<String, Set<String>> distinguishDuplicates(String sentence) {
		Map<String, Set<String>> map = new HashMap<>();
		List<String> words = new ArrayList<String>(Arrays.asList(sentence.split(" ")));
		Set<String> wordsDuplicateRemoved = new LinkedHashSet<String>(words);
		Set<String> wordsDuplicate = new LinkedHashSet<String>();
		Set<String> wordsDistinct = new LinkedHashSet<String>();
		for (String wor : wordsDuplicateRemoved) {
			if (Collections.frequency(words, wor) > 1) {
				wordsDuplicate.add(wor);

			} else {
				wordsDistinct.add(wor);
			}
		}
		map.put("duplicatesRemoved", wordsDuplicateRemoved);
		map.put("duplicates", wordsDuplicate);

		map.put("distinct", wordsDistinct);
		return map;
	}
}
