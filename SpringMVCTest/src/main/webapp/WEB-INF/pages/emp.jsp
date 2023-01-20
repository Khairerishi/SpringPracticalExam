<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<sf:form action="/SpringMVCTest/mvc/login" modelAttribute="emp">
		
		<table border="1">
		<hr>*All Fields are compulsory</hr>
			<tr>
				<td>Id: </td>
				<td><sf:input id="txtId" path="id"/> </td> 
			</tr>
			<tr>
				<td>Full Name: </td>
				<td><sf:input id="txtName" path="name"/> </td> 
			</tr>
			<tr>
				<td>Address: </td>
				<td> <sf:input id="txtAddress" path="address"/> </td>
			</tr>
			<tr>
				<td>EmailId: </td>
				<td> <sf:input id="txtEmailId" path="emailId"/> </td>
			</tr>
			<tr>
				<td>Mobile: </td>
				<td><sf:input id="txtMobile" path="mobile"/> </td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td> <sf:input id="txtPassword" path="password" type="password" showPassword="false"/> </td>
			<tr/>
			
			<tr>
				<td>Confirm Password</td>
				<td> <sf:input id="txtConfirmPassword" path="ConfirmPassword" type="password" showPassword="false"/> </td>
			<tr/>
			<tr>
				<td colspan="2">
					<input type="submit" value="Register Me" />
				</td>
			</tr>
		</table>
		
	</sf:form>
	
	<br/>
	
	
	<c:if test="${not empty listEmp}">
		
		<table border="1">
			
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>EmailId</th>
					<th>Mobile</th>
					<th>Address</th>
					
				</tr>
			</thead>
			<c:forEach var="emp" items="${listEmp }">
				
				<tr>
					<td>${emp.id }</td>
					<td>${emp.name }</td>
					<td>${emp.emailId }</td>
					<td>${emp.mobile }</td>
					<td>${emp.address }</td>
					
				</tr>
				
			</c:forEach>
			
			
		</table>
		
	</c:if>
	
		

</body>
</html>


