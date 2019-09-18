<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer: Form</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link type="text/css" rel='stylesheet' href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
	<div id="wrapper" class='container'>
		<div id='header' class='row'>
			<h2>Hibernate X Spring MVC: CRM Form</h2>
		</div>
		<div id='content' class='row'>
			<form:form action="save-form" modelAttribute="customer" method="POST" class='col s12'>
				<form:hidden path="id"/>
				<div class="row">
		        <div class="input-field col s6 offset-s3">
		          <i class="material-icons prefix">account_circle</i>
		          <form:input path="firstName" id="firstName" type="text" class="validate" />
		          <label for="firstName" class='active'>First Name</label>
		        </div>
		      </div>
		      <div class='row'>
		      	<div class="input-field col s6 offset-s3">
		          <i class="material-icons prefix">account_circle</i>
		          <form:input path="lastName" id="lastName" type="text" class="validate" />
		          <label for="lastName" class='active'>Last Name</label>
		        </div>
		      </div>
		      <div class="row">
		        <div class="input-field col s6 offset-s3">
		          <i class="material-icons prefix">email</i>
		          <form:input path="email" id="email" type="text" class="validate"/>
		          <label for="email" class='active'>Email</label>
		        </div>
		      </div>
		      <div class='row'>
				<div class='col s3 offset-s3'>
					<input class='pulse btn'  value="Create Customer" type="submit"/>
				</div>
				<div class='col s3 offset-s3'>
					<a class='btn' href='/web-customer-tracker/customer/list'><i class='material-icons'>exit_to_app</i> Go back</a>
				</div>
			 </div>
			</form:form>
		</div>
	</div>
</body>
</html>