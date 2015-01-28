/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lftechnology.employee.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lftechnology.employee.Employee;
import com.lftechnology.employee.EmployeeCount;
import com.lftechnology.employee.db.ConnectionManager;
import com.mysql.jdbc.PreparedStatement;

/**
 * This is the simple database helper class to perform the database operations on the employee table
 * 
 * @author sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class DatabaseQueryEmployee {
	Connection dbConn = null;
	private static final String TABLE_EMPLOYEE = "tbl_employee";
	private static final String TABLE_DEPARTMENT = "tbl_department";

	public DatabaseQueryEmployee() {
		dbConn = ConnectionManager.getConnection();

	}

	/**
	 * This method edits the information of employee
	 * 
	 * @param employee
	 *            {@link Employee} instance to be updated
	 * @return <code>true</code> if the edit is successful or <code>false</code> if the edit is unsuccessful
	 * @throws SQLException
	 */
	public boolean editAEmployee(Employee employee) throws SQLException {
		boolean success = false;
		String sql = "UPDATE " + TABLE_EMPLOYEE + " SET  fname = ?, lname=? , gender=?, department_id=? WHERE employee_id =? ";

		PreparedStatement ps = (PreparedStatement) dbConn.prepareStatement(sql);
		ps.setString(1, employee.getFName());
		ps.setString(2, employee.getLName());
		ps.setString(3, employee.getGender());
		ps.setInt(4, employee.getDepartmentId());
		ps.setInt(5, employee.getId());
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
	 * Inserts the given a instance of {@link Employee} to employee table
	 * 
	 * @param employee
	 *            a instance of {@link Employee}
	 * @return <code>true</true> if the insert is successful or <code>false</true> if the insert is unsuccessful
	 * @throws SQLException
	 */
	public boolean insertNewEmployee(Employee employee) throws SQLException {
		boolean success = false;
		String sql =
				"INSERT INTO " + TABLE_EMPLOYEE + " (fname,lname,gender,department_id,is_active,joined_date)" + "VALUES (?,?,?,?,?,Now())";

		PreparedStatement ps = (PreparedStatement) dbConn.prepareStatement(sql);
		ps.setString(1, employee.getFName());
		ps.setString(2, employee.getLName());
		ps.setString(3, employee.getGender());
		ps.setInt(4, employee.getDepartmentId());
		ps.setBoolean(5, employee.getStatus());
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
	 * This method simply toggles the status of employee to active and inactive
	 * 
	 * @author sanjib<sanjibmaharjan@lftechnology.com>
	 * 
	 * @param id
	 *            the id of employee to toggle the status
	 * @return <code>true</code> if the toggle is successful or <code>false</code> if the toggle is unsuccessful
	 * @throws SQLException
	 */
	public boolean toggleEmployeeStatus(int id) throws SQLException {
		String sql = "SELECT is_active FROM " + TABLE_EMPLOYEE + " WHERE employee_id=" + id;
		boolean success = false;

		Statement st = dbConn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getBoolean("is_active"));
			String sqlUpdate = "UPDATE " + TABLE_EMPLOYEE + " SET  is_active=" + !rs.getBoolean("is_active") + " WHERE employee_id = " + id;

			success = st.execute(sqlUpdate);
		}
		if (dbConn != null) {
			try {

			} finally {
				dbConn.close();
			}
		}
		return success;
	}

	/**
	 * This method return all the employees
	 * 
	 * @author sanjib<sanjibmaharjan@lftechnology.com>
	 * 
	 * @return the total number of employee
	 * @throws SQLException
	 */
	public int getEmployeeCount() throws SQLException {
		String sql = "SELECT count(*) num FROM " + TABLE_EMPLOYEE;
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
	 * This method return all the employees by distinguishing the active and inactive employees
	 * 
	 * @author sanjib<sanjibmaharjan@lftechnology.com>
	 * 
	 * @return the total number of active, inactive and all employee
	 * @throws SQLException
	 */
	public EmployeeCount getActiveEmployeeCount() throws SQLException {
		String sqlActive = "SELECT count(*) num FROM " + TABLE_EMPLOYEE + " WHERE is_active=1";
		String sqlInactive = "SELECT count(*) numin FROM " + TABLE_EMPLOYEE + " WHERE is_active=0";
		int activeEmpCount = 0;
		int inActiveEmpCount = 0;
		EmployeeCount count = new EmployeeCount();

		Statement st = dbConn.createStatement();
		ResultSet rs = st.executeQuery(sqlActive);
		while (rs.next()) {
			activeEmpCount = rs.getInt("num");
			count.setActiveEmployeeCount(activeEmpCount);
		}
		rs = st.executeQuery(sqlInactive);
		while (rs.next()) {
			inActiveEmpCount = rs.getInt("numin");
			count.setOtherEmployeeCount(inActiveEmpCount);
		}
		count.setAllEmployeeCount(activeEmpCount + inActiveEmpCount);
		if (dbConn != null) {
			try {

			} finally {
				dbConn.close();
			}
		}
		return count;
	}

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
	public List<Employee> getAllEmployee(String type, String field, String order) throws SQLException {

		List<Employee> employees = new ArrayList<Employee>();
		String sql = "";
		if (type.equals("a")) {
			sql =
					"SELECT * FROM " + TABLE_EMPLOYEE + " e JOIN " + TABLE_DEPARTMENT + " d on e.department_id=d.department_id "
							+ " WHERE is_active=1 ORDER BY " + field + " " + order;
		} else if (type.equals("i")) {
			sql =
					"SELECT * FROM " + TABLE_EMPLOYEE + " e JOIN " + TABLE_DEPARTMENT + " d on e.department_id=d.department_id "
							+ " WHERE is_active=0 ORDER " + field + " " + order;
		} else {
			sql =
					"SELECT * FROM " + TABLE_EMPLOYEE + " e JOIN " + TABLE_DEPARTMENT + " d on e.department_id=d.department_id "
							+ " ORDER BY " + field + " " + order;
		}
		Statement st = dbConn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			Employee usr = new Employee();
			usr.setId(rs.getInt("employee_id"));
			usr.setGender(rs.getString("gender"));
			usr.setFName(rs.getString("fname"));
			usr.setLName(rs.getString("lname"));
			usr.setStatus(rs.getBoolean("is_active"));
			usr.setDepartmentName(rs.getString("name"));
			usr.setDepartment(rs.getInt("department_id"));
			usr.setJoinedDate(rs.getString("joined_date"));
			employees.add(usr);
		}
		if (dbConn != null) {
			try {

			} finally {
				dbConn.close();
			}
		}
		return employees;
	}

	/**
	 * Deletes all the employee with the given id
	 * 
	 * @author sanjib<sanjibmaharjan@lftechnology.com>
	 * 
	 * @param id
	 *            the identification of employee to be deleted.
	 * @return <code>true</code> if the delete is successful or <code>false</code> if the delete is unsuccessful
	 */
	public boolean deleteEmployee(int id) throws SQLException {
		boolean success = false;
		String sql = "DELETE FROM " + TABLE_EMPLOYEE + " WHERE employee_id=?";
		PreparedStatement ps = (PreparedStatement) dbConn.prepareStatement(sql);
		ps.setInt(1, id);
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
	 * Deletes all the employee with the give department id
	 * 
	 * @author sanjib<sanjibmaharjan@lftechnology.com>
	 * 
	 * @param departmentId
	 * @return success <code>0</code> if the delete is successful
	 */
	public boolean deleteAllEmployee(int departmentId) throws SQLException {
		boolean success = false;
		String sql = "DELETE FROM " + TABLE_EMPLOYEE + " WHERE department_id=?";

		PreparedStatement ps = (PreparedStatement) dbConn.prepareStatement(sql);
		ps.setInt(1, departmentId);
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
