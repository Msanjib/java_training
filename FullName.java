/**
*  Demonstration of Immutable String Class and Mutable StringBuilder
*  Class using concatenation.
*
*/
import java.util.Scanner;

class FullName{
	
	public static void main(String[] args){
		StringBuilder name = new StringBuilder();           //Use StringBuilder because it concatenates names
		Scanner in = new Scanner(System.in);
 		
		while(name.toString().trim().equals("")) {          //To make sure first name is not empty
      			System.out.print("Enter your First name:");
     			name.append(in.nextLine());
		}
		
		System.out.print("Enter your Middle name:");
		String m = in.nextLine().trim();
		if(!m.equals("")) {
			//name.append(" "+m);
			name.append(" ");
			name.append(m);
		}

		System.out.print("Enter your Last name:");
		name.append(" ");
		name.append(in.nextLine());
		
		System.out.print("Hi, "+name);
		
      		
	}

}