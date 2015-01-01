package com.lftechnology.task.dec31;

/**
 * Q4. Create a class called Time with three attributes hours, minutes, and
 * seconds. Use appropriate constructor (s) to initialize instance variables.
 * Also, use a display method to display the time in hh:mm:ss format. Modify the
 * class to add two time objects that correctly results in addition of times.
 * 
 * @author My Snjb
 * 
 */
public class TimeAdder {
	public static void main(String[] args) {
		System.out.print("Time taken to Eat->\t");
		Time timeToEat = new Time(1, 50, 50);
		timeToEat.displayTime();
		System.out.print("Time taken to Read->\t");
		Time timeToRead = new Time(1, 40, 30);
		timeToRead.displayTime();
		System.out.println("Total time taken->\t"
				+ addTime(new Time[] { timeToEat, timeToRead }).getTime());

	}

	public static Time addTime(Time[] times) {
		int numTime = times.length;
		Time resultTime = new Time();
		int totalTimeInSecs = 0;
		for (int i = 0; i < numTime; i++) {
			totalTimeInSecs += ((times[i].hours * 60) + times[i].minutes) * 60
					+ times[i].seconds;
		}
		resultTime.hours = totalTimeInSecs / 3600;
		resultTime.minutes = ((totalTimeInSecs) / 60) % 60;
		resultTime.seconds = totalTimeInSecs % 60;
		return resultTime;
	}
}

class Time {
	public int hours;
	public int minutes;
	public int seconds;

	public Time() {
	}

	public Time(int hours, int minutes, int seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public void displayTime() {
		System.out.println(hours + ":" + minutes + ":" + seconds);
	}

	public String getTime() {
		return hours + ":" + minutes + ":" + seconds;
	}
}