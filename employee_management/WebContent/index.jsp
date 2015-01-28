<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.lftechnology.employee.dao.DatabaseQueryEmployee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lftechnology.employee.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.lftechnology.employee.service.EmployeeServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main page</title>
<link href="css/reset.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
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
				<li><a href="departManager">Department</a></li>
			</ul>
		</div>
	</div>
	<div class="main-body-wrapper">
		<div class="body-wrapper">
			<div class="emp-section cfix">
				<h1>Total Employees</h1>

				<div class="circle-div">
					<span class="title">All</span> <a href="empManager?type=any"><span
						class="num">
							<%
								out.print(request.getAttribute("numEmp"));
							%>
					</span></a>


				</div>

				<div class="circle-div">
					<span class="title">Active</span> <a href="empManager?type=active"><span
						class="num">
							<%
								out.print(request.getAttribute("numAEmp"));
							%>
					</span></a>


				</div>

				<div class="circle-div">
					<span class="title">Others</span> <a
						href="empManager?type=inactive"><span class="num">
							<%
								out.print(request.getAttribute("numIEmp"));
							%>
					</span></a>


				</div>

			</div>


			<div class="dep-section cfix">
				<h1>Department</h1>

				<div class="circle-div">
					<span class="titleBig">All</span> <a href="departManager"><span
						class="numBig">
							<%
								out.print(request.getAttribute("numDep"));
							%>
					</span></a>


				</div>

			</div>

		</div>
	</div>










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

	<!--/*footer*/-->
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