/**
 * 
 */
package com.lftechnology.department;

/**
 * This is the modal class to store the information of departments.
 * 
 * @author sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class Department {
	private int id;
	private String name;
	private String addedDate;

	/**
	 * this method gives the id of the department
	 * 
	 * @return the id of depatment
	 */
	public int getId() {
		return id;
	}

	/**
	 * This method sets the department id
	 * 
	 * @param id
	 *            the id of department.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * this method gives the name of the department
	 * 
	 * @return the name of department
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the department name
	 * 
	 * @param name
	 *            the name of department.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * this method gives added date of department
	 * 
	 * @return the added date
	 */
	public String getAddedDate() {
		return addedDate;
	}

	/**
	 * This method sets the added date of department
	 * 
	 * @param addedDate
	 *            the date of addition of department.
	 */
	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
	}

}
