package com.lftechnology.employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lftechnology.department.service.DepartmentServiceImpl;
import com.lftechnology.employee.service.EmployeeServiceImpl;

/**
 * Servlet implementation class which is the welcome page to get the number of employees and department and redirect tot the main class.
 * 
 * @author sanjib<sanjibmaharjan@lftechnology.com>
 */
@WebServlet("/index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(Index.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeServiceImpl imp = new EmployeeServiceImpl();
		DepartmentServiceImpl dep = new DepartmentServiceImpl();
		int numDepartments = 0;
		try {
			numDepartments = dep.getDepartmentCount();
		} catch (SQLException e1) {
			LOGGER.severe("Error getting departnent count");
		}
		EmployeeCount empCount = new EmployeeCount();
		try {
			empCount = imp.getEmployeesCount();

			request.setAttribute("numEmp", empCount.getAllEmployeeCount());
			request.setAttribute("numAEmp", empCount.getActiveEmployeeCount());
			request.setAttribute("numIEmp", empCount.getOtherEmployeeCount());
		} catch (SQLException e) {
			LOGGER.severe("Error getting employee count");
		}
		request.setAttribute("numDep", numDepartments);
		getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
