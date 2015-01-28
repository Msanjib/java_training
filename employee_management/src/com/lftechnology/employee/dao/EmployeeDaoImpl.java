/**
 * 
 */
package com.lftechnology.employee.dao;

import java.sql.SQLException;
import java.util.List;

import com.lftechnology.employee.Employee;
import com.lftechnology.employee.EmployeeCount;

public class EmployeeDaoImpl implements EmployeeDao {
	DatabaseQueryEmployee query = new DatabaseQueryEmployee();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.employee.dao.EmployeeDao#addOrUpdateEmployee(com.lftechnology.employee.Employee)
	 */
	@Override
	public boolean addOrUpdateEmployee(Employee employee) throws SQLException {
		boolean success = false;
		if (employee.getId() == -1) {
			query.insertNewEmployee(employee);
		} else {
			success = query.editAEmployee(employee);
		}
		return success;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.employee.dao.EmployeeDao#getAllEmployees(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Employee> getAllEmployees(String type, String field, String order) throws SQLException {
		return query.getAllEmployee(type, field, order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.employee.dao.EmployeeDao#getTotalEmployeeNumber()
	 */
	@Override
	public int getTotalEmployeeNumber() throws SQLException {
		return query.getEmployeeCount();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.employee.dao.EmployeeDao#deleteEmployee(int)
	 */
	@Override
	public boolean deleteEmployee(int id) throws SQLException {
		return query.deleteEmployee(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.employee.dao.EmployeeDao#toggleStatus(int)
	 */
	@Override
	public boolean toggleStatus(int id) throws SQLException {
		return query.toggleEmployeeStatus(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.employee.dao.EmployeeDao#getEmployeeCount()
	 */
	@Override
	public EmployeeCount getEmployeeCount() throws SQLException {
		return query.getActiveEmployeeCount();
	}

}
