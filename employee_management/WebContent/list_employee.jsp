<%@page import="com.lftechnology.department.Department"%>
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
		$("span#addemp").click(function() {
			$("div#adddiv").slideToggle("fast");
		});
		<c:forEach items="${userLists}" var="res">
	        $('div#edit${res.getId()}').hide();
	        $("span#click${res.getId()}").click(function(){
				$("div#edit${res.getId()}").slideToggle("fast");
			});
		</c:forEach>
	});
</script>
</head>
<body>
	<c:forEach items="${userLists}" var="res">
	</c:forEach>
	<div class="main-header-wrapper">
		<div class="header-wrapper cfix">
			<div class="logo-wrapper">
				<h1>
					<a href="index">DashBoard</a>
				</h1>
				<span>Employee Management System</span>
			</div>
			<ul class="cfix">
				<li>Employee</li>
				<li><a href="departManager">Department</a></li>
			</ul>
		</div>
	</div>
	<div class="main-body-wrapper">
		<div class="body-wrapper">
			<div class="body-wrapper-hidden cfix" id="adddiv">
				<form method="post" action="empManager"
					onsubmit="Javascript: return validate();">
					<label class="separator"> First Name:<input type="text"
						name="fname" id="fname" />
					</label> <label class="separator"> Last Name:<input type="text"
						name="lname" id="lname" />
					</label>
					<div class="separator">
						Gender: <label><input type="radio" name="gender" value="M"
							checked>Male</label> <label><input type="radio"
							name="gender" value="F">Female</label>
					</div>
					<label class="separator">Department: <select
						name="departmtnt_id">
							<c:forEach items="${depLists}" var="res">
								<option value="${res.getId()}">${res.getName()}</option>
							</c:forEach>
					</select>
					</label> <input type="submit" value="Add"><span id="formCheck"></span>
					<input type="hidden" value="add-new" name="action">
				</form>
			</div>
			<div class="menu-strip cfix">
				<span id="addemp">Add Employee</span>
				<h1>
					<%if(session.getAttribute("page") != null){
						if(session.getAttribute("page").equals("inactive")){
							out.print("Inactive Employees");
						}else{
							out.print("Active Employees");
						}
					}else{
						out.print("All Employees");
					} %>
				</h1>
				<form method="post" action="empManager">
					Sort By:
					<select name="sort-field">
						<option value="fname">Name</option>
						<option value="joined_date">Joined Date</option>
						<option value="name">Department</option>
						<option value="gender">Gender</option>
					</select> 
					<select name="sort-order">
						<option value="ASC">Ascending</option>
						<option value="DESC">Descending</option>
					</select>
					<input type="hidden" value="sortby" name="actionsort">
					<input type="submit" value="Go">
				</form>
				
				
			</div>

			<div class="table-section">
				<table>
					<tr>
						<th>Sn</th>
						<th>Name</th>
						<th>Department</th>
						<th>Gender</th>
						<th>Joined Date</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
					<%int i=0; %>
					<c:forEach items="${userLists}" var="res">


						<tr>
							<td>
								<%out.print(++i);%>
							</td>
							<td>${res.getName()}</td>
							<td>${res.getDepartmentName()}</td>
							<td>${res.getGender()}</td>
							<td>${res.getJoinedDate()}</td>

							<td>
								<a href="empManager?action=act&id=${res.getId()}"
									<c:if test="${res.getStatus()}">class="active"</c:if> onClick="Javascript: return confirm('Are you sure?')"> 
									<c:choose>
											<c:when test="${res.getStatus()}">
							             Active
							        </c:when>
											<c:otherwise>
							            Inactive
							        </c:otherwise>
										</c:choose>
	
								</a>
							</td>
							<td><span id="click${res.getId()}" class="green">Edit</span>
								| <a href="empManager?action=delete&id=${res.getId()}"
								onClick="Javascript: return confirm('Are you sure you want to delete?')">Delete</a></td>
						</tr>
						<tr>
							<td colspan="7" class="edits">
								<div class="edit-form" id="edit${res.getId()}">
									<form method="post" action="empManager"
										onsubmit="Javascript: return validateEdit();">
										<label class="separator">Name: <input type="text"
											name="edited-fname" id="edited-fname"
											placeholder="Enter first name" value="${res.getFName()}"></input>
											<input type="text" name="edited-lname" id="edited-lname"
											placeholder="Enter last name" value="${res.getLName()}"></input>
										</label> <label class="separator">Gender: <select
											name="edited-gender" id="gd">
												<option value="M"
													<c:if test="${res.getGender() eq 'M'}">selected="selected"</c:if>>Male</option>
												<option value="F"
													<c:if test="${res.getGender() eq 'F'}">selected="selected"</c:if>>Female</option>
										</select>
										</label> <label class="separator">Department: <select
											name="edited_department_id" id="gd">
												<c:forEach items="${depLists}" var="resdep">
													<option value="${resdep.getId()}"
														<c:if test="${resdep.getId() == res.getDepartmentId()}">selected="selected"</c:if>>
														${resdep.getName()}</option>


												</c:forEach>

										</select>
										</label> 
										<input type="submit" value="Edit">
										<span id="edited-formCheck"></span> 
										<input type="hidden" value="edit-add" name="action"> 
										<input type="hidden" value="${res.getId()}" name="emp-id">

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