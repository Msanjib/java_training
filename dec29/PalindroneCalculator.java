package dec29;

import java.util.Scanner;

/*
 *  
 *  Q.3. A palindrome is a sequence of characters that reads the same backward 
 *  as forward. For example, each of the following five-digit integers is a 
 *  palindrome: 12321, 55555, 45554 and 11611. Write an application that reads 
 *  in a five-digit integer and determines whether it is a palindrome. If the 
 *  number is not five digits long, display an error message and allow the user 
 *  to enter a new value.
 *  
 */
public class PalindroneCalculator {

	public static void main(String[] args) {
		System.out.println("Palindrone Calculator:");

		Scanner input = new Scanner(System.in);
		Integer number = 0;
		while (number.toString().length() != 5) {
			System.out.print("Enter a five digit positive number:");
			try {
				number = input.nextInt();
			} catch (Exception e) {
				number = 0;
				System.out.println("Not a number.Try Again!");
				input.next();
			}
			/*finally{
				input.close();
			}*/
		}

		System.out.println(isPalindroneNumber(number));

		input.close();

	}

	public static String isPalindroneNumber(int num) {
		int size = (num + "").length();
		int i = 0;
		int resultedNumber = 0;
		int temp_num = num;

		for (i = 0; i < size; i++) {

			resultedNumber = resultedNumber * 10 + temp_num % 10;
			temp_num = temp_num / 10;
		}

		if (resultedNumber == num) {
			return num + " is a Palindrone Number";
		} else {
			return num + " is not a Palindrone Number";
		}

	}
}
