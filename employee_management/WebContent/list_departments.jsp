<%@page import="com.lftechnology.department.Department"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.lftechnology.employee.dao.DatabaseQueryEmployee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lftechnology.employee.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.lftechnology.employee.service.EmployeeServiceImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employees</title>
<link href="css/reset.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />

<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="js/check.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("span#adddep").click(function() {
			$("div#adddiv").slideToggle("fast");
		});
		<c:forEach items="${depLists}" var="res">
		$('div#editdep${res.getId()}').hide();
		$("span#clickdep${res.getId()}").click(function() {
			$("div#editdep${res.getId()}").slideToggle("fast");
		});
		</c:forEach>
	});
</script>
</head>
<body>
	<div class="main-header-wrapper">
		<div class="header-wrapper cfix">
			<div class="logo-wrapper">
				<h1>
					<a href="index">DashBoard</a>
				</h1>
				<span>Employee Management System</span>
			</div>
			<ul class="cfix">
				<li><a href="empManager?type=any">Employee</a></li>
				<li>Department</li>
			</ul>
		</div>
	</div>
	<div class="main-body-wrapper">
		<div class="body-wrapper">
			<div class="body-wrapper-hidden cfix" id="adddiv">
				<form method="post" action="departManager"
					onsubmit="Javascript: return validateDepartment();">
					<label class="separator"> Department Name:<input
						type="text" name="dname" id="dname" />
					</label> <input type="submit" value="Add"><span id="formCheckDep"></span>
					<input type="hidden" value="add-newDep" name="action">
				</form>
			</div>
			<div class="menu-strip cfix">
				<span id="adddep">Add Department</span>
				<h1>Departments</h1>
				<form method="post" action="departManager">
					Sort By: <select name="field">
						<option value="name">Name</option>
						<option value="added_time">Added Date</option>
					</select> <select name="sort-order">
						<option value="ASC">Ascending</option>
						<option value="DESC">Descending</option>
					</select> <input type="hidden" value="sortby" name="actionsort"> <input
						type="submit" value="Go">
				</form>
			</div>

			<div class="table-section">
				<table>
					<tr>
						<th>Sn</th>
						<th>Department Name</th>
						<th>Added Date</th>
						<th>Action</th>
					</tr>
					<%
						int i = 0;
					%>
					<c:forEach items="${depLists}" var="department">
						<tr>
							<td>
								<%
									out.print(++i);
								%>
							</td>
							<td>${department.getName()}</td>
							<td>${department.getAdded_date()}</td>
							<td><span id="clickdep${department.getId()}" class="green">Edit</span>
								| <a href="departManager?action=delete&id=${department.getId()}"
								onClick="Javascript: return confirm('Are you sure you want to delete?\nAll employees will also be deleted.')">Delete</a></td>
						</tr>
						<tr>
							<td colspan="7" class="edits">
								<div class="edit-form" id="editdep${department.getId()}">
									<form method="post" action="departManager"
										onsubmit="Javascript: return validateEditDepartment();">
										<label class="separator">Name: <input type="text"
											name="edited-dname" id="edited-dname"
											placeholder="Enter department name"
											value="${department.getName()}"></input>
										</label> <input type="submit" value="Edit"><span
											id="edited-formCheckDep"></span> <input type="hidden"
											value="edit-addDep" name="action"> <input
											type="hidden" value="${department.getId()}" name="dep-id">

									</form>
								</div>
							</td>
						</tr>
					</c:forEach>

				</table>

			</div>




		</div>
	</div>






	<!--/*footer*/-->
	<div class="footer-wrapper">



		<span class="ftTp">Employee Management System</span>
		<div class="list-wrapper cfix">
			<ul>
				<li class="tps"><span style="font-weight: bold;">Functionality
				</span>
					<ul>
						<li>Employee Management</li>
						<li>View Departments</li>
						<li>View Employees</li>
					</ul></li>
				<li class="tps"><span style="font-weight: bold;">Steps
						to simple Insertion</span>
					<ul>
						<li>Click on "Add New Employee" from main Employee section.</li>
						<li>Fill out the form with the required information.</li>
						<li>Click on "Check Validity" for the validity of the
							inserted data.</li>
						<li>If the inserted data are valid then Add button will
							appear.</li>
						<li>Click on "Add".Relax.</li>
					</ul></li>
				<li class="tps"><span style="font-weight: bold;">Steps
						to Advanced Searching</span>
					<ul>
						<li>Type the keyword for the name you want to search</li>
						<li>Search for the required fields and change as per the
							requirement</li>
						<li>If certain search parameter are unnecessary the just
							leave them be.</li>
						<li>Go through thoroughly and make adjustments as required.</li>
						<li>Click on Search button.</li>
						<li>All the matched records will be displayed</li>
						<li>If you are not satisfied with the result.Repeat all the
							steps to search again.</li>
					</ul></li>



			</ul>
			<div class="clear-all"></div>
		</div>
	</div>


	<div class="footer">
		<div class="footer-inside">
			<ul>
				<li><a href="#">About Us</a>|</li>
				<li><a href="#">Contact Us</a>|</li>
				<li><a href="#">FAQs</a>|</li>
				<li><a href="#">Disclaimer</a>|</li>
				<li><a href="#">Privacy Policy</a>|</li>
				<li><a href="#">Links</a>|</li>
				<li><a href="#">Sitemap</a></li>

			</ul>
		</div>
	</div>
</body>
</html>