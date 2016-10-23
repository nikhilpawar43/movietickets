<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" ng-app="app">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Initial Page</title>
	<!-- <script type = "text/javascript" src="resources/js/angular.js"></script> -->
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-resource.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/controller.js"></script>
	<script type="text/javascript" src="resources/js/controller/adhocBookingsController.js"></script>
	<script type="text/javascript" src="resources/js/controller/paymentErrorController.js"></script>
	<script type="text/javascript" src="resources/js/controller/paymentDetailsController.js"></script>
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body ng-controller="mainController">
	
	<div class="container">
		<h2>Spring and Angularjs Tutorial</h2>
			
		<ul>
			<li>
				<a href="#aboutus">About us</a>
			</li>
			<li>
				<a href="#contactus">Contact us</a>
			</li>
			<li>
				<a href="#adhocbooking">Adhoc booking</a>
			</li>
		</ul>
		
		<div ng-view>
			
		</div>
	</div>	

</body>
</html>