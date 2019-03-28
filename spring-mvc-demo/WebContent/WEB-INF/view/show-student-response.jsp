<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student confirm</title>
</head>
<body>
	<div class='container'>
		<div class="divider"></div>
		<div class='section'>
			<!-- Extract data from model -->
			<p class='col s6 offset-s6'> You are: ${student.firstName}, ${student.lastName} from ${student.country}</p>
		</div>
		<div class="divider"></div>
	</div>
</body>
</html>