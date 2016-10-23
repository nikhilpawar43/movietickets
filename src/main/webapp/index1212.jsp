<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" ng-app="app">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Initial Page</title>
	<!-- <script type = "text/javascript" src="resources/js/angular.js"></script> -->
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-resource.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
	<script type="text/javascript" src="resources/js/controller.js"></script>
	<script type="text/javascript" src="resources/js/app.js"></script>
</head>
<body ng-controller="mainController">
	This is the launcher page
	
	<h2>Spring and Angularjs Tutorial</h2>
		
	<ul>
		<li>
			<a href="#home">Home</a>
		</li>
		<li>
			<a href="#aboutus">About us</a>
		</li>
		<li>
			<a href="#contactus">Contact us</a>
		</li>
	</ul>
	
	<div ng-view>
		
	</div>

</body>
</html>