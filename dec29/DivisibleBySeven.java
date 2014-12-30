package dec29;

/**
 * Q.4. Write a program to find the number of and sum of all integers greater
 * than 100 and less than 200 that are divisible by 7.
 * 
 * This class displays all the numbers between 100 and 200 that is divisible by
 * 7 and also displays the sum of those numbers
 * 
 * 
 * @author Sanjib Maharjan
 * 
 */
public class DivisibleBySeven {

	public static void main(String[] args) {
		System.out.println("Number divisible by 7");
		int sum = getSumDivisibleByNumber(101, 199, 7);
		System.out.println("Sum of Number divisible by 7:" + sum);
	}

	/**
	 * This method prints the numbers divisible by the divisor between the
	 * number fromNumber and toNumber and prints the sum
	 */
	public static int getSumDivisibleByNumber(int fromNumber, int toNumber,
			int divisor) {
		int sum = 0;
		int i = 0;
		for (i = fromNumber; i <= toNumber; i++) {
			if (i % divisor == 0) {
				System.out.println(i);
				sum = sum + i;
			}
		}
		return sum;
	}
}
