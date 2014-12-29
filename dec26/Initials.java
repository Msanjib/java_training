package dec26;

/*
 * Q.Wap that computes your initials from your full name and displays them
 * 
 */

import java.util.Scanner;

/**
 * 
 * Displaying initials of a name
 * 
 * @author Sanjib Maharjan
 */
class Initials {

	public static void main(String[] args) {
		String name = "";
		Scanner in = new Scanner(System.in);

		System.out.print("Enter your Full name with initials:");
		name = in.nextLine();

		int i;
		int lengthName = name.length();
		for (i = 0; i < lengthName; i++) {
			if (name.charAt(i) == '.' || name.charAt(i) == '.') {
				break;
			}
		}
		System.out.print("Your initials:" + name.substring(0, i));
		in.close();

	}
}