<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Form</title>
</head>
<body>
	<h1>The Student form</h1>
	<!-- Import is at the top, now generate the form with the form tags -->
	<form:form action="processStudentForm" modelAttribute="student">
		<!-- These paths have getters defined in the model via the type used  -->
		First Name: <form:input path="firstName" />
		<br><br>
		Last Name: <form:input path="lastName" />
		<br><br>
		<!-- Drop down list practice -->
		Hard-coded Country options
		<form:select path="country">
			<form:option value="USA" label="USA"/>
			<form:option value="Nigeria" label="Nigeria"/>
			<form:option value="Japan" label="Japan"/>
			<form:option value="Poland" label="Poland"/>
		</form:select>
		<br><br>
		Non-hard-coded Country options
		<form:select path="countryContainer">
			<form:options items="${student.countryContainer}"/>
		</form:select>
		<!-- Drop down list practice -->
		<br><br>
		<!-- Radio Button Practice -->
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>