package com.lftechnology.task.dec31;

/**
 * Q6.Create a class called Date that includes three pieces of information as
 * instance variables a month (type int), a day (type int) and a year (type
 * int). Your class should have a constructor that initializes the three
 * instance variables and assumes that the values provided are correct. Provide
 * a set and a get method for each instance variable. Provide a method
 * displayDate that displays the month, day and year separated by forward
 * slashes (/). Write a test application named DateTest that demonstrates class
 * Date's capabilities.
 * 
 * @author Sanjib Maharjan
 * 
 */
public class DateTest {
	public static void main(String[] args) {
		Date dateParty = new Date(1, 12, 2014);
		Date dateOuting = new Date(1, 9, 2014);
		System.out.println("Date for Party:" + dateParty.getFormattedDate());
		System.out.println("Date for Outing:" + dateOuting.getFormattedDate());
	}
}

/**
 * This stores ths simple blueprints for storing date with day, month and year
 * values
 * 
 * @author Sanjib Maharjan
 */
class Date {
	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 * Gets the day.
	 * 
	 * @return this Date's day value.
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Changes the day value of the date.
	 * 
	 * @param month
	 *            sets the day.
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * Gets the month.
	 * 
	 * @return this Date's month value.
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Changes the month value of the date.
	 * 
	 * @param month
	 *            sets the month.
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * Gets the year.
	 * 
	 * @return this Date's year value.
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Changes the year value of the date.
	 * 
	 * @param year
	 *            sets the year.
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Gets the date{@link Date} in a formatted way.
	 * 
	 */
	public String getFormattedDate() {

		return year + "/" + FormatDate(month) + "/" + FormatDate(day);
	}

	/**
	 * This simply changes the single digit value to a double digit value for
	 * formatting the date.
	 * 
	 * @param value
	 */
	public String FormatDate(int value) {
		String tempValue = "";
		if ((value + "").length() < 2) {
			tempValue = "0" + value;
		} else {
			tempValue = "" + value;
		}
		return tempValue;
	}

}
