/**
 * 
 */
package com.lftechnology.employee;

/**
 * This defines the model class to store the information of employee
 * 
 * @author sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class Employee {
	private int id;
	private String fname;
	private String lname;
	private String gender;
	private String joined_date;
	private int department_id;
	private boolean isActive;
	private String departmentName;

	/**
	 * this method gives the id of the employee
	 * 
	 * @return the id of employee
	 */
	public int getId() {
		return id;
	}

	/**
	 * this method gives the department name of the employee
	 * 
	 * @return the department name that the employee belongs to
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * This method sets the department name of the employee
	 * 
	 * @param departmentName
	 *            the name for department that the employee belongs to.
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * This method sets the status of the employee
	 * 
	 * @param isActive
	 *            the flag to check the employee status.
	 */
	public void setStatus(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * This method sets the id for the employee
	 * 
	 * @param id
	 *            the identification of the employee.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * This method sets the date joined by the employee
	 * 
	 * @param joined_date
	 *            the date that the employee joins.
	 */
	public void setJoinedDate(String joined_date) {
		this.joined_date = joined_date;
	}

	/**
	 * this method gives the date joined by the employee
	 * 
	 * @return the date joined by employee
	 */
	public String getJoinedDate() {
		return joined_date;
	}

	/**
	 * this method gives concatenates the first and last name of the employee
	 * 
	 * @return the full name of employee
	 */
	public String getName() {
		StringBuilder fullName = new StringBuilder(fname);
		fullName.append(" ");
		fullName.append(lname);
		return fullName.toString().trim();
	}

	/**
	 * This method sets the first name of the employee
	 * 
	 * @param fname
	 *            the first name of the employee.
	 */
	public void setFName(String fname) {
		this.fname = fname;
	}

	/**
	 * This method sets the last name of the employee
	 * 
	 * @param lname
	 *            the last name of employee.
	 */
	public void setLName(String lname) {
		this.lname = lname;
	}

	/**
	 * this method gives the gender of the employee
	 * 
	 * @return the gender of employee
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * This method sets the gender of employee
	 * 
	 * @param gender
	 *            the gender of the employee.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * this method gives the department id of the employee
	 * 
	 * @return the department id of employee
	 */
	public int getDepartmentId() {
		return department_id;
	}

	/**
	 * This method sets the department id for the employee
	 * 
	 * @param department_id
	 *            the identification for department that the employee belongs to.
	 */
	public void setDepartment(int department_id) {
		this.department_id = department_id;
	}

	/**
	 * this method gives the first name of the employee
	 * 
	 * @return the first name of employee
	 */
	public String getFName() {
		return fname;
	}

	/**
	 * this method gives the last name of the employee
	 * 
	 * @return the last name of employee
	 */
	public String getLName() {
		return lname;
	}

	/**
	 * this method gives the status of the employee
	 * 
	 * @return the status of employee
	 */
	public boolean getStatus() {
		return isActive;
	}

}
