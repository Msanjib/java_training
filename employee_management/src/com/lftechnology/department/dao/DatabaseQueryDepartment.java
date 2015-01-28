/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lftechnology.department.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lftechnology.department.Department;
import com.lftechnology.employee.db.ConnectionManager;
import com.mysql.jdbc.PreparedStatement;

/**
 * This is the simple database helper class to perform the database operations on the department table
 * 
 * @author sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class DatabaseQueryDepartment {

	Connection dbConn = null;
	private static final String TABLE_DEPARTMENT = "tbl_department";

	public DatabaseQueryDepartment() {
		dbConn = ConnectionManager.getConnection();

	}

	/**
	 * This method edits the information of department
	 * 
	 * @author sanjib<sanjibmaharjan@lftechnology.com>
	 * 
	 * @param department
	 *            {@link Department} instance to be updated
	 * @return <code>true</code> if the edit is successful or <code>false</code> if the edit is unsuccessful
	 * @throws SQLException
	 */
	public boolean editADepartment(Department department) throws SQLException {
		boolean success = false;
		String sql = "UPDATE " + TABLE_DEPARTMENT + " SET  name = ? WHERE department_id =? ";
		PreparedStatement ps = (PreparedStatement) dbConn.prepareStatement(sql);
		ps.setString(1, department.getName());
		ps.setInt(2, department.getId());
		success = ps.execute();
		if (dbConn != null) {
			try {

			} finally {
				dbConn.close();
			}
		}
		return success;
	}

	/**
	 * Inserts the given a instance of {@link Department} to department table
	 * 
	 * @author sanjib<sanjibmaharjan@lftechnology.com>
	 * 
	 * @param department
	 *            a instance of {@link Department}
	 * @return <code>true</true> if the insert is successful or <code>false</true> if the insert is unsuccessful
	 * @throws SQLException
	 */
	public boolean insertNewDepartment(Department department) throws SQLException {
		boolean success = false;
		String sql = "INSERT INTO " + TABLE_DEPARTMENT + " (name,added_time)" + "VALUES (?,Now())";

		PreparedStatement ps = (PreparedStatement) dbConn.prepareStatement(sql);
		ps.setString(1, department.getName());
		success = ps.execute();
		if (dbConn != null) {
			try {

			} finally {
				dbConn.close();
			}
		}
		return success;
	}

	/**
	 * This method finds out the number of departments.
	 * 
	 * @author sanjib<sanjibmaharjan@lftechnology.com>
	 * 
	 * @return the number of departments
	 * @throws SQLException
	 */
	public int getDepartmentCount() throws SQLException {
		String sql = "SELECT count(*) num FROM " + TABLE_DEPARTMENT;
		int empCount = 0;

		Statement st = dbConn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			empCount = rs.getInt("num");
		}
		if (dbConn != null) {
			try {

			} finally {
				dbConn.close();
			}
		}
		return empCount;
	}

	/**
	 * This method lists out all the department and returns that list.
	 * 
	 * @author sanjib<sanjibmaharjan@lftechnology.com>
	 * 
	 * @return all the list of department{@link Department}
	 * @throws SQLException
	 */
	public List<Department> getAllDepartmentData() throws SQLException {

		List<Department> departments = new ArrayList<Department>();
		String sql = "SELECT * FROM " + TABLE_DEPARTMENT + " ORDER BY name ASC";

		Statement st = dbConn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			Department dep = new Department();
			dep.setId(rs.getInt("department_id"));
			dep.setName(rs.getString("name"));
			dep.setAddedDate(rs.getString("added_time"));
			departments.add(dep);
		}
		if (dbConn != null) {
			try {

			} finally {
				dbConn.close();
			}
		}
		return departments;
	}

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
	public List<Department> getAllDepartmentDataBySorting(String field, String order) throws SQLException {
		List<Department> departments = new ArrayList<Department>();
		String sql = "SELECT * FROM " + TABLE_DEPARTMENT + " ORDER BY " + field + " " + order;
		Statement st = dbConn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			Department dep = new Department();
			dep.setId(rs.getInt("department_id"));
			dep.setName(rs.getString("name"));
			dep.setAddedDate(rs.getString("added_time"));
			departments.add(dep);
		}
		if (dbConn != null) {
			try {

			} finally {
				dbConn.close();
			}
		}
		return departments;
	}

	/**
	 * This method removes the entry of a department from department table
	 * 
	 * @author sanjib<sanjibmaharjan@lftechnology.com>
	 * 
	 * @param dep_id
	 *            the id of department to be removed
	 * @return <code>true</code> if the delete successful or <code>false</code> if the delete unsuccessful
	 * @throws SQLException
	 */
	public boolean deleteDepartment(int dep_id) throws SQLException {
		boolean success = false;
		String sql = "DELETE FROM " + TABLE_DEPARTMENT + " WHERE department_id=?";
		PreparedStatement ps = (PreparedStatement) dbConn.prepareStatement(sql);
		ps.setInt(1, dep_id);
		success = ps.execute();
		if (dbConn != null) {
			try {

			} finally {
				dbConn.close();
			}
		}
		return success;
	}
}
