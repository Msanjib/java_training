/**
 * 
 */
package com.lftechnology.department.dao;

import java.sql.SQLException;
import java.util.List;

import com.lftechnology.department.Department;
import com.lftechnology.employee.dao.DatabaseQueryEmployee;

/**
 * This defines the implementation of department dao interface
 * 
 * @author sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class DepartmentDaoImpl implements DepartmentDao {
	DatabaseQueryDepartment queryDepartment = new DatabaseQueryDepartment();
	DatabaseQueryEmployee queryEmployee = new DatabaseQueryEmployee();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.department.dao.DepartmentDao#addOrUpdateDepartment(com.lftechnology.department.Department)
	 */
	@Override
	public boolean addOrUpdateDepartment(Department department) throws SQLException {
		boolean success = false;
		if (department.getId() == -1) {
			queryDepartment.insertNewDepartment(department);
		} else {
			success = queryDepartment.editADepartment(department);
		}
		return success;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.department.dao.DepartmentDao#deleteDepartment(int)
	 */
	@Override
	public boolean deleteDepartment(int departmentId) throws SQLException {
		if (queryDepartment.deleteDepartment(departmentId)) {
			return queryEmployee.deleteAllEmployee(departmentId);
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.department.dao.DepartmentDao#getAllDepartment()
	 */
	@Override
	public List<Department> getAllDepartment() throws SQLException {
		return queryDepartment.getAllDepartmentData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.department.dao.DepartmentDao#getTotalDepartmentNumber()
	 */
	@Override
	public int getTotalDepartmentNumber() throws SQLException {
		return queryDepartment.getDepartmentCount();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.department.dao.DepartmentDao#getAllDepartmentSorted(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Department> getAllDepartmentSorted(String field, String order) throws SQLException {
		return queryDepartment.getAllDepartmentDataBySorting(field, order);
	}

}
