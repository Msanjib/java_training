package com.lftechnology.task1.jan12;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Q2.Write a program that uses Shuffle algorithm to print the words in its argument list in random order. Hint: Use List and Collection
 * 
 * @author Sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class SentenceShuffle {
	public static final Logger LOGGER = Logger.getLogger(SentenceShuffle.class.getName());

	public static void main(String[] args) {
		String sentence = "Hello first second third fourth fifth sixth";
		LOGGER.log(Level.INFO, "\nOriginal Sentence:{0}\nShuffled Sentence:{1}", new Object[] { sentence, Utils.shuffleSentence(sentence) });

	}
}
