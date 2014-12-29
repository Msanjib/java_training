package dec29;

/*
 *  
 *  Q.4. Write a program to find the number of and sum of all integers 
 *  greater than 100 and less than 200 that are divisible by 7.
 *  
 */
public class DivisibleBySeven {

	public static void main(String[] args) {
		System.out.println("Number divisible by 7");
		int sum = displayDivisibleRange(101,200,7);
		System.out.println("Sum of Number divisible by 7:"+ sum);

	}

	public static int displayDivisibleRange(int min, int max, int num) {
		int sum = 0;
		int i;
		for (i = min; i <= max; i++) {
			if(i%num == 0){
				System.out.println(i);
				sum = sum + i;
			}
		}

		return sum;
	}
}
