var app = angular.module('app', ['ngRoute', 'ngResource']);

app.config(function($routeProvider) {
	
	$routeProvider.
		when('/home', {
			templateUrl: '/resources/views/home.jsp',
			controller: 'mainController'
		}).
		when('/aboutus', {
			templateUrl: 'resources/views/aboutus.jsp',
			controller: 'aboutusController'
			
		}).
		when('/contactus', {
			templateUrl: 'resources/views/contacts.jsp',
			controller: 'contactusController'
		}).		
		when('/adhocbooking', {
			templateUrl: 'resources/views/adhocbooking.jsp',
			controller: 'adhocBookingsController'
		}).
		when('/paymenterror', {
			templateUrl: 'resources/views/error.jsp',
			controller: 'paymentErrorController'
		}).
		when('/paymentDetails/:secureToken/:secureTokenId', {
			templateUrl: 'resources/views/paymentCardDetails.jsp',
			controller: 'paymentDetailsController'
		});
	
});

app.controller('mainController', function($scope) {
	
	$scope.message = "This is my home page";
});

app.controller('aboutusController', function($scope, $http, $resource) {
	
	$scope.message = "This is my aboutus page";
	$scope.users = [];
	
	$scope.getUser = function() {
		
		$http.get('/movietickets/getUserDetails', {
				params : { 'name' : $scope.username}
		
		}).success(function(user) {
			
			$scope.user = user;
		});
	}
	
	$http.get('/movietickets/getUsers').then(function(result) {
		
		$scope.users = result.data;
		
		$scope.option={
	        user: $scope.users[0].id
       }
		
	});
	
	/*console.log('The size of test is: ' + Object.keys($scope.test).length);*/
	
});

app.controller('contactusController', function($scope, $compile) {
	
	$scope.message = "This is my contactus page";
	
	$scope.editAttendee = function($event) {
		
		var editButton = angular.element($event.target);
		var row = $('.editButton').closest('tr');
		
		var firstnameTF = 	'<form name="firstnameForm">' + 
													'<input type="text" name="firstname" ng-model="firstname" class="form-control" ng-pattern="/^[a-zA-Z]*$/" required />' +
													'<span ng-show="firstnameForm.$dirty">' +
														'<span ng-show="firstnameForm.firstname.$error.required && !firstnameForm.firstname.$pristine">Required</span>' +
														'<span ng-show="firstnameForm.firstname.$dirty&&firstnameForm.firstname.$error.pattern">Not a valid first name</span>' +
													'</span>' +
												'</form>';
		
		var lastnameTF = 	'<form name="lastnameForm">' + 
													'<input type="text" name="lastname" ng-model="lastname" class="form-control" ng-pattern="/^[a-zA-Z]*$/" required />' +
													'<span ng-show="lastnameForm.$dirty">' +
														'<span ng-show="lastnameForm.lastname.$error.required && !lastnameForm.lastname.$pristine">Required</span>' +
														'<span ng-show="lastnameForm.lastname.$dirty&&lastnameForm.lastname.$error.pattern">Not a valid last name</span>' +
													'</span>' +
												'</form>';
		
		var firstnameSpan = row.find(".firstname").html();
		var lastnameSpan = row.find(".lastname").html();
		
		row.find(".firstname").html($compile(firstnameTF)($scope));
		row.find(".lastname").html($compile(lastnameTF)($scope));	
			
		$scope.firstname = firstnameSpan;
		$scope.lastname = lastnameSpan;
	}
	
	$scope.saveChanges = function($event) {
		/*console.log('Saving changes');*/
		
		if ($scope.firstnameForm.$valid && $scope.lastnameForm.$valid) {
			alert('Saving the details');
		} else { 
			alert('Please correct the errors and then save the details.');
		}
	}
	
});