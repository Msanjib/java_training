package com.lftechnology.department;

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

import com.lftechnology.department.service.DepartmentServiceImpl;

/**
 * Servlet implementation class to perform different operation and redirect to other pages
 * 
 * @author sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
@WebServlet({ "/departManager" })
public class ManageDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(ManageDepartmentServlet.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageDepartmentServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("action") != null && request.getParameter("action").equals("delete")) {
			DepartmentServiceImpl deleteService = new DepartmentServiceImpl();

			try {
				deleteService.deleteDepartment(Integer.parseInt(request.getParameter("id")));
			} catch (SQLException e) {
				LOGGER.severe("Error in deleting the record");
			} catch (NumberFormatException e) {
				LOGGER.severe("The id is not in valid format");
			}
		}

		List<Department> departments = new ArrayList<>();
		DepartmentServiceImpl depService = new DepartmentServiceImpl();
		try {
			departments = depService.getAllDepartment();
		} catch (SQLException e) {
			LOGGER.severe("Error in fetching departments");
		}
		request.setAttribute("depLists", departments);
		getServletConfig().getServletContext().getRequestDispatcher("/list_departments.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Department> u = new ArrayList<>();
		DepartmentServiceImpl depService = new DepartmentServiceImpl();
		if (request.getParameter("action") != null) {
			if (request.getParameter("action").equals("add-newDep")) {
				DepartmentServiceImpl addService = new DepartmentServiceImpl();
				Department department = new Department();
				department.setId(-1);
				department.setName(request.getParameter("dname"));
				try {
					addService.addOrUpdateDepartment(department);
				} catch (SQLException e) {
					LOGGER.severe("Error in addingthe record.");
				}
			} else if (request.getParameter("action").equals("edit-addDep")) {
				DepartmentServiceImpl editService = new DepartmentServiceImpl();
				Department department = new Department();
				department.setId(Integer.parseInt(request.getParameter("dep-id")));
				department.setName(request.getParameter("edited-dname"));
				try {
					editService.addOrUpdateDepartment(department);
				} catch (SQLException e) {
					LOGGER.severe("Error in updating the record.");
				}
			}

			try {
				u = depService.getAllDepartment();
			} catch (SQLException e) {
				LOGGER.severe("Error in fetching departments");
			}

		} else if (request.getParameter("actionsort") != null && request.getParameter("actionsort").equals("sortby")) {
			DepartmentServiceImpl sortService = new DepartmentServiceImpl();
			try {
				u = sortService.getAllDepartmentSorted(request.getParameter("field"), request.getParameter("sort-order"));
			} catch (SQLException e) {
				LOGGER.severe("Error in fetching departments in sorted order");
			}
		}

		request.setAttribute("depLists", u);
		getServletConfig().getServletContext().getRequestDispatcher("/list_departments.jsp").forward(request, response);
	}
}
