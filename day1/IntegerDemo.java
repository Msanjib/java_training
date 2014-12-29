package day1;
/**
*  Demonstration to show what error is thrown when the range of integer
*  primitive type goes out of range -2^31 <= int <= (2^31)-1
*
*/
import java.util.Scanner;

class IntegerDemo {
	
	public static void main(String[] args){
		int num;
		Scanner in = new Scanner(System.in);
 
      		System.out.print("Enter any number:");
		try{
     			num = in.nextInt();
			System.out.println("You entered number "+num);
		}catch(Exception e){
			System.out.println("Error : "+e);
		}
      		
	}

}