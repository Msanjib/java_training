package dec26;

/*
 * 
 *  Q.WAP which accepts name of cities.Ask the user to enter the character 
 *  sequence to search the city and display the searched city
 *  
 */
import java.util.Scanner;

/**
 * 
 * Demonstration of Searching a string in an another string
 * 
 * @author Sanjib Maharjan
 */
class SearchCity {

	public static void main(String[] args) {
		String cities = new String("Kathmandu Japan Patan Lalitpur Bhaktapur");
		String cityList[] = cities.split(" ");
		Scanner in = new Scanner(System.in);

		System.out.println("Cities:" + cities);

		System.out.print("Enter city to search:");
		String search_city = in.nextLine();

		for (String city : cityList) {
			if (city.contains(search_city)) {
				System.out.println(city);

			}

		}

		in.close();

	}

}