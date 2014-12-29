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
		StringBuilder name = new StringBuilder();
		
		Scanner in = new Scanner(System.in);
		// To make sure initials is not empty
		while (name.toString().trim().equals("")) {
			System.out.print("Enter your Initials(Mr/Mrs):");
			name.append(in.nextLine());
		}
		
		String temp = "";
		// To make sure first name is not empty
		while (temp.trim().equals("")) {
			System.out.print("Enter your First name:");
			temp=in.nextLine();
		}
		name.append(" ");
		name.append(temp);
		
		//Middle name may be empty
		System.out.print("Enter your Middle name:");
		String m = in.nextLine().trim();
		if (!m.equals("")) {
			// name.append(" "+m);
			name.append(" ");
			name.append(m);
		}
		
		temp = "";
		// To make sure last name is not empty
		while (temp.trim().equals("")) {
			System.out.print("Enter your Last name:");
			temp=in.nextLine();
		}
		name.append(" ");
		name.append(temp);

		System.out.print("Hi, " + name);
		in.close();

	}

}