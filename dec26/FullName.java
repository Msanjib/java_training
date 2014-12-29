package dec26;

/*
 * Q.Wap which gets arguments from console initial, FN, MN and LN then 
 * displays all as full name
 * 
 */
import java.util.Scanner;
/**
 * 
 *  Demonstration of Immutable String Class and Mutable StringBuilder
 *  Class using concatenation.
 *  
 *  @author  Sanjib Maharjan
 *
 */
class FullName {

	public static void main(String[] args) {
		// Use StringBuilder because it is mutable and this require multiple
		// concatenations
		StringBuilder nameBuilder = new StringBuilder();
		
		Scanner input = new Scanner(System.in);
		// To make sure initials is not empty
		while (nameBuilder.toString().trim().equals("")) {
			System.out.print("Enter your Initials(Mr/Mrs):");
			nameBuilder.append(input.nextLine());
		}
		
		String temp = "";
		// To make sure first name is not empty
		while (temp.trim().equals("")) {
			System.out.print("Enter your First name:");
			temp=input.nextLine();
		}
		nameBuilder.append(" ");
		nameBuilder.append(temp);
		
		//Middle name may be empty
		System.out.print("Enter your Middle name:");
		String middleName = input.nextLine().trim();
		if (!middleName.equals("")) {
			// name.append(" "+m);
			nameBuilder.append(" ");
			nameBuilder.append(middleName);
		}
		
		temp = "";
		// To make sure last name is not empty
		while (temp.trim().equals("")) {
			System.out.print("Enter your Last name:");
			temp=input.nextLine();
		}
		nameBuilder.append(" ");
		nameBuilder.append(temp);

		System.out.print("Hi, " + nameBuilder);
		input.close();

	}

}