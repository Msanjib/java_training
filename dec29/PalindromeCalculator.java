package dec29;

import java.util.Scanner;

/**
 * Q.3. A palindrome is a sequence of characters that reads the same backward as
 * forward. For example, each of the following five-digit integers is a
 * palindrome: 12321, 55555, 45554 and 11611. Write an application that reads in
 * a five-digit integer and determines whether it is a palindrome. If the number
 * is not five digits long, display an error message and allow the user to enter
 * a new value.
 * 
 * @author Sanjib Maharjan
 * 
 */
public class PalindromeCalculator {

	public static void main(String[] args) {
		System.out.println("Palindrome Calculator:");
		Scanner input = new Scanner(System.in);
		int number = 0;
		while ((number + "").length() != 5) {
			System.out.print("Enter a five digit positive number:");
			try {
				number = input.nextInt();
			} catch (Exception e) {
				number = 0;
				System.out.println("Not a number.Try Again!");
				input.next();
			}
		}
		System.out.println(isPalindromeNumber(number));
		input.close();
	}

	public static String isPalindromeNumber(int num) {
		int size = (num + "").length();
		int i = 0;
		int resultedNumber = 0;
		int temp_num = num;

		for (i = 0; i < size; i++) {

			resultedNumber = resultedNumber * 10 + temp_num % 10;
			temp_num = temp_num / 10;
		}

		if (resultedNumber == num) {
			return num + " is a Palindrome Number";
		} else {
			return num + " is not a Palindrome Number";
		}

	}
}
