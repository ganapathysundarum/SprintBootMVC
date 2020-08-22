<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Application</title>
</head>
<body>

	<div class="container">
		<table class="table table-striped">
			<caption>Logged In Employee details are</caption>
			<thead>
				<tr>
					<th>Employee ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Middle Name</th>
					<th>DOB</th>
					<th>Sex</th>
					<th>DOJ</th>
					<th>Sex</th>
					<th>Base Branch</th>
					<th>Location</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="emp">
					<tr>
						<td>${emp.empId}</td>
						<td>${emp.empFName}</td>
						<td>${emp.empLName}</td>
						<td>${emp.empMName}</td>
						<td>${emp.empDOB}</td>						
						<td>${emp.empSex}</td>
						<td>${emp.empDOJ}</td>
						<td>${emp.empBaseBranch}</td>
						<td>${emp.empLocation}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<a class="button" href="/login">Signout</a>
	</div>
</body>
</html>
