<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Form</title>
<style>
	.error{
		color: red;
		font-style: italic;
	}
</style>
</head>
<body>
<h3>Note the * means required!</h3>
	<form:form action="processCustomer" modelAttribute="customer">
	First Name: <form:input path="firstName" /> 
	Last Name(*):  <form:input path="lastName"/>
	<!-- Errors only render when triggered, bind it to the same path that you want to validate on and add an optional cssClass to do error styles -->
	<form:errors path="lastName" cssClass="error" />
	
	Coupon Count: <form:input path="coupons"/>
	<form:errors path="coupons" cssClass="error" />
	
	Zip Code: <form:input path="zip"/>
	<form:errors path="zip" cssClass="error" />
	
	<input type="submit" value="submit"/> 
	</form:form>
</body>
</html>