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
		<form:select path="countryFromHashSet">
			<form:options items="${student.countryContainer}"/>
		</form:select>
		<br><br>
		<!-- Radio Button practice, could also use hashset and iterate like above, make sure to bind path to the property with get and set in Student class 
			Get is called on page fetch, set is called on clicking submit and the data gets written to the referrence on the model
		-->
		Favorite Language:
		Java<form:radiobutton path="favoriteLanguage" value="Java" />
		JavaScript<form:radiobutton path="favoriteLanguage" value="JavaScript" />
		PHP<form:radiobutton path="favoriteLanguage" value="PHP" />
		SQL<form:radiobutton path="favoriteLanguage" value="SQL" />
		Swift<form:radiobutton path="favoriteLanguage" value="Swift" />
		<br><br>
		<!-- Check Box Practice, ideally since a checkbox can be a list of multiple selections. It should be bound in the controller with an array, not a string.-->
		Favorite OS:
		Linux<form:checkbox      path="systemOS" value="Linux" />
		Mac<form:checkbox        path="systemOS" value="Mac"/>
		MS Windows<form:checkbox path="systemOS" value="Windows"/>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>