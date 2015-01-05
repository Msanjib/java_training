package com.lftechnology.task.dec31;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Q2. Create a class called Distance that includes two private data members
 * feet (type int) and inches (type float). Use a method setData to set values
 * to instance variables. Provide a method display that displays the feet and
 * inches, a member function addDistance for adding two distances, and a member
 * function compareDistance for comparing two distances. Implement your program
 * in Java.
 * 
 * @author Sanjib Maharjan
 * 
 */
public class DistanceManager {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		Distance distanceInput1 = new Distance();
		Distance distanceInput2 = new Distance();
		System.out.println("Input first value for distance");
		setDistanceInput(distanceInput1, userInput);
		System.out.println("Input second value for distance");
		setDistanceInput(distanceInput2, userInput);
		userInput.close();
		displayAddDistances(distanceInput1, distanceInput2);
		displayCompareDistances(distanceInput1, distanceInput2);
	}

	/**
	 * 
	 * This method adds the arrays of distance objects{@link Distance} and
	 * displays the result.
	 * 
	 * @param distances
	 *            an array of distance object{@link Distance}
	 * @see Distance
	 */
	public static void displayAddDistances(Distance... distances) {
		float tempInches = 0;
		int numDistance = distances.length;
		for (int i = 0; i < numDistance; i++) {
			tempInches = tempInches
					+ (distances[i].getFeet() * 12 + distances[i].getInches());
		}
		float result = (tempInches / 12);
		System.out.println("Addition result:" + result + "' (" + (int) result
				+ "'" + tempInches % 12 + "\")");
	}

	/**
	 * 
	 * This method compares two distance objects{@link Distance} and displays
	 * which one is greater among the two or equal if they are same.
	 * <p>
	 * Also it displays the difference between the two.
	 * 
	 * @param distanceToCompare1
	 *            a distance object{@link Distance}
	 * @param distanceToCompare2
	 *            a distance object{@link Distance}
	 * @see Distance
	 */
	public static void displayCompareDistances(Distance distanceToCompare1,
			Distance distanceToCompare2) {
		float distInInches1 = 0;
		float distInInches2 = 0;
		distInInches1 = distanceToCompare1.getFeet() * 12
				+ distanceToCompare1.getInches();
		distInInches2 = distanceToCompare2.getFeet() * 12
				+ distanceToCompare2.getInches();
		if (distInInches1 > distInInches2) {
			System.out.println(distanceToCompare1.getDistance()
					+ " is greater than " + distanceToCompare2.getDistance());
		} else if (distInInches1 < distInInches2) {
			System.out.println(distanceToCompare2.getDistance()
					+ " is greater than " + distanceToCompare1.getDistance());
		} else {
			System.out.println(distanceToCompare2.getDistance() + " equals to "
					+ distanceToCompare1.getDistance());
		}
		float result = Math.abs(distInInches1 - distInInches2);
		float resultFeet = result / 12;
		System.out.println("Difference:" + resultFeet + "' ("
				+ (int) resultFeet + "'" + result % 12 + "\")");
	}

	/**
	 * 
	 * This method sets the distance object{@link Distance} by prompting the
	 * user to input the value for feet and inches.However if the user enters
	 * negative values or other unaccepted values then the user will be prompted
	 * to input the value again for both the cases ie.for feet input and inches
	 * input.
	 * 
	 * @param distance
	 *            a distance object{@link Distance} that stores distance measure
	 *            in feet and inches
	 * @param userInput
	 *            a scanner instance to take input from the user
	 * @see Scanner
	 */
	public static void setDistanceInput(Distance distance, Scanner userInput) {
		boolean errorInput = false;
		do {
			System.out.print("Enter feet:");
			try {
				int tempFeet = userInput.nextInt();
				if (tempFeet > -1) {
					distance.setFeet(tempFeet);
					errorInput = false;
				} else {
					errorInput = true;
					System.out.println("Enter positive Value!");
				}

			} catch (InputMismatchException e) {
				System.out.println("Invalid Input!");
				userInput.next();
				errorInput = true;
			}
		} while (errorInput);

		do {
			System.out.print("Enter Inch:");
			try {
				float tempInches = userInput.nextFloat();
				if (tempInches >= 0 && tempInches < 12) {
					distance.setInches(tempInches);
					errorInput = false;
				} else {
					errorInput = true;
					System.out.println("Enter values between 0 and 11!");
				}

			} catch (InputMismatchException e) {
				System.out.println("Invalid Input!");
				userInput.next();
				errorInput = true;
			}
		} while (errorInput);
	}
}

/**
 * This stores ths simple blueprints for storing distance measure in feet and
 * inches value
 * 
 * @author Sanjib Maharjan
 */
class Distance {
	private int feet;
	private float inches;

	public void setData(int feet, float inches) {
		this.feet = feet;
		this.inches = inches;
	}

	/**
	 * Changes the feet value of the distance.
	 * 
	 * @param feet
	 *            sets the feet.
	 */
	public void setFeet(int feet) {
		this.feet = feet;
	}

	/**
	 * Changes the inches value of the distance.
	 * 
	 * @param inches
	 *            sets the inches.
	 */
	public void setInches(float inches) {
		this.inches = inches;
	}

	/**
	 * Gets the feet value of the distance.
	 * 
	 * @return this Distance's feet value.
	 */
	public int getFeet() {
		return this.feet;
	}

	/**
	 * Gets the inches value of the distance.
	 * 
	 * @return this Distance's inch value.
	 */
	public float getInches() {
		return this.inches;
	}

	/**
	 * Gets the distance by combining feet and inches
	 * 
	 * @return this Distance's value.
	 */
	public String getDistance() {
		return feet + "'" + inches + "\"";
	}
}
