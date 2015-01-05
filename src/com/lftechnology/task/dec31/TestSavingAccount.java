package com.lftechnology.task.dec31;

/**
 * Q7.Create class SavingsAccount. Use a static variable annualInterestRate to
 * store the annual interest rate for all account holders. Each object of the
 * class contains a private instance variable savingsBalance indicating the
 * amount the saver currently has on deposit. Provide method
 * calculateMonthlyInterest to calculate the monthly interest by multiplying the
 * savingsBalance by annualInterestRate divided by 12. This interest should be
 * added to savingsBalance. Provide a static method modifyInterestRate that sets
 * the annualInterestRate to a new value. Write a program to test class
 * SavingsAccount. Instantiate two savingsAccount objects, saver1 and saver2,
 * with balances of $2000.00 and $3000.00, respectively. Set annualInterestRate
 * to 4%, then calculate the monthly interest and print the new balances for
 * both savers. Then set the annualInterestRate to 5%, calculate the next
 * month's interest and print the new balances for both savers.
 * 
 * @author Sanjib Maharjan
 * 
 */
public class TestSavingAccount {
	public static void main(String[] args) {
		SavingAccount saver1 = new SavingAccount(2000);
		SavingAccount saver2 = new SavingAccount(3000);
		SavingAccount.modifyInterestRate(0.04);
		double firstMonthInterestUser1 = saver1.calculateMonthlyInterest();
		double firstMonthInterestUser2 = saver2.calculateMonthlyInterest();
		System.out.printf("User1:\nFirst month interest amount:%f\tTotal"
				+ " Savings after one month:%f\n", firstMonthInterestUser1,
				(saver1.getSavingsBalance()) + firstMonthInterestUser1);
		System.out.printf("User2:\nFirst month interest amount:%f\tTotal"
				+ " Savings after one month:%f\n\n", firstMonthInterestUser2,
				(saver2.getSavingsBalance()) + firstMonthInterestUser2);
		SavingAccount.modifyInterestRate(0.05);
		System.out.println("Interests and Saving after increase in rate");

		double secondMonthInterestUser1 = saver1.calculateMonthlyInterest();
		double secondMonthInterestUser2 = saver2.calculateMonthlyInterest();
		System.out.printf("User1:\nSecond month interest amount:%f\tTotal"
				+ " Savings after two months:%f\n", secondMonthInterestUser1,
				(saver1.getSavingsBalance()) + firstMonthInterestUser1
						+ secondMonthInterestUser1);
		System.out.printf("User2:\nSecond month interest amount:%f\tTotal"
				+ " Savings after two months:%f", secondMonthInterestUser2,
				(saver2.getSavingsBalance()) + firstMonthInterestUser2
						+ secondMonthInterestUser2);
	}
}

/**
 * This stores ths simple blueprints for saving accounts with the current saving
 * balance and annual intrest rate of the users.
 * 
 * @author Sanjib Maharjan
 */
class SavingAccount {
	private static double annualInterestRate = 0.1;
	private double savingsBalance;

	public SavingAccount(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	/**
	 * @return the monthlyInterest
	 */
	public double calculateMonthlyInterest() {
		return savingsBalance * annualInterestRate / 12;
	}

	/**
	 * @return the current saving Balance
	 */
	public double getSavingsBalance() {
		return savingsBalance;
	}

	public static void modifyInterestRate(double newInterestRate) {
		annualInterestRate = newInterestRate;

	}
}
