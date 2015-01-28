/**
 * 
 */
package com.lftechnology.employee.service;

import java.sql.SQLException;
import java.util.List;

import com.lftechnology.department.Department;
import com.lftechnology.department.dao.DepartmentDao;
import com.lftechnology.department.dao.DepartmentDaoImpl;
import com.lftechnology.employee.Employee;
import com.lftechnology.employee.EmployeeCount;
import com.lftechnology.employee.dao.EmployeeDao;
import com.lftechnology.employee.dao.EmployeeDaoImpl;

/**
 * This is the implementation of the employee services
 * 
 * @author sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDao employeeDao = new EmployeeDaoImpl();
	DepartmentDao departmantDao = new DepartmentDaoImpl();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.employee.service.EmployeeService#addOrUpdateEmployee(com.lftechnology.employee.Employee)
	 */
	@Override
	public boolean addOrUpdateEmployee(Employee employee) throws SQLException {
		return employeeDao.addOrUpdateEmployee(employee);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.employee.service.EmployeeService#getAllEmployees(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Employee> getAllEmployees(String type, String field, String order) throws SQLException {
		return employeeDao.getAllEmployees(type, field, order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.employee.service.EmployeeService#getEmployeeCount()
	 */
	@Override
	public int getEmployeeCount() throws SQLException {
		return employeeDao.getTotalEmployeeNumber();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.employee.service.EmployeeService#deleteEmployee(int)
	 */
	@Override
	public boolean deleteEmployee(int id) throws SQLException {
		return employeeDao.deleteEmployee(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.employee.service.EmployeeService#toggleEmployeeStatus(int)
	 */
	@Override
	public boolean toggleEmployeeStatus(int id) throws SQLException {
		return employeeDao.toggleStatus(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.employee.service.EmployeeService#getEmployeesCount()
	 */
	@Override
	public EmployeeCount getEmployeesCount() throws SQLException {
		return employeeDao.getEmployeeCount();
	}

	@Override
	public List<Department> getAllDepartmant() throws SQLException {
		return departmantDao.getAllDepartment();
	}

}
