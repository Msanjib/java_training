/**
 * 
 */
package com.lftechnology.department.service;

import java.sql.SQLException;
import java.util.List;

import com.lftechnology.department.Department;
import com.lftechnology.department.dao.DepartmentDao;
import com.lftechnology.department.dao.DepartmentDaoImpl;

/**
 * This is the implementation of department service
 * 
 * @author sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class DepartmentServiceImpl implements DepartmentService {
	DepartmentDao departmentDao = new DepartmentDaoImpl();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.department.service.DepartmentService#addOrUpdateDepartment(com.lftechnology.department.Department)
	 */
	@Override
	public boolean addOrUpdateDepartment(Department department) throws SQLException {
		return departmentDao.addOrUpdateDepartment(department);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.department.service.DepartmentService#deleteDepartment(int)
	 */
	@Override
	public boolean deleteDepartment(int departmentId) throws SQLException {
		return departmentDao.deleteDepartment(departmentId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.department.service.DepartmentService#getAllDepartment()
	 */
	@Override
	public List<Department> getAllDepartment() throws SQLException {
		return departmentDao.getAllDepartment();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.department.service.DepartmentService#getDepartmentCount()
	 */
	@Override
	public int getDepartmentCount() throws SQLException {
		return departmentDao.getTotalDepartmentNumber();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.department.service.DepartmentService#getAllDepartmentSorted(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Department> getAllDepartmentSorted(String field, String order) throws SQLException {
		return departmentDao.getAllDepartmentSorted(field, order);
	}

}
