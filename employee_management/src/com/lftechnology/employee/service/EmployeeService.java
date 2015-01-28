/**
 * 
 */
package com.lftechnology.employee.service;

import java.sql.SQLException;
import java.util.List;

import com.lftechnology.department.Department;
import com.lftechnology.employee.Employee;
import com.lftechnology.employee.EmployeeCount;

/**
 * This defines the interface for employee services
 * 
 * @author sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public interface EmployeeService {
	/**
	 * This method performs add or update to the employee database.It does a addion to database if the id is -1.But if the id is other than
	 * -1 then the table will be updated.
	 * 
	 * @param employee
	 *            a {@link Employee} instance to add or update the employee database
	 * @return <code>true</code> if the operation is successful or <code>false</code> if the operation is unsuccessful
	 * @throws SQLException
	 */
	public boolean addOrUpdateEmployee(Employee employee) throws SQLException;

	/**
	 * Deletes all the employee with the given id
	 * 
	 * @author sanjib<sanjibmaharjan@lftechnology.com>
	 * 
	 * @param id
	 *            the identification of employee to be deleted.
	 * @return <code>true</code> if the delete is successful or <code>false</code> if the delete is unsuccessful
	 */
	public boolean deleteEmployee(int id) throws SQLException;

	/**
	 * This method lists out all the employees which falls in the given type sorted by field.
	 * 
	 * @author sanjib<sanjibmaharjan@lftechnology.com>
	 * 
	 * @param type
	 *            to check if the employees to return are active or inactive or all
	 * @param field
	 *            a column to which the list of employee{@link Employee} is to be sorted
	 * @param order
	 *            to sort in descending or acending
	 * @return all the list of employee{@link Employee}
	 * @throws SQLException
	 */
	public List<Employee> getAllEmployees(String type, String field, String order) throws SQLException;

	/**
	 * This method return all the employees
	 * 
	 * @author sanjib<sanjibmaharjan@lftechnology.com>
	 * 
	 * @return the total number of employee
	 * @throws SQLException
	 */
	public int getEmployeeCount() throws SQLException;

	/**
	 * This method return all the employees by distinguishing the active and inactive employees
	 * 
	 * @author sanjib<sanjibmaharjan@lftechnology.com>
	 * 
	 * @return the total number of active, inactive and all employee
	 * @throws SQLException
	 */
	public EmployeeCount getEmployeesCount() throws SQLException;

	/**
	 * This method simply toggles the status of employee to active and inactive
	 * 
	 * @author sanjib<sanjibmaharjan@lftechnology.com>
	 * 
	 * @param id
	 *            the id of employee to toggle the status
	 * @return <code>true</code> if the toggle is successful or <code>false</code> if the toggle is unsuccessful
	 * @throws SQLException
	 */
	public boolean toggleEmployeeStatus(int id) throws SQLException;

	/**
	 * This method returns the list of all the departments
	 * 
	 * @return the list of departments
	 * @throws SQLException
	 */
	public List<Department> getAllDepartmant() throws SQLException;
}
