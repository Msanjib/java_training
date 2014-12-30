package dec29;

import java.util.Scanner;

/**
 * Q.1. Write a program using switch statement to develop a simple calculator
 * for +, -, *, /, and % operators.
 * 
 * This is a simple calculator for the operations between two numbers The error
 * handling for the case when empty number or string is passed instead of
 * numbers is not done
 * 
 * @author Sanjib Maharjan
 * 
 */
public class SimpleCalculator {

	public static void main(String[] args) {
		System.out.println("Simple Calculator");
		System.out.println("Enter 1 for simple Addition");
		System.out.println("Enter 2 for simple Substraction");
		System.out.println("Enter 3 for simple Multiplication");
		System.out.println("Enter 4 for simple Division");
		System.out.println("Enter 5 for modulo Division");
		System.out.print("Enter your choice:");

		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();

		float num1 = 0;
		float num2 = 0;

		if (choice > 0 && choice < 6) {
			System.out.print("Enter first number:");
			num1 = input.nextFloat();

			System.out.print("Enter second number:");
			num2 = input.nextFloat();
		}

		switch (choice) {
		case 1:
			System.out.print("Addition Result:" + (num1 + num2));
			break;

		case 2:
			System.out.print("Substraction Result:" + (num1 - num2));
			break;
		case 3:
			System.out.print("Multiplication Result:" + (num1 * num2));
			break;
		case 4:
			System.out.print("Division Result:" + (num1 / num2));
			break;
		case 5:
			System.out.print("Modulo Division Result:" + (num1 % num2));
			break;

		default:
			System.out.print("Invalid Choice");
			break;
		}

		input.close();

	}
}
