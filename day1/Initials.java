package day1;
/**
*  Displaying initials of a name
*/
import java.util.Scanner;

class Initials {
	
	public static void main(String[] args){
		String name;
		Scanner in = new Scanner(System.in);
 
      		System.out.print("Enter your Full name with initials:");
     		name = in.nextLine();
		System.out.print("Your initials:"+name.split(" ")[0]);
      		
	}

}