package day1;
/**
*  Demonstration of Searching a string in an another string
*/
import java.util.Scanner;

class SearchCity {
	
	public static void main(String[] args){
		String cities = new String("Kathmandu Japan Patan");
		String city_list[] = cities.split(" "); 
		Scanner in = new Scanner(System.in);
		
		System.out.println("Cities:"+cities);
 		
      		System.out.print("Enter city to search:");
     		String search_city = in.nextLine();

		for(int i=0;i<city_list.length;i++){
			if(city_list[i].equals(search_city)) {
				System.out.println(search_city+" Found!");
				break;
			}

			if(i == city_list.length-1) {
				System.out.println(search_city+" Not Found!");
			}

		}

		
	}

}