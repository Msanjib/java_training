package dec26;

/*
 *  
 *  Q.Wap called IntegerDemo which accepts Integer value beyond its range.
 *  Try to print and see what exception the system throws
 *   
 *  
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Demonstration to show what error is thrown when the range of integer
 * primitive type goes out of range -2^31 <= int <= (2^31)-1
 * 
 * @author Sanjib Maharjan
 * 
 */
class IntegerDemo {

	public static void main(String[] args) {
		int num = 0;
		Scanner in = new Scanner(System.in);

		System.out.print("Enter any number:");
		try {
			num = in.nextInt();
			System.out.println("You entered number " + num);
		} catch (InputMismatchException e) {
			System.out.println("Error : You Entered invalid Entry.Try Again!");
		} finally {
			in.close();
		}

	}

}