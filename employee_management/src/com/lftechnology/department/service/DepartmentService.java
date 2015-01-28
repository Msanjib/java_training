/**
 * 
 */
package com.lftechnology.department.service;

import java.sql.SQLException;
import java.util.List;

import com.lftechnology.department.Department;

/**
 * @author bhuwan
 * 
 */
public interface DepartmentService {
	/**
	 * This method performs add or update to the department database.It does a addion to database if the id is -1.But if the id is other
	 * than -1 then the table will be updated.
	 * 
	 * @param department
	 *            a {@link Department} instance to add or update the department database
	 * @return <code>true</code> if the operation is successful or <code>false</code> if the operation is unsuccessful
	 * @throws SQLException
	 */
	public boolean addOrUpdateDepartment(Department department) throws SQLException;

	/**
	 * This method removes the entry of a department from department table
	 * 
	 * @author sanjib<sanjibmaharjan@lftechnology.com>
	 * 
	 * @param departmentId
	 *            the id of department to be removed
	 * @return <code>true</code> if the delete successful or <code>false</code> if the delete unsuccessful
	 * @throws SQLException
	 */
	public boolean deleteDepartment(int departmentId) throws SQLException;

	/**
	 * This method lists out all the department and returns that list.
	 * 
	 * @author sanjib<sanjibmaharjan@lftechnology.com>
	 * 
	 * @return all the list of department{@link Department}
	 * @throws SQLException
	 */
	public List<Department> getAllDepartment() throws SQLException;

	/**
	 * This method lists out all the department which falls in the given type sorted by field and returns that list.
	 * 
	 * @author sanjib<sanjibmaharjan@lftechnology.com>
	 * 
	 * @param field
	 *            a column to which the list of employee{@link Department} is to be sorted
	 * @param order
	 *            to sort in descending or acending
	 * @return all the list of department{@link Department}
	 * @throws SQLException
	 */
	public List<Department> getAllDepartmentSorted(String field, String order) throws SQLException;

	/**
	 * This method finds out the number of departments.
	 * 
	 * @author sanjib<sanjibmaharjan@lftechnology.com>
	 * 
	 * @return the number of departments
	 * @throws SQLException
	 */
	public int getDepartmentCount() throws SQLException;
}
