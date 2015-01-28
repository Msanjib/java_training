package com.lftechnology.employee;

/**
 * This is the helper class to store the the total number of employees distinguishing the active and inactive.
 * 
 * @author sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class EmployeeCount {
	private int activeEmployeeCount;
	private int allEmployeeCount;
	private int otherEmployeeCount;

	/**
	 * this method gives number of active employee
	 * 
	 * @return the active employee count
	 */
	public int getActiveEmployeeCount() {
		return activeEmployeeCount;
	}

	/**
	 * This method sets the active employee
	 * 
	 * @param activeEmployeeCount
	 *            the number fo active employee.
	 */
	public void setActiveEmployeeCount(int activeEmployeeCount) {
		this.activeEmployeeCount = activeEmployeeCount;
	}

	/**
	 * this method gives the total number of employee
	 * 
	 * @return the the total number of employee
	 */
	public int getAllEmployeeCount() {
		return allEmployeeCount;
	}

	/**
	 * This method sets the total employee number
	 * 
	 * @param allEmployeeCount
	 *            the total employee count
	 */
	public void setAllEmployeeCount(int allEmployeeCount) {
		this.allEmployeeCount = allEmployeeCount;
	}

	/**
	 * this method gives the number of inactive employee
	 * 
	 * @return the inactive employee number
	 */
	public int getOtherEmployeeCount() {
		return otherEmployeeCount;
	}

	/**
	 * This method sets the inactive employee
	 * 
	 * @param otherEmployeeCount
	 *            the number of inactive employee
	 */
	public void setOtherEmployeeCount(int otherEmployeeCount) {
		this.otherEmployeeCount = otherEmployeeCount;
	}
}
