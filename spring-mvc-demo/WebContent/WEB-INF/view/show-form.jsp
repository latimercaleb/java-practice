<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Data Page</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>
<body>
<div class='container'>
	<h4>Version 1: No Model using jsp</h4>
	<form action="processForm" method="GET" class='col s12'>
		<div class='input-field s4 offset-s4'>
		<input type='text'
			    name='userName'
			    placeholder='Who are you??' />
			    <label for='userName'>Name: </label>
		</div>
	     <button class='btn waves-effect waves-light'
	     		 type= 'submit'
	     		 name='action'>Submit</button>
	</form>
	</div>
	<div class='container'>
	<h4>Version 2: With Model</h4>
	<form action="processFormV2" method="GET" class='col s12'>
		<div class='input-field s4 offset-s4'>
		<input type='text'
			    name='userName'
			    placeholder='Who are you??' />
			    <label for='userName'>Name: </label>
		</div>
	     <button class='btn waves-effect waves-light'
	     		 type= 'submit'
	     		 name='action'>Submit</button>
	</form>
	</div>
	<div class='container'>
	<h4>Version 3: With model + annotation</h4>
	<form action="processFormV3" method="GET" class='col s12'>
		<div class='input-field s4 offset-s4'>
		<input type='text'
			    name='userName'
			    placeholder='Who are you??' />
			    <label for='userName'>Name: </label>
		</div>
	     <button class='btn waves-effect waves-light'
	     		 type= 'submit'
	     		 name='action'>Submit</button>
	</form>
	</div>
</body>
</html>