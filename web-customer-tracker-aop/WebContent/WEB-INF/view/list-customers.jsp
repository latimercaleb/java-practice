<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer: List</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link type="text/css" rel='stylesheet' href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
	<div id="wrapper" class='container'>
		<div id='header' class='row'>
			<h2>Hibernate X Spring MVC: CRM App</h2>
		</div>
		<div class='row'>
			<div class='col s3'>
				<a class='pulse btn' href='/web-customer-tracker-aop/customer/show-form'><i class='material-icons'>create</i> Add Customer</a>
			</div>
		</div>
		<div id='content' class='row'>
			<table class='centered highlight z-depth-3'>
				<tr class='teal lighten-2 white-text'>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Actions</th>
				</tr>
				<c:forEach var="i" items="${customers}">
					<c:url var="updateLink" value="/customer/show-form-update">
						<c:param name="customerId" value="${i.id}"/>
					</c:url>
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${i.id}"/>
					</c:url>
					<tr>
						<td>${i.firstName}</td>
						<td>${i.lastName}</td>
						<td>${i.email}</td>
						<td><a href="${updateLink}">update</a> | <a onclick="return confirm('Delete Customer?')" href="${deleteLink}" >delete</a></td>
					</tr>		
				</c:forEach>			
			</table>
		</div>
	</div>
</body>
</html>