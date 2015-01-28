package com.lftechnology.employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lftechnology.department.Department;
import com.lftechnology.employee.service.EmployeeServiceImpl;

/**
 * Servlet implementation class to perform different operation and redirect to other pages
 * 
 * @author sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
@WebServlet({ "/emps", "/empManager" })
public class ManageEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(ManageEmployeeServlet.class.getName());
	private String sortField = "fname";
	private String sortOrder = "ASC";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageEmployeeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// In default sort by first name in ascending order
		sortField = "fname";
		sortOrder = "ASC";
		if (request.getParameter("action") != null) {
			// checking the action for deleting records
			if (request.getParameter("action").equals("delete")) {
				EmployeeServiceImpl emp = new EmployeeServiceImpl();

				try {
					emp.deleteEmployee(Integer.parseInt(request.getParameter("id")));
				} catch (SQLException e) {
					LOGGER.severe("Error in deleting the record:" + e.getMessage() + ", " + e.getClass());
				} catch (NumberFormatException e) {
					LOGGER.severe("The id is not in valid format:" + e.getMessage() + ", " + e.getClass());
				}
				// checking the action for toggling the status of employee
			} else if (request.getParameter("action").equals("act")) {

				EmployeeServiceImpl toggleStatusService = new EmployeeServiceImpl();
				try {
					toggleStatusService.toggleEmployeeStatus(Integer.parseInt(request.getParameter("id")));
				} catch (NumberFormatException | SQLException e) {
					LOGGER.severe("Error switching the status:" + e.getMessage() + ", " + e.getClass());
				}
			}
		}
		// a session to store the employee type to fetch the records of(active, inactive or all)
		HttpSession session = request.getSession();
		if (request.getParameter("type") != null) {
			String pageType = request.getParameter("type");
			if (pageType.equals("inactive")) {
				session.setAttribute("page", "inactive");
			} else if (pageType.equals("active")) {
				session.setAttribute("page", "active");
			} else {
				session.removeAttribute("page");
			}
		}
		List<Employee> employeeList = new ArrayList<>();
		List<Department> departmentList = new ArrayList<>();
		EmployeeServiceImpl empGetService = new EmployeeServiceImpl();
		// Depending on the stored session value fetch the active, inactive or all the records of employee
		if (session.getAttribute("page") != null) {
			if (session.getAttribute("page").equals("inactive")) {
				try {
					employeeList = empGetService.getAllEmployees("i", sortField, sortOrder);
				} catch (SQLException e) {
					LOGGER.severe("Error fetching the employees:" + e.getMessage() + ", " + e.getClass());
				}
			} else {
				try {
					employeeList = empGetService.getAllEmployees("a", sortField, sortOrder);
				} catch (SQLException e) {
					LOGGER.severe("Error in fetching the employees:" + e.getMessage() + ", " + e.getClass());
				}
			}
		} else {
			try {
				employeeList = empGetService.getAllEmployees("", sortField, sortOrder);
			} catch (SQLException e) {
				LOGGER.severe("Error in fetching the employees:" + e.getMessage() + ", " + e.getClass());
			}
		}

		try {
			departmentList = empGetService.getAllDepartmant();
		} catch (SQLException e) {
			LOGGER.severe("Error in getting the department lists:" + e.getMessage() + ", " + e.getClass());
		}
		request.setAttribute("userLists", employeeList);
		request.setAttribute("depLists", departmentList);
		getServletConfig().getServletContext().getRequestDispatcher("/list_employee.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (request.getParameter("action") != null) {
			// checking the action for adding the record
			if (request.getParameter("action").equals("add-new")) {
				EmployeeServiceImpl emp = new EmployeeServiceImpl();
				Employee employee = new Employee();
				employee.setId(-1);
				employee.setFName(request.getParameter("fname"));
				employee.setLName(request.getParameter("lname"));
				employee.setGender(request.getParameter("gender"));
				if (session.getAttribute("page") != null && session.getAttribute("page").equals("active")) {
					employee.setStatus(true);
				} else {
					employee.setStatus(false);
				}
				employee.setDepartment(Integer.parseInt(request.getParameter("departmtnt_id")));
				try {
					emp.addOrUpdateEmployee(employee);
				} catch (SQLException e) {
					LOGGER.severe("Error in adding the record:" + e.getMessage() + ", " + e.getClass());
				}
				// checking the action for updating the record
			} else if (request.getParameter("action").equals("edit-add")) {
				EmployeeServiceImpl emp = new EmployeeServiceImpl();
				Employee employee = new Employee();
				employee.setId(Integer.parseInt(request.getParameter("emp-id")));
				employee.setFName(request.getParameter("edited-fname"));
				employee.setLName(request.getParameter("edited-lname"));
				employee.setGender(request.getParameter("edited-gender"));
				employee.setDepartment(Integer.parseInt(request.getParameter("edited_department_id")));

				try {
					emp.addOrUpdateEmployee(employee);
				} catch (SQLException e) {
					LOGGER.severe("Error in updating the record:" + e.getMessage() + ", " + e.getClass());
				}
			}
		}
		// checking the action to sort the record with the specified field in specified order
		if (request.getParameter("actionsort") != null && request.getParameter("actionsort").equals("sortby")) {
			sortField = request.getParameter("sort-field");
			sortOrder = request.getParameter("sort-order");
		}

		List<Employee> employeeList = new ArrayList<>();
		List<Department> departmentList = new ArrayList<>();
		EmployeeServiceImpl empGetService = new EmployeeServiceImpl();
		if (session.getAttribute("page") != null) {
			if (session.getAttribute("page").equals("inactive")) {
				try {
					employeeList = empGetService.getAllEmployees("i", sortField, sortOrder);
				} catch (SQLException e) {
					LOGGER.severe("Error in fetching the record of inactive employee:" + e.getMessage() + ", " + e.getClass());
				}
			} else {
				try {
					employeeList = empGetService.getAllEmployees("a", sortField, sortOrder);
				} catch (SQLException e) {
					LOGGER.severe("Error in fetching the record of active employees:" + e.getMessage() + ", " + e.getClass());
				}
			}
		} else {
			try {
				employeeList = empGetService.getAllEmployees("", sortField, sortOrder);
			} catch (SQLException e) {
				LOGGER.severe("Error in fetching the record of all employees:" + e.getMessage() + ", " + e.getClass());
			}
		}
		// fetch the department list to map to the employee with department
		try {
			departmentList = empGetService.getAllDepartmant();
		} catch (SQLException e) {
			LOGGER.severe("Error in fetching the records of departments:" + e.getMessage() + ", " + e.getClass());
		}
		request.setAttribute("userLists", employeeList);
		request.setAttribute("depLists", departmentList);
		getServletConfig().getServletContext().getRequestDispatcher("/list_employee.jsp").forward(request, response);
	}
}
