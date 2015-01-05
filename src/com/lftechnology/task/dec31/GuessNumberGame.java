package com.lftechnology.task.dec31;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Q1. Write a Guessing a number game application: User will select the guessing
 * value from the keyboard and application will generate a random no between 1
 * and 100. Check if the guess value matched with random no. or not, if matched
 * show the guessing value, random value and the no. of attempts.
 * 
 * @author Sanjib Maharjan
 * 
 */
public class GuessNumberGame {
	public static void main(String[] args) {
		System.out.println("Guessing Number Game:Range 1 to 100");
		int numToGuess = randomGenerator(1, 100);
		// System.out.println(numToGuess);
		int attemptCount = 0;
		int guessedNumber = -1;
		Scanner inputNum = new Scanner(System.in);
		do {
			attemptCount++;
			System.out.printf("Attempt %d:Guess the number:", attemptCount);
			try {
				guessedNumber = inputNum.nextInt();
				System.out.println(getGameResult(numToGuess, guessedNumber));
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input:");
				inputNum.next();
			}
		} while (guessedNumber != numToGuess);

		inputNum.close();

	}

	/**
	 * @param uppNum
	 *            lower range to generate the random number
	 * @param lowNum
	 *            upper range to generate the random number
	 * @return the random number between the given range
	 */
	public static int randomGenerator(int lowNum, int uppNum) {
		return (int) ((Math.random() * (uppNum - lowNum)) + lowNum);
	}

	/**
	 * Shows the result if the number guessed by the user matches the actual
	 * number that is to be guessed to win the game.
	 * 
	 * @param numToGuess
	 *            the number to be guessed by the user to win the game
	 * @param guessedNum
	 *            the number guessed by the user
	 * @return the result of the game
	 * 
	 */
	public static String getGameResult(int numToGuess, int guessedNum) {
		String result = "";
		if (guessedNum > 100 || guessedNum < 1) {
			result = "Please, Enter Numbers between 1 and 100 only..";
		} else if (guessedNum > numToGuess) {
			result = "Hint:Number is less than " + guessedNum;
		} else if (guessedNum < numToGuess) {
			result = "Hint:Number is greater than " + guessedNum;
		} else {
			result = "Congratulation, You win!";
		}

		return result;
	}

}
