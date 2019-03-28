<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Result</title>
</head>
<body>
	<h2>Customer Result Screen</h2>
	<p>Customer First Name: ${customer.firstName}</p>
	<p>Customer Last Name: ${customer.lastName}</p>
	<p>Your coupon count is: ${customer.coupons }</p>
	<p>Your zip is: ${customer.zip}</p>
</body>
</html>