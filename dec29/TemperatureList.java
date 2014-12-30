package dec29;

/**
 * 
 * Q.2. Write a program that displays the temperatures from 0 degrees Celsius to
 * 100 degrees Celsius and its Fahrenheit equivalent. Note that the conversion
 * from Celsius to Fahrenheit uses the following formula: F = C * 9/5 + 32;
 * 
 * @author Sanjib Maharjan
 * 
 */
public class TemperatureList {

	public static void main(String[] args) {
		System.out.println("Sn.   Celcius   Fahrenheit");
		String space = "";
		float fah_scale = 0;
		int i = 0;
		for (i = 0; i <= 100; i++) {
			// to generate equal spaces
			space = generateSpace(i);
			fah_scale = (float) (i * 9.0 / 5 + 32);

			System.out.println((i + 1) + space + i + "°C" + "       "
					+ fah_scale + "°F");
		}

	}

	public static String generateSpace(int i) {
		String space = "";
		if (i + 1 <= 9) {
			space = "      ";
		} else if (i + 1 == 10) {
			space = "     ";
		} else if (i + 1 > 10 && i + 1 < 100) {
			space = "    ";
		} else if (i + 1 == 100) {
			space = "   ";
		} else {
			space = "  ";
		}

		return space;
	}
}
